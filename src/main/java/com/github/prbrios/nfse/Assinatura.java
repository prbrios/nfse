package com.github.prbrios.nfse;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Assinatura {

    public String assinar(String xml, String element, InputStream certificate, String password) throws Exception {

        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(certificate, password.toCharArray());
        certificate.close();
        String alias = ks.aliases().nextElement();
        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, password.toCharArray());
        X509Certificate cert = (X509Certificate) ks.getCertificate(alias);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        doc.getDocumentElement().normalize();

        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

        KeyInfoFactory kif = fac.getKeyInfoFactory();
        X509Data x509Data = kif.newX509Data(Collections.singletonList(cert));
        KeyInfo keyInfo = kif.newKeyInfo(Collections.singletonList(x509Data));

        if ("InfRps".equals(element)) {

            NodeList infRpsList = doc.getElementsByTagName("InfRps");

            for (int i = 0; i < infRpsList.getLength(); i++) {
                org.w3c.dom.Element infRpsElement = (org.w3c.dom.Element) infRpsList.item(i);
                String infRpsId = infRpsElement.getAttribute("Id");

                if (infRpsId == null || infRpsId.isEmpty()) {
                    throw new IllegalStateException("Atributo Id não encontrado ou vazio no InfRps " + i);
                }

                infRpsElement.setIdAttribute("Id", true);

                List<Transform> transforms = Arrays.asList(
                    fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null),
                    fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (TransformParameterSpec) null)
                );

                Reference ref = fac.newReference("#" + infRpsId,
                    fac.newDigestMethod(javax.xml.crypto.dsig.DigestMethod.SHA1, null),
                    transforms, null, null);

                SignedInfo signedInfo = fac.newSignedInfo(
                    fac.newCanonicalizationMethod("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (C14NMethodParameterSpec) null),
                    fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(ref));

                XMLSignature xmlSignature = fac.newXMLSignature(signedInfo, keyInfo);

                org.w3c.dom.Element rpsElement = (org.w3c.dom.Element) infRpsElement.getParentNode();
                DOMSignContext signContext = new DOMSignContext(privateKey, rpsElement);

                xmlSignature.sign(signContext);

                limparQuebrasDeLinhaAssinatura(rpsElement);
            }

        } else if ("LoteRps".equals(element)) {

            org.w3c.dom.Element loteRpsElement = (org.w3c.dom.Element) doc.getElementsByTagName("LoteRps").item(0);

            if (loteRpsElement == null) {
                throw new IllegalStateException("Tag LoteRps não encontrada");
            }

            String loteId = loteRpsElement.getAttribute("Id");
            if (loteId == null || loteId.isEmpty()) {
                throw new IllegalStateException("Atributo Id não encontrado ou vazio no LoteRps");
            }

            loteRpsElement.setIdAttribute("Id", true);

            List<Transform> transforms = Arrays.asList(
                fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null),
                fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (TransformParameterSpec) null)
            );

            Reference ref = fac.newReference("#" + loteId,
                fac.newDigestMethod(javax.xml.crypto.dsig.DigestMethod.SHA1, null),
                transforms, null, null);

            SignedInfo signedInfo = fac.newSignedInfo(
                fac.newCanonicalizationMethod("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (C14NMethodParameterSpec) null),
                fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                Collections.singletonList(ref));

            XMLSignature xmlSignature = fac.newXMLSignature(signedInfo, keyInfo);

            org.w3c.dom.Element enviarLoteRpsEnvio = doc.getDocumentElement();
            DOMSignContext signContext = new DOMSignContext(privateKey, enviarLoteRpsEnvio);

            xmlSignature.sign(signContext);

            limparQuebrasDeLinhaAssinatura(enviarLoteRpsEnvio);

        } else {

            org.w3c.dom.Element rootElement = doc.getDocumentElement();
            List<Transform> transforms = Arrays.asList(
                fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null),
                fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (TransformParameterSpec) null)
            );

            Reference ref = fac.newReference("",
                fac.newDigestMethod(javax.xml.crypto.dsig.DigestMethod.SHA1, null),
                transforms, null, null);

            SignedInfo signedInfo = fac.newSignedInfo(
                fac.newCanonicalizationMethod("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (C14NMethodParameterSpec) null),
                fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                Collections.singletonList(ref));

            XMLSignature xmlSignature = fac.newXMLSignature(signedInfo, keyInfo);
            DOMSignContext signContext = new DOMSignContext(privateKey, rootElement);
            xmlSignature.sign(signContext);

            limparQuebrasDeLinhaAssinatura(rootElement);

        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");

        StringWriter sw = new StringWriter();
        transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        transformer.transform(new DOMSource(doc), new StreamResult(sw));

        return sw.toString();

    }

    private void limparQuebrasDeLinhaAssinatura(org.w3c.dom.Element elemento) {

        String[] elementosBase64 = {
            "SignatureValue",
            "X509Certificate",
            "DigestValue",
            "X509SKI",
            "X509CRL"
        };

        // Buscar apenas Signatures que são filhas DIRETAS do elemento
        NodeList filhos = elemento.getChildNodes();
        org.w3c.dom.Element signature = null;

        // Procurar a última Signature filha direta (a que acabamos de adicionar)
        for (int i = filhos.getLength() - 1; i >= 0; i--) {
            Node node = filhos.item(i);
            if (node instanceof org.w3c.dom.Element) {
                org.w3c.dom.Element elem = (org.w3c.dom.Element) node;
                if ("Signature".equals(elem.getLocalName()) &&
                    XMLSignature.XMLNS.equals(elem.getNamespaceURI())) {
                    signature = elem;
                    break;
                }
            }
        }

        // Limpar quebras de linha da Signature encontrada
        if (signature != null) {
            for (String elementName : elementosBase64) {
                NodeList nodes = signature.getElementsByTagNameNS(XMLSignature.XMLNS, elementName);
                for (int j = 0; j < nodes.getLength(); j++) {
                    Node node = nodes.item(j);
                    String content = node.getTextContent();
                    if (content != null) {
                        node.setTextContent(content.replaceAll("\\s+", ""));
                    }
                }
            }
        }
    }

}
