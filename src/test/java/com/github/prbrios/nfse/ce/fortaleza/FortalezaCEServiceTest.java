package com.github.prbrios.nfse.ce.fortaleza;

import com.github.prbrios.nfse.Ambiente;
import com.github.prbrios.nfse.Configuracao;
import com.github.prbrios.nfse.TipoCertificado;
import com.github.prbrios.nfse.model.ginfes.v2.CancelarNfseEnvio;
import com.github.prbrios.nfse.model.ginfes.v2.CancelarNfseResposta;
import com.github.prbrios.nfse.model.ginfes.v4.ConsultarLoteRpsEnvio;
import com.github.prbrios.nfse.model.ginfes.v4.ConsultarLoteRpsResposta;
import com.github.prbrios.nfse.model.ginfes.v4.EnviarLoteRpsEnvio;
import com.github.prbrios.nfse.model.ginfes.v4.EnviarLoteRpsResposta;
import com.github.prbrios.nfse.model.ginfes.v4.tipos.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FortalezaCEServiceTest {

    @Test
    public void enviarLoteRps() throws Exception {

        // Lê variáveis de ambiente
        String certificado = System.getenv("NFSE_CERTIFICADO_PATH");
        String senha = System.getenv("NFSE_CERTIFICADO_SENHA");
        String cnpjPrestador = System.getenv("NFSE_CNPJ");
        String inscricaoMunicipal = System.getenv("NFSE_INSCRICAO_MUNICIPAL");

        // Verifica se as variáveis de ambiente obrigatórias estão configuradas
        boolean variaveisConfiguradas = certificado != null && senha != null
            && cnpjPrestador != null && inscricaoMunicipal != null;

        Assumptions.assumeTrue(variaveisConfiguradas,
            "Teste ignorado: Variáveis de ambiente não configuradas. " +
            "Configure NFSE_CERTIFICADO_PATH, NFSE_CERTIFICADO_SENHA, " +
            "NFSE_CNPJ_PRESTADOR e NFSE_INSCRICAO_MUNICIPAL no arquivo .env");

        Configuracao config = new Configuracao(Ambiente.HOMOLOGACAO, TipoCertificado.A1, certificado, senha, null);
        FortalezaCEService service = new FortalezaCEService(config);

        Contato contato = new Contato();
        contato.setEmail("email@email.com.br");
        contato.setTelefone("85912341234");

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCep("60000000");
        endereco.setCodigoMunicipio("2304400");
        endereco.setComplemento("Proximo a escola");
        endereco.setEndereco("RUA XYZ");
        endereco.setNumero("1000");
        endereco.setUf("CE");

        CpfCnpj cpfCnpj = new CpfCnpj();
        cpfCnpj.setCpf("06225642005");
        IdentificacaoTomador identificacaoTomador = new IdentificacaoTomador();
        identificacaoTomador.setCpfCnpj(cpfCnpj);
        identificacaoTomador.setInscricaoMunicipal(null);

        DadosTomador tomador = new DadosTomador();
        tomador.setContato(null);
        tomador.setEndereco(endereco);
        tomador.setIdentificacaoTomador(identificacaoTomador);
        tomador.setRazaoSocial("JOAO JOSE");

        IdentificacaoPrestador prestador = new IdentificacaoPrestador();
        prestador.setCnpj(cnpjPrestador);
        prestador.setInscricaoMunicipal(inscricaoMunicipal);

        Valores valores = new Valores();
        valores.setAliquota("0.05");
        valores.setBaseCalculo("1.00");
        valores.setDescontoCondicionado(null);
        valores.setDescontoIncondicionado(null);
        valores.setIssRetido("2");
        valores.setOutrasRetencoes(null);
        valores.setValorCofins(null);
        valores.setValorCsll(null);
        valores.setValorDeducoes(null);
        valores.setValorInss(null);
        valores.setValorIr(null);
        valores.setValorIss("0.05");
        valores.setValorIssRetido("0.00");
        valores.setValorLiquidoNfse("1.00");
        valores.setValorPis(null);
        valores.setValorServicos("1.00");

        DadosServico servico = new DadosServico();
        servico.setCodigoCnae(null);
        servico.setCodigoMunicipio("2304400");
        servico.setCodigoTributacaoMunicipio("951180001");
        servico.setDiscriminacao("TESTE DE EMISSAO DE RPS");
        servico.setItemListaServico("1401");
        servico.setCodigoNbs("120012000");
        servico.setValores(valores);

        IdentificacaoRps identificacaoRps = new IdentificacaoRps();
        identificacaoRps.setNumero("75");
        identificacaoRps.setSerie("1");
        identificacaoRps.setTipo("1");

        InfRps infRps = new InfRps();
        infRps.setId(UUID.randomUUID().toString());
        infRps.setIdentificacaoRps(identificacaoRps);
        infRps.setDataEmissao("2026-01-02T08:40:01");
        infRps.setNaturezaOperacao("1");
        infRps.setRegimeEspecialTributacao(null);
        infRps.setOptanteSimplesNacional("2");
        infRps.setIncentivadorCultural("2");
        infRps.setStatus("1");
        infRps.setRpsSubstituido(null);
        infRps.setServico(servico);
        infRps.setPrestador(prestador);
        infRps.setTomador(tomador);
        infRps.setIntermediarioServico(null);
        infRps.setConstrucaoCivil(null);

        DadosIbsCbs ibsCbs = new DadosIbsCbs();
        ibsCbs.setCodigoIndicadorFinalidadeNFSe("0");
        ibsCbs.setCodigoIndicadorOperacaoUsoConsumoPessoal("1");
        ibsCbs.setCodigoIndicadorOperacao("050101");
        ibsCbs.setIndDest("0");

        ValoresIbsCbs valoresIbsCbs = new ValoresIbsCbs();
        TributosIbsCbs tributosIbsCbs = new TributosIbsCbs();
        GrupoIbsCbs grupoIbsCbs = new GrupoIbsCbs();
        grupoIbsCbs.setCST("000");
        grupoIbsCbs.setCodigoClassTrib("000001");
        tributosIbsCbs.setGrupoIbsCbs(grupoIbsCbs);

        valoresIbsCbs.setTributosIbsCbs(tributosIbsCbs);
        ibsCbs.setValores(valoresIbsCbs);
        infRps.setIbsCbs(ibsCbs);

        Rps rps = new Rps();
        rps.setInfRps(infRps);

        List<Rps> rpsArr = new ArrayList<>();
        rpsArr.add(rps);

        LoteRps.ListaRps listaRps = new LoteRps.ListaRps();
        listaRps.setRps(rpsArr);

        LoteRps loteRps = new LoteRps();
        loteRps.setNumeroLote("1");
        loteRps.setCnpj(cnpjPrestador);
        loteRps.setInscricaoMunicipal(inscricaoMunicipal);
        loteRps.setQuantidadeRps("1");
        loteRps.setId(UUID.randomUUID().toString());

        loteRps.setListaRps(listaRps);

        EnviarLoteRpsEnvio enviarLoteRpsEnvio = new EnviarLoteRpsEnvio();
        enviarLoteRpsEnvio.setLoteRps(loteRps);
        EnviarLoteRpsResposta resposta = service.enviarLoteRps(enviarLoteRpsEnvio);
        Assertions.assertNotNull(resposta.getProtocolo());

        Thread.sleep(30000);

        // consulta o protocolo

        IdentificacaoPrestador prestador2 = new IdentificacaoPrestador();
        prestador2.setCnpj(cnpjPrestador);
        prestador2.setInscricaoMunicipal(inscricaoMunicipal);

        ConsultarLoteRpsEnvio consultarLoteRpsEnvio = new ConsultarLoteRpsEnvio();
        consultarLoteRpsEnvio.setPrestador(prestador2);
        consultarLoteRpsEnvio.setProtocolo(resposta.getProtocolo());

        ConsultarLoteRpsResposta consultarLoteRpsResposta = service.consultarLoteRps(consultarLoteRpsEnvio);
        String numero = null;
        try {
            numero = consultarLoteRpsResposta.getListaNfse().getCompNfse().get(0).getNfse().getInfNfse().getNumero();
        } catch (Exception ex) {

        }

        Assertions.assertNotNull(numero);

        if (numero != null) {
            Thread.sleep(5000);

            com.github.prbrios.nfse.model.ginfes.v2.tipos.IdentificacaoPrestador prestador3 =
                new com.github.prbrios.nfse.model.ginfes.v2.tipos.IdentificacaoPrestador();
            prestador3.setCnpj(cnpjPrestador);
            prestador3.setInscricaoMunicipal(inscricaoMunicipal);

            com.github.prbrios.nfse.model.ginfes.v2.CancelarNfseEnvio cancelarNfseEnvio = new CancelarNfseEnvio();
            cancelarNfseEnvio.setPrestador(prestador3);
            cancelarNfseEnvio.setNumeroNfse(numero);
            CancelarNfseResposta cancelarNfseResposta = service.cancelarNfse(cancelarNfseEnvio);

            Assertions.assertTrue(cancelarNfseResposta.getSucesso());
        }

    }

}
