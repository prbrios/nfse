package com.github.prbrios.nfse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assinatura {

    private Configuracao configuracao;

    public Assinatura(Configuracao configuracao) throws Exception {
        if (configuracao == null)
            throw new Exception("Configuracao nao informada");

        this.configuracao = configuracao;
    }

    private static final String C14N_TRANSFORM_METHOD = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";

    private static final String[] ELEMENTOS_ASSINAVEIS = new String[]{
        "InfRps", "LoteRps", "ConsultarSituacaoLoteRpsEnvio"
    };

    public String assinar(final String conteudoXml) throws Exception {
        return this.assinar(conteudoXml, Assinatura.ELEMENTOS_ASSINAVEIS);
    }

    public String assinar(final String conteudoXml, final String... elementosAssinaveis) throws Exception {
        try (StringReader reader = new StringReader(conteudoXml)) {
            try (StringWriter writer = new StringWriter()) {
                this.assinar(reader, writer, elementosAssinaveis);
                return writer.toString();
            }
        }
    }

    public void assinar(Reader xmlReader, Writer xmlAssinado, final String... elementosAssinaveis) throws Exception {

        final KeyStore.PrivateKeyEntry keyEntry = this.getPrivateKeyEntry();
        final XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
        final List<Transform> transforms = new ArrayList<>(2);
        transforms.add(signatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
        transforms.add(signatureFactory.newTransform(Assinatura.C14N_TRANSFORM_METHOD, (TransformParameterSpec) null));
        final KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        final X509Data x509Data = keyInfoFactory.newX509Data(Collections.singletonList((X509Certificate) keyEntry.getCertificate()));
        final KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        final Document document = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(xmlReader));
        for (final String elementoAssinavel : elementosAssinaveis) {
            final NodeList elements = document.getElementsByTagName(elementoAssinavel);
            for (int i = 0; i < elements.getLength(); i++) {
                final Element element = (Element) elements.item(i);
                final String id = element.getAttribute("Id");
                element.setIdAttribute("Id", true);
                final Reference reference = signatureFactory.newReference("#" + id, signatureFactory.newDigestMethod(DigestMethod.SHA1, null), transforms, null, null);
                final SignedInfo signedInfo = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(reference));
                final XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);
                signature.sign(new DOMSignContext(keyEntry.getPrivateKey(), element.getParentNode()));
            }
        }

        final Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        transformer.transform(new DOMSource(document), new StreamResult(xmlAssinado));

    }

    private KeyStore.PrivateKeyEntry getPrivateKeyEntry() throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableEntryException, IOException, CertificateException {

        KeyStore keyStoreCertificado = KeyStore.getInstance("PKCS12");
        try (InputStream certificadoStream = new FileInputStream(this.configuracao.getCertificado())) {
            keyStoreCertificado.load(certificadoStream, this.configuracao.getSenhaCertificado().toCharArray());

            final KeyStore.PasswordProtection passwordProtection = new KeyStore.PasswordProtection(this.configuracao.getSenhaCertificado().toCharArray());
            return (KeyStore.PrivateKeyEntry) keyStoreCertificado.getEntry(keyStoreCertificado.aliases().nextElement(), passwordProtection);

        } catch (KeyStoreException| NoSuchAlgorithmException| UnrecoverableEntryException| IOException| CertificateException e) {
            throw e;
        }
    }

    public String assinarRaiz(final String xmlReader) throws Exception {

        final KeyStore.PrivateKeyEntry keyEntry = this.getPrivateKeyEntry();
        final XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");

        final List<Transform> transforms = new ArrayList<>(2);
        transforms.add(signatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
        transforms.add(signatureFactory.newTransform(Assinatura.C14N_TRANSFORM_METHOD, (TransformParameterSpec) null));

        final KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        final X509Data x509Data = keyInfoFactory.newX509Data(Collections.singletonList((X509Certificate) keyEntry.getCertificate()));
        final KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        final Document document = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new StringReader(xmlReader)));

        Reference ref = signatureFactory.newReference("", signatureFactory.newDigestMethod(DigestMethod.SHA1, null),transforms, null, null);
        SignedInfo si = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,(C14NMethodParameterSpec) null),signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1,null),Collections.singletonList(ref));
        DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), document.getDocumentElement());
        XMLSignature signature = signatureFactory.newXMLSignature(si, keyInfo);
        signature.sign(dsc);

        StringWriter sw = new StringWriter();
        final Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        transformer.transform(new DOMSource(document), new StreamResult(sw));

        return sw.toString();
    }

}
