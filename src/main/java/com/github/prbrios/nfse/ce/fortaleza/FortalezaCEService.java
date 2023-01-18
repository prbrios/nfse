package com.github.prbrios.nfse.ce.fortaleza;

import com.github.prbrios.nfse.*;
import com.github.prbrios.nfse.ce.fortaleza.webservice.ServiceGinfesImplServiceServiceStub;
import com.github.prbrios.nfse.impressao.Impressao;
import com.github.prbrios.nfse.impressao.InformacoesPrestador;
import com.github.prbrios.nfse.model.ginfes.v2.CancelarNfseEnvio;
import com.github.prbrios.nfse.model.ginfes.v2.CancelarNfseResposta;
import com.github.prbrios.nfse.model.ginfes.v3.ConsultarLoteRpsEnvio;
import com.github.prbrios.nfse.model.ginfes.v3.ConsultarLoteRpsResposta;
import com.github.prbrios.nfse.model.ginfes.v3.EnviarLoteRpsEnvio;
import com.github.prbrios.nfse.model.ginfes.v3.EnviarLoteRpsResposta;

import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.simpleframework.xml.core.Persister;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.Base64;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

public class FortalezaCEService implements Servico<EnviarLoteRpsEnvio, EnviarLoteRpsResposta, ConsultarLoteRpsEnvio, ConsultarLoteRpsResposta, CancelarNfseEnvio, CancelarNfseResposta> {
    private static final Logger LOG = LoggerFactory.getLogger(FortalezaCEService.class);
    private Configuracao config;
    private Persister persister;
    private static final String FALHA_CNPJ_SERIE_NUMERO = "Falha ao obter CNPJ do prestador, serie e numero do RPS do objeto enviarLoteRpsEnvio";
    private static final String FALHA_CNPJ_PROTOCOLO = "Falha ao obter o CNPJ do prestador e o protocolo do objeto consultarLoteRpsEnvio";
    private static final String FALHA_CNPJ_NUMERO = "Falha ao obter o CNPJ do prestador e o numero da NFS-e do objeto cancelarNfseEnvio";
    private static final String FALHA_SALVAR_ARQUIVO = "Falha ao salvar o arquivo %s";

    public FortalezaCEService(Configuracao config) throws Exception {
        this.persister = new Persister(new Format(0));
        this.config = config;

        ProtocolSocketFactory socket = new APISocketFactory(this.config.getCertificado(), this.config.getSenhaCertificado(), "cacerts", "123456");
        Protocol.registerProtocol("https", new Protocol("https", socket, 443));
    }

    @Override
    public EnviarLoteRpsResposta enviarLoteRps(EnviarLoteRpsEnvio enviarLoteRpsEnvio) throws Exception {

        LOG.trace("enviarLoteRps - inicio");

        try {

            String cnpj = null;
            String serie = null;
            String numero = null;

            try {
                cnpj = enviarLoteRpsEnvio.getLoteRps().getListaRps().getRps().get(0).getInfRps().getPrestador().getCnpj();
                serie = enviarLoteRpsEnvio.getLoteRps().getListaRps().getRps().get(0).getInfRps().getIdentificacaoRps().getSerie();
                numero = enviarLoteRpsEnvio.getLoteRps().getListaRps().getRps().get(0).getInfRps().getIdentificacaoRps().getNumero();
                LOG.trace(String.format("Prestador: %s, Serie RPS: %s, Numero RPS: %s", cnpj, serie, numero));
            } catch (Exception e) {
                LOG.trace(enviarLoteRpsEnvio.toString());
                LOG.error(FALHA_CNPJ_SERIE_NUMERO);
                throw new Exception(FALHA_CNPJ_SERIE_NUMERO);
            }

            String enviarLoteRpsEnvioStrAss =
                this.assinarEnviarLoteRpsEnvio(enviarLoteRpsEnvio).toString();

            this.salvarArquivo(String.format("EnviarLoteRpsEnvio-%s-%s-%s-%s.xml", System.currentTimeMillis(), cnpj, serie, numero), enviarLoteRpsEnvioStrAss);

            ServiceGinfesImplServiceServiceStub.RecepcionarLoteRpsV3 recepcionarLoteRpsV3 =
                new ServiceGinfesImplServiceServiceStub.RecepcionarLoteRpsV3();
            recepcionarLoteRpsV3.setEnviarLoteRpsEnvio(enviarLoteRpsEnvioStrAss);

            ServiceGinfesImplServiceServiceStub stub =
                new ServiceGinfesImplServiceServiceStub(this.config.getAmbiente().getUrl());

            ServiceGinfesImplServiceServiceStub.RecepcionarLoteRpsV3Response recepcionarLoteRpsV3Response;
            try {
                recepcionarLoteRpsV3Response = stub.recepcionarLoteRpsV3(recepcionarLoteRpsV3);
            } catch (RemoteException e) {
                LOG.error("Falha ao comunicar com o webservice " + this.config.getAmbiente().getUrl());
                throw e;
            }

            String enviarLoteRpsResposta = recepcionarLoteRpsV3Response.getEnviarLoteRpsResposta();
            LOG.trace("XML-RESPOSTA: " + enviarLoteRpsResposta);

            this.salvarArquivo(String.format("EnviarLoteRpsResposta-%s-%s-%s-%s.xml", System.currentTimeMillis(), cnpj, serie, numero), enviarLoteRpsResposta);

            try {
                return (EnviarLoteRpsResposta) this.persister.read(EnviarLoteRpsResposta.class, enviarLoteRpsResposta);
            } catch (Exception e) {
                LOG.error("Erro ao converter XML-RESPOSTA em objeto EnviarLoteRpsResposta");
                throw e;
            }

        } catch (Exception e) {

            LOG.error(e.getMessage());
            throw e;

        } finally {
            LOG.trace("enviarLoteRps - fim");
        }
    }

    @Override
    public ConsultarLoteRpsResposta consultarLoteRps(ConsultarLoteRpsEnvio consultarLoteRpsEnvio) throws Exception {

        LOG.trace("consultarLoteRps - inicio");

        try {

            String cnpj = null;
            String protocolo = null;

            try {
                cnpj = consultarLoteRpsEnvio.getPrestador().getCnpj();
                protocolo = consultarLoteRpsEnvio.getProtocolo();
                LOG.trace(String.format("Prestador: %s, Protocolo: %s", cnpj, protocolo));
            } catch(Exception e) {
                LOG.trace(consultarLoteRpsEnvio.toString());
                LOG.error(FALHA_CNPJ_PROTOCOLO);
                throw new Exception(FALHA_CNPJ_PROTOCOLO);
            }

            ConsultarLoteRpsEnvio consultarLoteRpsEnvioAss =
                this.assinarConsultarLoteRpsEnvio(consultarLoteRpsEnvio);

            this.salvarArquivo(String.format("ConsultarLoteRpsEnvio-%s-%s-%s.xml", System.currentTimeMillis(), cnpj, protocolo), consultarLoteRpsEnvioAss.toString());

            ServiceGinfesImplServiceServiceStub.ConsultarLoteRpsV3 consultarLoteRpsV3 =
                new ServiceGinfesImplServiceServiceStub.ConsultarLoteRpsV3();
            consultarLoteRpsV3.setConsultarLoteRpsEnvio(consultarLoteRpsEnvioAss.toString());

            ServiceGinfesImplServiceServiceStub stub =
                new ServiceGinfesImplServiceServiceStub(this.config.getAmbiente().getUrl());

            ServiceGinfesImplServiceServiceStub.ConsultarLoteRpsV3Response result = null;
            try {
                result = stub.consultarLoteRpsV3(consultarLoteRpsV3);
            } catch (RemoteException e) {
                LOG.error("Falha ao comunicar com o webservice " + this.config.getAmbiente().getUrl());
                throw e;
            }

            String consultarLoteRpsRespostaString = result.getConsultarLoteRpsResposta();
            LOG.trace("XML-RESPOSTA: " + consultarLoteRpsRespostaString);

            this.salvarArquivo(String.format("ConsultarLoteRpsResposta-%s-%s-%s.xml", System.currentTimeMillis(), cnpj, protocolo), consultarLoteRpsRespostaString);

            try {
                return this.persister.read(ConsultarLoteRpsResposta.class, consultarLoteRpsRespostaString);
            } catch (Exception e) {
                LOG.error("Erro ao converter XML-RESPOSTA em objeto ConsultarLoteRpsResposta");
                throw e;
            }

        } catch (Exception e) {

            LOG.error(e.getMessage());
            throw e;

        } finally {
            LOG.trace("consultarLoteRps - fim");
        }
    }

    @Override
    public CancelarNfseResposta cancelarNfse(CancelarNfseEnvio cancelarNfseEnvio) throws Exception {

        LOG.trace("cancelarNfse - inicio");

        try {

            String cnpj = null;
            String numero = null;

            try {
                cnpj = cancelarNfseEnvio.getPrestador().getCnpj();
                numero = cancelarNfseEnvio.getNumeroNfse();
                LOG.trace(String.format("Prestador: %s, Numero NFS-e: %s", cnpj, numero));
            } catch (Exception e) {
                LOG.trace(cancelarNfseEnvio.toString());
                LOG.error(FALHA_CNPJ_NUMERO);
                throw new Exception(FALHA_CNPJ_NUMERO);
            }

            CancelarNfseEnvio cancelarNfseEnvioAss =
                this.assinarCancelarNfseEnvio(cancelarNfseEnvio);

            this.salvarArquivo(String.format("CancelarNfseEnvio-%s-%s-%s.xml", System.currentTimeMillis(), cnpj, numero), cancelarNfseEnvioAss.toString());

            ServiceGinfesImplServiceServiceStub.CancelarNfse cancelarNfse =
                new ServiceGinfesImplServiceServiceStub.CancelarNfse();
            cancelarNfse.setCancelarNfseEnvio(cancelarNfseEnvioAss.toString());

            ServiceGinfesImplServiceServiceStub stub =
                new ServiceGinfesImplServiceServiceStub(this.config.getAmbiente().getUrl());

            ServiceGinfesImplServiceServiceStub.CancelarNfseResponse result = null;
            try {
                result = stub.cancelarNfse(cancelarNfse);
            } catch (RemoteException e) {
                LOG.error("Falha ao comunicar com o webservice " + this.config.getAmbiente().getUrl());
                throw e;
            }

            String cancelarNfseResponseString = result.getCancelarNfseResposta();
            LOG.trace("XML-RESPOSTA: " + cancelarNfseResponseString);

            this.salvarArquivo(String.format("CancelarNfseResposta-%s-%s-%s.xml", System.currentTimeMillis(), cnpj, numero), cancelarNfseResponseString);

            try {
                return this.persister.read(CancelarNfseResposta.class, cancelarNfseResponseString);
            } catch (Exception e) {
                LOG.error("Erro ao converter XML-RESPOSTA em objeto CancelarNfseResposta");
                throw e;
            }

        } catch (Exception e) {

            LOG.error(e.getMessage());
            throw e;

        } finally {
            LOG.trace("cancelarNfse - fim");
        }
    }

    @Override
    public Impressao impressao(String xml, String logomarca, boolean cancelada, InformacoesPrestador prestador) throws Exception {
        return new FortalezaCEImpressao(xml, logomarca, cancelada, prestador);
    }

    private CancelarNfseEnvio assinarCancelarNfseEnvio(CancelarNfseEnvio cancelarNfseEnvio) throws Exception {
        LOG.trace("Realizando a assinatura do XML");

        String cancelarNfseEnvioStr = cancelarNfseEnvio.toString();
        LOG.trace("XML a ser assinado (Base64): " + Base64.getEncoder().encodeToString(cancelarNfseEnvioStr.getBytes()));

        try {

            String cancelarNfseEnvioStrAss = new Assinatura(this.config).assinarRaiz(cancelarNfseEnvio.toString());
            LOG.trace("XML assinado (Base64): " + Base64.getEncoder().encodeToString(cancelarNfseEnvioStrAss.getBytes()));

            try {
                return this.persister.read(CancelarNfseEnvio.class, cancelarNfseEnvioStrAss);
            } catch (Exception e) {
                LOG.error("Falha ao converter XML assinado em objeto do tipo CancelarNfseEnvio");
                throw e;
            }

        } catch (Exception e) {
            LOG.error("Falha ao tentar realizar a assinatura do XML");
            throw e;
        }
    }

    private ConsultarLoteRpsEnvio assinarConsultarLoteRpsEnvio(ConsultarLoteRpsEnvio consultarLoteRpsEnvio) throws Exception {
        LOG.trace("Realizando a assinatura do XML");

        String consultarLoteRpsEnvioStr = consultarLoteRpsEnvio.toString();
        LOG.trace("XML a ser assinado (Base64): " + Base64.getEncoder().encodeToString(consultarLoteRpsEnvioStr.getBytes()));

        try {

            String consultarLoteRpsEnvioStrAss = new Assinatura(this.config).assinarRaiz(consultarLoteRpsEnvioStr);
            LOG.trace("XML assinado (Base64): " + Base64.getEncoder().encodeToString(consultarLoteRpsEnvioStrAss.getBytes()));

            try {
                return this.persister.read(ConsultarLoteRpsEnvio.class, consultarLoteRpsEnvioStrAss);
            } catch (Exception e) {
                LOG.error("Falha ao converter XML assinado em objeto do tipo ConsultarLoteRpsEnvio");
                throw e;
            }

        } catch (Exception e) {
            LOG.error("Falha ao tentar realizar a assinatura do XML");
            throw e;
        }

    }

    private EnviarLoteRpsEnvio assinarEnviarLoteRpsEnvio(EnviarLoteRpsEnvio enviarLoteRpsEnvio) throws Exception {
        LOG.trace("Realizando a assinatura do XML");

        String enviarLoteRpsEnvioStr = enviarLoteRpsEnvio.toString();
        LOG.trace("XML a ser assinado (Base64): " + Base64.getEncoder().encodeToString(enviarLoteRpsEnvioStr.getBytes()));

        try {

            String enviarLoteRpsEnvioStrAssinado = new Assinatura(this.config).assinar(enviarLoteRpsEnvioStr);
            LOG.trace("XML assinado (Base64): " + Base64.getEncoder().encodeToString(enviarLoteRpsEnvioStrAssinado.getBytes()));

            try {
                return this.persister.read(EnviarLoteRpsEnvio.class, enviarLoteRpsEnvioStrAssinado);
            } catch (Exception e) {
                LOG.error("Falha ao converter XML assinado em objeto do tipo EnviarLoteRpsEnvio");
                throw e;
            }

        } catch (Exception e) {
            LOG.error("Falha ao tentar realizar a assinatura do XML");
            throw e;
        }
    }

    private void salvarArquivo(final String nomeDoArquivo, final String conteudo) {
        String nomeDoArquivoCompleto = nomeDoArquivo;
        try {

            Path a = Paths.get(this.config.getDiretorioLog(), nomeDoArquivo);
            nomeDoArquivoCompleto = a.toFile().getAbsolutePath();
            LogHelper.salvarArquivo(conteudo, nomeDoArquivoCompleto);
            LOG.trace("Arquivo criado: " + nomeDoArquivoCompleto);

        } catch (Exception e) {
            LOG.warn(String.format(FALHA_SALVAR_ARQUIVO, nomeDoArquivoCompleto));
        }
    }

}
