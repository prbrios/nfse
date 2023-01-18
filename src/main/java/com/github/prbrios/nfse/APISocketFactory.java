package com.github.prbrios.nfse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

public class APISocketFactory implements ProtocolSocketFactory {

    private final SSLContext sslContext;

    private String diretorioKeyStore;
    private String diretorioTrustStore;
    private String senhaKeyStore;
    private String senhaTrustStore;
    private String[] sslProtocols = new String[]{"TLSv1.2"};

    public APISocketFactory(final String diretorioKeyStore, final String senhaKeyStore, final String diretorioTrustStore, final String senhaTrustStore) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        this.diretorioKeyStore = diretorioKeyStore;
        this.senhaKeyStore = senhaKeyStore;
        this.diretorioTrustStore = diretorioTrustStore;
        this.senhaTrustStore = senhaTrustStore;

        this.sslContext = this.createSSLContext();
    }

    @Override
    public Socket createSocket(final String host, final int port, final InetAddress localAddress, final int localPort, final HttpConnectionParams params) throws IOException {
        final Socket socket = this.sslContext.getSocketFactory().createSocket();
        ((SSLSocket) socket).setEnabledProtocols(this.sslProtocols);
        socket.bind(new InetSocketAddress(localAddress, localPort));
        socket.connect(new InetSocketAddress(host, port), 60000);
        return socket;
    }

    @Override
    public Socket createSocket(final String host, final int port, final InetAddress clientHost, final int clientPort) throws IOException {
        return this.sslContext.getSocketFactory().createSocket(host, port, clientHost, clientPort);
    }

    @Override
    public Socket createSocket(final String host, final int port) throws IOException {
        return this.sslContext.getSocketFactory().createSocket(host, port);
    }

    private SSLContext createSSLContext() throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        final KeyManager[] keyManagers = this.createKeyManagers();
        final TrustManager[] trustManagers = this.createTrustManagers();
        final SSLContext sslContext = SSLContext.getInstance(this.sslProtocols[0]);
        sslContext.init(keyManagers, trustManagers, null);
        return sslContext;
    }

    private KeyManager[] createKeyManagers() throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        KeyStore keyStore = this.getCertificadoKeyStore();
        final String alias = APISocketFactory.getAlias(keyStore);
        final X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);
        final PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, this.senhaKeyStore.toCharArray());
        return new KeyManager[]{new DFKeyManager(certificate, privateKey)};
    }

    private TrustManager[] createTrustManagers() throws KeyStoreException, NoSuchAlgorithmException {
        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(this.getCadeiaCertificadosKeyStore());
        return trustManagerFactory.getTrustManagers();
    }

    private static String getAlias(final KeyStore ks) throws KeyStoreException {
        final Enumeration<String> aliasesEnum = ks.aliases();
        while (aliasesEnum.hasMoreElements()) {
            final String alias = aliasesEnum.nextElement();
            if (ks.isKeyEntry(alias)) {
                return alias;
            }
        }
        throw new KeyStoreException("Nenhum alias encontrado no certificado");
    }

    private KeyStore keyStoreCertificado = null;
    private KeyStore keyStoreCadeia = null;

    private KeyStore getCertificadoKeyStore() throws KeyStoreException {
        if (this.keyStoreCertificado == null) {
            this.keyStoreCertificado = KeyStore.getInstance("PKCS12");
            try (InputStream certificadoStream = new FileInputStream(this.diretorioKeyStore)) {
                this.keyStoreCertificado.load(certificadoStream, this.senhaKeyStore.toCharArray());
            } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                this.keyStoreCadeia = null;
                throw new KeyStoreException("Nao foi possibel montar o KeyStore com a cadeia de certificados", e);
            }
        }
        return this.keyStoreCertificado;
    }

    private KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException {
        if (this.keyStoreCadeia == null) {
            this.keyStoreCadeia = KeyStore.getInstance("JKS");
            try (InputStream cadeia = new FileInputStream(this.diretorioTrustStore)) {
                this.keyStoreCadeia.load(cadeia, this.senhaTrustStore.toCharArray());
            } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                this.keyStoreCadeia = null;
                throw new KeyStoreException("Nao foi possibel montar o KeyStore com o certificado", e);
            }
        }
        return this.keyStoreCadeia;
    }

    static class DFKeyManager implements X509KeyManager {

        private final X509Certificate certificate;
        private final PrivateKey privateKey;

        DFKeyManager(final X509Certificate certificate, final PrivateKey privateKey) {
            this.certificate = certificate;
            this.privateKey = privateKey;
        }

        @Override
        public String chooseClientAlias(final String[] arg0, final Principal[] arg1, final Socket arg2) {
            return this.certificate.getIssuerDN().getName();
        }

        @Override
        public String chooseServerAlias(final String arg0, final Principal[] arg1, final Socket arg2) {
            return null;
        }

        @Override
        public X509Certificate[] getCertificateChain(final String arg0) {
            return new X509Certificate[]{this.certificate};
        }

        @Override
        public String[] getClientAliases(final String arg0, final Principal[] arg1) {
            return new String[]{this.certificate.getIssuerDN().getName()};
        }

        @Override
        public PrivateKey getPrivateKey(final String arg0) {
            return this.privateKey;
        }

        @Override
        public String[] getServerAliases(final String arg0, final Principal[] arg1) {
            return null;
        }
    }
}