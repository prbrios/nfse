package com.github.prbrios.nfse.ce.fortaleza;

import com.github.prbrios.nfse.FileResourcesUtils;
import com.github.prbrios.nfse.impressao.InformacoesPrestador;
import com.github.prbrios.nfse.model.ginfes.v3.tipos.Nfse;
import com.github.prbrios.nfse.model.ginfes.v3.tipos.Rps;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FortalezaCEImpressao implements com.github.prbrios.nfse.impressao.Impressao {
    private static final Logger LOG = LoggerFactory.getLogger(FortalezaCEImpressao.class);

    private Nfse nfse;
    private Rps rps;
    private Persister persister;
    private boolean cancelada;
    private String logomarca;
    private InformacoesPrestador prestador;

    private static final String ARQUIVO_JASPER = "jasper/2304400-nfse.jasper";

    private String Nfse_InfNfse_Numero;
    private String Nfse_InfNfse_CodigoVerificacao;
    private String Nfse_InfNfse_DataEmissao;
    private String Nfse_InfNfse_IdentificacaoRps_Numero;
    private String Nfse_InfNfse_IdentificacaoRps_Serie;
    private String Nfse_InfNfse_IdentificacaoRps_Tipo;
    private String Nfse_InfNfse_DataEmissaoRps;
    private String Nfse_InfNfse_NaturezaOperacao;
    private String Nfse_InfNfse_OptanteSimplesNacional;
    private String Nfse_InfNfse_IncentivadorCultural;
    private String Nfse_InfNfse_Competencia;
    private String Nfse_InfNfse_RegimeEspecialTributacao;
    private BigDecimal Nfse_InfNfse_Servico_Valores_ValorServicos;
    private BigDecimal Nfse_InfNfse_Servico_Valores_ValorDeducoes;
    private BigDecimal Nfse_InfNfse_Servico_Valores_ValorPis;
    private BigDecimal Nfse_InfNfse_Servico_Valores_ValorCofins;
    private BigDecimal Nfse_InfNfse_Servico_Valores_ValorInss;
    private BigDecimal Nfse_InfNfse_Servico_Valores_ValorIr;
    private BigDecimal Nfse_InfNfse_Servico_Valores_ValorCsll;
    private String Nfse_InfNfse_Servico_Valores_IssRetido;
    private BigDecimal Nfse_InfNfse_Servico_Valores_ValorIss;
    private BigDecimal Nfse_InfNfse_Servico_Valores_ValorIssRetido;
    private BigDecimal Nfse_InfNfse_Servico_Valores_OutrasRetencoes;
    private BigDecimal Nfse_InfNfse_Servico_Valores_BaseCalculo;
    private BigDecimal Nfse_InfNfse_Servico_Valores_Aliquota;
    private BigDecimal Nfse_InfNfse_Servico_Valores_ValorLiquidoNfse;
    private BigDecimal Nfse_InfNfse_Servico_Valores_DescontoCondicionado;
    private BigDecimal Nfse_InfNfse_Servico_Valores_DescontoIncondicionado;
    private String Nfse_InfNfse_Servico_ItemListaServico;
    private String Nfse_InfNfse_Servico_CodigoCnae;
    private String Nfse_InfNfse_Servico_CodigoTributacaoMunicipio;
    private String Nfse_InfNfse_Servico_Discriminacao;
    private String Nfse_InfNfse_Servico_CodigoMunicipio;
    private BigDecimal Nfse_InfNfse_ValorCredito;
    private String Nfse_InfNfse_PrestadorServico_IdentificacaoPrestador_Cnpj;
    private String Nfse_InfNfse_PrestadorServico_IdentificacaoPrestador_InscricaoMunicipal;
    private String Nfse_InfNfse_PrestadorServico_RazaoSocial;
    private String Nfse_InfNfse_PrestadorServico_NomeFantasia;
    private String Nfse_InfNfse_PrestadorServico_Endereco_Endereco;
    private String Nfse_InfNfse_PrestadorServico_Endereco_Numero;
    private String Nfse_InfNfse_PrestadorServico_Endereco_Complemento;
    private String Nfse_InfNfse_PrestadorServico_Endereco_Bairro;
    private String Nfse_InfNfse_PrestadorServico_Endereco_CodigoMunicipio;
    private String Nfse_InfNfse_PrestadorServico_Endereco_Uf;
    private String Nfse_InfNfse_PrestadorServico_Endereco_Cep;
    private String Nfse_InfNfse_PrestadorServico_Contato_Telefone;
    private String Nfse_InfNfse_PrestadorServico_Contato_Email;
    private String Nfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cpf;
    private String Nfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cnpj;
    private String Nfse_InfNfse_TomadorServico_IdentificacaoTomador_InscricaoMunicipal;
    private String Nfse_InfNfse_TomadorServico_RazaoSocial;
    private String Nfse_InfNfse_TomadorServico_Endereco_Endereco;
    private String Nfse_InfNfse_TomadorServico_Endereco_Numero;
    private String Nfse_InfNfse_TomadorServico_Endereco_Complemento;
    private String Nfse_InfNfse_TomadorServico_Endereco_Bairro;
    private String Nfse_InfNfse_TomadorServico_Endereco_CodigoMunicipio;
    private String Nfse_InfNfse_TomadorServico_Endereco_Uf;
    private String Nfse_InfNfse_TomadorServico_Endereco_Cep;
    private String Nfse_InfNfse_TomadorServico_Contato_Telefone;
    private String Nfse_InfNfse_TomadorServico_Contato_Email;
    private String Nfse_InfNfse_OrgaoGerador_CodigoMunicipio;
    private String Nfse_InfNfse_OrgaoGerador_Uf;
    private String NfseCancelamento_Confirmacao_InfConfirmacaoCancelamento_Sucesso;

    public FortalezaCEImpressao(String xml, String logomarca, boolean cancelada, InformacoesPrestador prestador) throws Exception {

        if (logomarca != null && !new File(logomarca).isFile() && !logomarca.toLowerCase().endsWith(".png"))
            throw new Exception("Arquivo de logomarca invalido");

        this.logomarca = logomarca;
        this.cancelada = cancelada;
        this.prestador = prestador;
        this.persister = new Persister();

        try {
            this.nfse = this.persister.read(Nfse.class, xml);
        } catch (Exception e1) {
            LOG.warn("XML de NFS-e invalido");
        }

        try {
            this.rps = this.persister.read(Rps.class, xml);
        } catch(Exception e2) {
            LOG.warn("XML de RPS invalido");
        }
    }

    public byte[] bytesPdf() throws Exception {
        if (this.rps != null) {
            return this.criarRpsFile();
        } else if (this.nfse != null) {
            return this.criarNfseFile();
        } else {
            throw new Exception("Nao foi possivel criar objeto atraves do XML informado");
        }
    }

    private byte[] criarRpsFile() throws Exception {

        try { this.setNfse_InfNfse_Numero(null);} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_CodigoVerificacao(null);} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_DataEmissao(null);} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_IdentificacaoRps_Numero(this.rps.getInfRps().getIdentificacaoRps().getNumero());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_IdentificacaoRps_Serie(this.rps.getInfRps().getIdentificacaoRps().getSerie());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_IdentificacaoRps_Tipo(this.rps.getInfRps().getIdentificacaoRps().getTipo());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_DataEmissaoRps(this.rps.getInfRps().getDataEmissao());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_NaturezaOperacao(this.rps.getInfRps().getNaturezaOperacao());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_OptanteSimplesNacional(this.rps.getInfRps().getOptanteSimplesNacional());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_IncentivadorCultural(this.rps.getInfRps().getIncentivadorCultural());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Competencia(null);} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_RegimeEspecialTributacao(this.rps.getInfRps().getRegimeEspecialTributacao());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorServicos(new BigDecimal(this.rps.getInfRps().getServico().getValores().getValorServicos()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorDeducoes(new BigDecimal(this.rps.getInfRps().getServico().getValores().getValorDeducoes()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorPis(new BigDecimal(this.rps.getInfRps().getServico().getValores().getValorPis()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorCofins(new BigDecimal(this.rps.getInfRps().getServico().getValores().getValorCofins()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorInss(new BigDecimal(this.rps.getInfRps().getServico().getValores().getValorInss()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorIr(new BigDecimal(this.rps.getInfRps().getServico().getValores().getValorIr()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorCsll(new BigDecimal(this.rps.getInfRps().getServico().getValores().getValorCsll()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_IssRetido(this.rps.getInfRps().getServico().getValores().getIssRetido());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorIss(new BigDecimal(this.rps.getInfRps().getServico().getValores().getValorIss()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorIssRetido(new BigDecimal(this.rps.getInfRps().getServico().getValores().getValorIssRetido()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_OutrasRetencoes(new BigDecimal(this.rps.getInfRps().getServico().getValores().getOutrasRetencoes()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_BaseCalculo(new BigDecimal(this.rps.getInfRps().getServico().getValores().getBaseCalculo()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_Aliquota(new BigDecimal(this.rps.getInfRps().getServico().getValores().getAliquota()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorLiquidoNfse(new BigDecimal(this.rps.getInfRps().getServico().getValores().getValorLiquidoNfse()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_DescontoCondicionado(new BigDecimal(this.rps.getInfRps().getServico().getValores().getDescontoCondicionado()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_DescontoIncondicionado(new BigDecimal(this.rps.getInfRps().getServico().getValores().getDescontoIncondicionado()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_ItemListaServico(this.rps.getInfRps().getServico().getItemListaServico());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_CodigoCnae(this.rps.getInfRps().getServico().getCodigoCnae());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_CodigoTributacaoMunicipio(this.rps.getInfRps().getServico().getCodigoTributacaoMunicipio());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Discriminacao(this.rps.getInfRps().getServico().getDiscriminacao());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_CodigoMunicipio(this.rps.getInfRps().getServico().getCodigoMunicipio());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_ValorCredito(null);} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_IdentificacaoPrestador_Cnpj(this.rps.getInfRps().getPrestador().getCnpj());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_IdentificacaoPrestador_InscricaoMunicipal(this.rps.getInfRps().getPrestador().getInscricaoMunicipal());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_RazaoSocial(this.prestador.getRazaoSocial());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_NomeFantasia(this.prestador.getNomeFantasia());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_Endereco(this.prestador.getEndereco());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_Numero(this.prestador.getNumero());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_Complemento(this.prestador.getComplemento());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_Bairro(this.prestador.getBairro());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_CodigoMunicipio(this.prestador.getCodigoMunicipio());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_Uf(this.prestador.getUf());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_Cep(this.prestador.getCep());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Contato_Telefone(this.prestador.getTelefone());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Contato_Email(this.prestador.getEmail());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cpf(this.rps.getInfRps().getTomador().getIdentificacaoTomador().getCpfCnpj().getCpf());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cnpj(this.rps.getInfRps().getTomador().getIdentificacaoTomador().getCpfCnpj().getCnpj());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_IdentificacaoTomador_InscricaoMunicipal(this.rps.getInfRps().getTomador().getIdentificacaoTomador().getInscricaoMunicipal());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_RazaoSocial(this.rps.getInfRps().getTomador().getRazaoSocial());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_Endereco(this.rps.getInfRps().getTomador().getEndereco().getEndereco());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_Numero(this.rps.getInfRps().getTomador().getEndereco().getNumero());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_Complemento(this.rps.getInfRps().getTomador().getEndereco().getComplemento());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_Bairro(this.rps.getInfRps().getTomador().getEndereco().getBairro());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_CodigoMunicipio(this.rps.getInfRps().getTomador().getEndereco().getCodigoMunicipio());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_Uf(this.rps.getInfRps().getTomador().getEndereco().getUf());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_Cep(this.rps.getInfRps().getTomador().getEndereco().getCep());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Contato_Telefone(this.rps.getInfRps().getTomador().getContato().getTelefone());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Contato_Email(this.rps.getInfRps().getTomador().getContato().getEmail());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_OrgaoGerador_CodigoMunicipio(null);} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_OrgaoGerador_Uf(null);} catch (Exception e) { /**/ }
        try { this.setNfseCancelamento_Confirmacao_InfConfirmacaoCancelamento_Sucesso(null); } catch (Exception e) { /**/ }

        return this.gerarArquivo();

    }

    private byte[] criarNfseFile() throws Exception {

        try { this.setNfse_InfNfse_Numero(this.nfse.getInfNfse().getNumero());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_CodigoVerificacao(this.nfse.getInfNfse().getCodigoVerificacao());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_DataEmissao(ZonedDateTime.parse(this.nfse.getInfNfse().getDataEmissao()).toLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_IdentificacaoRps_Numero(this.nfse.getInfNfse().getIdentificacaoRps().getNumero());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_IdentificacaoRps_Serie(this.nfse.getInfNfse().getIdentificacaoRps().getSerie());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_IdentificacaoRps_Tipo(this.nfse.getInfNfse().getIdentificacaoRps().getTipo());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_DataEmissaoRps(this.nfse.getInfNfse().getDataEmissao());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_NaturezaOperacao(this.nfse.getInfNfse().getNaturezaOperacao());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_OptanteSimplesNacional(this.nfse.getInfNfse().getOptanteSimplesNacional());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_IncentivadorCultural(this.nfse.getInfNfse().getIncentivadorCultural());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Competencia(LocalDate.parse(this.nfse.getInfNfse().getCompetencia().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")).format( DateTimeFormatter.ofPattern("MM/yyyy")));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_RegimeEspecialTributacao(this.nfse.getInfNfse().getRegimeEspecialTributacao());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorServicos(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getValorServicos()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorDeducoes(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getValorDeducoes()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorPis(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getValorPis()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorCofins(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getValorCofins()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorInss(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getValorInss()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorIr(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getValorIr()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorCsll(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getValorCsll()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_IssRetido(this.nfse.getInfNfse().getServico().getValores().getIssRetido());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorIss(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getValorIss()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorIssRetido(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getValorIssRetido()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_OutrasRetencoes(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getOutrasRetencoes()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_BaseCalculo(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getBaseCalculo()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_Aliquota(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getAliquota()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_ValorLiquidoNfse(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getValorLiquidoNfse()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_DescontoCondicionado(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getDescontoCondicionado()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Valores_DescontoIncondicionado(new BigDecimal(this.nfse.getInfNfse().getServico().getValores().getDescontoIncondicionado()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_ItemListaServico(this.nfse.getInfNfse().getServico().getItemListaServico());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_CodigoCnae(this.nfse.getInfNfse().getServico().getCodigoCnae());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_CodigoTributacaoMunicipio(this.nfse.getInfNfse().getServico().getCodigoTributacaoMunicipio());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_Discriminacao(this.nfse.getInfNfse().getServico().getDiscriminacao());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_Servico_CodigoMunicipio(this.nfse.getInfNfse().getServico().getCodigoMunicipio());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_ValorCredito(new BigDecimal(this.nfse.getInfNfse().getValorCredito()));} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_IdentificacaoPrestador_Cnpj(this.nfse.getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getCnpj());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_IdentificacaoPrestador_InscricaoMunicipal(this.nfse.getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_RazaoSocial(this.nfse.getInfNfse().getPrestadorServico().getRazaoSocial());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_NomeFantasia(this.nfse.getInfNfse().getPrestadorServico().getNomeFantasia());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_Endereco(this.nfse.getInfNfse().getPrestadorServico().getEndereco().getEndereco());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_Numero(this.nfse.getInfNfse().getPrestadorServico().getEndereco().getNumero());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_Complemento(this.nfse.getInfNfse().getPrestadorServico().getEndereco().getComplemento());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_Bairro(this.nfse.getInfNfse().getPrestadorServico().getEndereco().getBairro());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_CodigoMunicipio(this.nfse.getInfNfse().getPrestadorServico().getEndereco().getCodigoMunicipio());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_Uf(this.nfse.getInfNfse().getPrestadorServico().getEndereco().getUf());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Endereco_Cep(this.nfse.getInfNfse().getPrestadorServico().getEndereco().getCep());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Contato_Telefone(this.nfse.getInfNfse().getPrestadorServico().getContato().getTelefone());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_PrestadorServico_Contato_Email(this.nfse.getInfNfse().getPrestadorServico().getContato().getEmail());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cpf(this.nfse.getInfNfse().getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCpf());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cnpj(this.nfse.getInfNfse().getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCnpj());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_IdentificacaoTomador_InscricaoMunicipal(this.nfse.getInfNfse().getTomadorServico().getIdentificacaoTomador().getInscricaoMunicipal());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_RazaoSocial(this.nfse.getInfNfse().getTomadorServico().getRazaoSocial());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_Endereco(this.nfse.getInfNfse().getTomadorServico().getEndereco().getEndereco());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_Numero(this.nfse.getInfNfse().getTomadorServico().getEndereco().getNumero());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_Complemento(this.nfse.getInfNfse().getTomadorServico().getEndereco().getComplemento());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_Bairro(this.nfse.getInfNfse().getTomadorServico().getEndereco().getBairro());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_CodigoMunicipio(this.nfse.getInfNfse().getTomadorServico().getEndereco().getCodigoMunicipio());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_Uf(this.nfse.getInfNfse().getTomadorServico().getEndereco().getUf());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Endereco_Cep(this.nfse.getInfNfse().getTomadorServico().getEndereco().getCep());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Contato_Telefone(this.nfse.getInfNfse().getTomadorServico().getContato().getTelefone());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_TomadorServico_Contato_Email(this.nfse.getInfNfse().getTomadorServico().getContato().getEmail());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_OrgaoGerador_CodigoMunicipio(this.nfse.getInfNfse().getOrgaoGerador().getCodigoMunicipio());} catch (Exception e) { /**/ }
        try { this.setNfse_InfNfse_OrgaoGerador_Uf(this.nfse.getInfNfse().getOrgaoGerador().getUf());} catch (Exception e) { /**/ }
        if (this.cancelada)
            try { this.setNfseCancelamento_Confirmacao_InfConfirmacaoCancelamento_Sucesso("true"); } catch (Exception e) { /**/ }

        return this.gerarArquivo();
    }

    private byte[] gerarArquivo() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        Map<String, Object> params = this.toMap();
        if (this.logomarca != null)
            params.put("Logo", this.logomarca);

        FileResourcesUtils app = new FileResourcesUtils();
        InputStream is = app.getFileFromResourceJAR("jasper", "jasper/2304400-nfse.jasper");
        if (is != null) {
            JasperPrint jp = JasperFillManager.fillReport(is, params, new JREmptyDataSource());
            return JasperExportManager.exportReportToPdf(jp);
        }

        throw new Exception("Falha ao gerar o PDF");

    }

    private Map<String, Object> toMap() {
        Map<String, Object> obj = new HashMap<>();

        obj.put("Nfse_InfNfse_Numero", this.getNfse_InfNfse_Numero());
        obj.put("Nfse_InfNfse_CodigoVerificacao", this.getNfse_InfNfse_CodigoVerificacao());
        obj.put("Nfse_InfNfse_DataEmissao", this.getNfse_InfNfse_DataEmissao());
        obj.put("Nfse_InfNfse_IdentificacaoRps_Numero", this.getNfse_InfNfse_IdentificacaoRps_Numero());
        obj.put("Nfse_InfNfse_IdentificacaoRps_Serie", this.getNfse_InfNfse_IdentificacaoRps_Serie());
        obj.put("Nfse_InfNfse_IdentificacaoRps_Tipo", this.getNfse_InfNfse_IdentificacaoRps_Tipo());
        obj.put("Nfse_InfNfse_DataEmissaoRps", this.getNfse_InfNfse_DataEmissaoRps());
        obj.put("Nfse_InfNfse_NaturezaOperacao", this.getNfse_InfNfse_NaturezaOperacao());
        obj.put("Nfse_InfNfse_OptanteSimplesNacional", this.getNfse_InfNfse_OptanteSimplesNacional());
        obj.put("Nfse_InfNfse_IncentivadorCultural", this.getNfse_InfNfse_IncentivadorCultural());
        obj.put("Nfse_InfNfse_Competencia", this.getNfse_InfNfse_Competencia());
        obj.put("Nfse_InfNfse_RegimeEspecialTributacao", this.getNfse_InfNfse_RegimeEspecialTributacao());
        obj.put("Nfse_InfNfse_Servico_Valores_ValorServicos", this.getNfse_InfNfse_Servico_Valores_ValorServicos());
        obj.put("Nfse_InfNfse_Servico_Valores_ValorDeducoes", this.getNfse_InfNfse_Servico_Valores_ValorDeducoes());
        obj.put("Nfse_InfNfse_Servico_Valores_ValorPis", this.getNfse_InfNfse_Servico_Valores_ValorPis());
        obj.put("Nfse_InfNfse_Servico_Valores_ValorCofins", this.getNfse_InfNfse_Servico_Valores_ValorCofins());
        obj.put("Nfse_InfNfse_Servico_Valores_ValorInss", this.getNfse_InfNfse_Servico_Valores_ValorInss());
        obj.put("Nfse_InfNfse_Servico_Valores_ValorIr", this.getNfse_InfNfse_Servico_Valores_ValorIr());
        obj.put("Nfse_InfNfse_Servico_Valores_ValorCsll", this.getNfse_InfNfse_Servico_Valores_ValorCsll());
        obj.put("Nfse_InfNfse_Servico_Valores_IssRetido", this.getNfse_InfNfse_Servico_Valores_IssRetido());
        obj.put("Nfse_InfNfse_Servico_Valores_ValorIss", this.getNfse_InfNfse_Servico_Valores_ValorIss());
        obj.put("Nfse_InfNfse_Servico_Valores_ValorIssRetido", this.getNfse_InfNfse_Servico_Valores_ValorIssRetido());
        obj.put("Nfse_InfNfse_Servico_Valores_OutrasRetencoes", this.getNfse_InfNfse_Servico_Valores_OutrasRetencoes());
        obj.put("Nfse_InfNfse_Servico_Valores_BaseCalculo", this.getNfse_InfNfse_Servico_Valores_BaseCalculo());
        obj.put("Nfse_InfNfse_Servico_Valores_Aliquota", this.getNfse_InfNfse_Servico_Valores_Aliquota());
        obj.put("Nfse_InfNfse_Servico_Valores_ValorLiquidoNfse", this.getNfse_InfNfse_Servico_Valores_ValorLiquidoNfse());
        obj.put("Nfse_InfNfse_Servico_Valores_DescontoCondicionado", this.getNfse_InfNfse_Servico_Valores_DescontoCondicionado());
        obj.put("Nfse_InfNfse_Servico_Valores_DescontoIncondicionado", this.getNfse_InfNfse_Servico_Valores_DescontoIncondicionado());
        obj.put("Nfse_InfNfse_Servico_ItemListaServico", this.getNfse_InfNfse_Servico_ItemListaServico());
        obj.put("Nfse_InfNfse_Servico_CodigoCnae", this.getNfse_InfNfse_Servico_CodigoCnae());
        obj.put("Nfse_InfNfse_Servico_CodigoTributacaoMunicipio", this.getNfse_InfNfse_Servico_CodigoTributacaoMunicipio());
        obj.put("Nfse_InfNfse_Servico_Discriminacao", this.getNfse_InfNfse_Servico_Discriminacao());
        obj.put("Nfse_InfNfse_Servico_CodigoMunicipio", this.getNfse_InfNfse_Servico_CodigoMunicipio());
        obj.put("Nfse_InfNfse_ValorCredito", this.getNfse_InfNfse_ValorCredito());
        obj.put("Nfse_InfNfse_PrestadorServico_IdentificacaoPrestador_Cnpj", this.getNfse_InfNfse_PrestadorServico_IdentificacaoPrestador_Cnpj());
        obj.put("Nfse_InfNfse_PrestadorServico_IdentificacaoPrestador_InscricaoMunicipal", this.getNfse_InfNfse_PrestadorServico_IdentificacaoPrestador_InscricaoMunicipal());
        obj.put("Nfse_InfNfse_PrestadorServico_RazaoSocial", this.getNfse_InfNfse_PrestadorServico_RazaoSocial());
        obj.put("Nfse_InfNfse_PrestadorServico_NomeFantasia", this.getNfse_InfNfse_PrestadorServico_NomeFantasia());
        obj.put("Nfse_InfNfse_PrestadorServico_Endereco_Endereco", this.getNfse_InfNfse_PrestadorServico_Endereco_Endereco());
        obj.put("Nfse_InfNfse_PrestadorServico_Endereco_Numero", this.getNfse_InfNfse_PrestadorServico_Endereco_Numero());
        obj.put("Nfse_InfNfse_PrestadorServico_Endereco_Complemento", this.getNfse_InfNfse_PrestadorServico_Endereco_Complemento());
        obj.put("Nfse_InfNfse_PrestadorServico_Endereco_Bairro", this.getNfse_InfNfse_PrestadorServico_Endereco_Bairro());
        obj.put("Nfse_InfNfse_PrestadorServico_Endereco_CodigoMunicipio", this.getNfse_InfNfse_PrestadorServico_Endereco_CodigoMunicipio());
        obj.put("Nfse_InfNfse_PrestadorServico_Endereco_Uf", this.getNfse_InfNfse_PrestadorServico_Endereco_Uf());
        obj.put("Nfse_InfNfse_PrestadorServico_Endereco_Cep", this.getNfse_InfNfse_PrestadorServico_Endereco_Cep());
        obj.put("Nfse_InfNfse_PrestadorServico_Contato_Telefone", this.getNfse_InfNfse_PrestadorServico_Contato_Telefone());
        obj.put("Nfse_InfNfse_PrestadorServico_Contato_Email", this.getNfse_InfNfse_PrestadorServico_Contato_Email());
        obj.put("Nfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cpf", this.getNfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cpf());
        obj.put("Nfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cnpj", this.getNfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cnpj());
        obj.put("Nfse_InfNfse_TomadorServico_IdentificacaoTomador_InscricaoMunicipal", this.getNfse_InfNfse_TomadorServico_IdentificacaoTomador_InscricaoMunicipal());
        obj.put("Nfse_InfNfse_TomadorServico_RazaoSocial", this.getNfse_InfNfse_TomadorServico_RazaoSocial());
        obj.put("Nfse_InfNfse_TomadorServico_Endereco_Endereco", this.getNfse_InfNfse_TomadorServico_Endereco_Endereco());
        obj.put("Nfse_InfNfse_TomadorServico_Endereco_Numero", this.getNfse_InfNfse_TomadorServico_Endereco_Numero());
        obj.put("Nfse_InfNfse_TomadorServico_Endereco_Complemento", this.getNfse_InfNfse_TomadorServico_Endereco_Complemento());
        obj.put("Nfse_InfNfse_TomadorServico_Endereco_Bairro", this.getNfse_InfNfse_TomadorServico_Endereco_Bairro());
        obj.put("Nfse_InfNfse_TomadorServico_Endereco_CodigoMunicipio", this.getNfse_InfNfse_TomadorServico_Endereco_CodigoMunicipio());
        obj.put("Nfse_InfNfse_TomadorServico_Endereco_Uf", this.getNfse_InfNfse_TomadorServico_Endereco_Uf());
        obj.put("Nfse_InfNfse_TomadorServico_Endereco_Cep", this.getNfse_InfNfse_TomadorServico_Endereco_Cep());
        obj.put("Nfse_InfNfse_TomadorServico_Contato_Telefone", this.getNfse_InfNfse_TomadorServico_Contato_Telefone());
        obj.put("Nfse_InfNfse_TomadorServico_Contato_Email", this.getNfse_InfNfse_TomadorServico_Contato_Email());
        obj.put("Nfse_InfNfse_OrgaoGerador_CodigoMunicipio", this.getNfse_InfNfse_OrgaoGerador_CodigoMunicipio());
        obj.put("Nfse_InfNfse_OrgaoGerador_Uf", this.getNfse_InfNfse_OrgaoGerador_Uf());
        obj.put("NfseCancelamento_Confirmacao_InfConfirmacaoCancelamento_Sucesso", this.getNfseCancelamento_Confirmacao_InfConfirmacaoCancelamento_Sucesso());

        return obj;
    }

    public String getNfse_InfNfse_Numero() {
        return Nfse_InfNfse_Numero;
    }

    public void setNfse_InfNfse_Numero(String nfse_InfNfse_Numero) {
        Nfse_InfNfse_Numero = nfse_InfNfse_Numero;
    }

    public String getNfse_InfNfse_CodigoVerificacao() {
        return Nfse_InfNfse_CodigoVerificacao;
    }

    public void setNfse_InfNfse_CodigoVerificacao(String nfse_InfNfse_CodigoVerificacao) {
        Nfse_InfNfse_CodigoVerificacao = nfse_InfNfse_CodigoVerificacao;
    }

    public String getNfse_InfNfse_DataEmissao() {
        return Nfse_InfNfse_DataEmissao;
    }

    public void setNfse_InfNfse_DataEmissao(String nfse_InfNfse_DataEmissao) {
        Nfse_InfNfse_DataEmissao = nfse_InfNfse_DataEmissao;
    }

    public String getNfse_InfNfse_IdentificacaoRps_Numero() {
        return Nfse_InfNfse_IdentificacaoRps_Numero;
    }

    public void setNfse_InfNfse_IdentificacaoRps_Numero(String nfse_InfNfse_IdentificacaoRps_Numero) {
        Nfse_InfNfse_IdentificacaoRps_Numero = nfse_InfNfse_IdentificacaoRps_Numero;
    }

    public String getNfse_InfNfse_IdentificacaoRps_Serie() {
        return Nfse_InfNfse_IdentificacaoRps_Serie;
    }

    public void setNfse_InfNfse_IdentificacaoRps_Serie(String nfse_InfNfse_IdentificacaoRps_Serie) {
        Nfse_InfNfse_IdentificacaoRps_Serie = nfse_InfNfse_IdentificacaoRps_Serie;
    }

    public String getNfse_InfNfse_IdentificacaoRps_Tipo() {
        return Nfse_InfNfse_IdentificacaoRps_Tipo;
    }

    public void setNfse_InfNfse_IdentificacaoRps_Tipo(String nfse_InfNfse_IdentificacaoRps_Tipo) {
        Nfse_InfNfse_IdentificacaoRps_Tipo = nfse_InfNfse_IdentificacaoRps_Tipo;
    }

    public String getNfse_InfNfse_DataEmissaoRps() {
        return Nfse_InfNfse_DataEmissaoRps;
    }

    public void setNfse_InfNfse_DataEmissaoRps(String nfse_InfNfse_DataEmissaoRps) {
        Nfse_InfNfse_DataEmissaoRps = nfse_InfNfse_DataEmissaoRps;
    }

    public String getNfse_InfNfse_NaturezaOperacao() {
        return Nfse_InfNfse_NaturezaOperacao;
    }

    public void setNfse_InfNfse_NaturezaOperacao(String nfse_InfNfse_NaturezaOperacao) {
        Nfse_InfNfse_NaturezaOperacao = nfse_InfNfse_NaturezaOperacao;
    }

    public String getNfse_InfNfse_OptanteSimplesNacional() {
        return Nfse_InfNfse_OptanteSimplesNacional;
    }

    public void setNfse_InfNfse_OptanteSimplesNacional(String nfse_InfNfse_OptanteSimplesNacional) {
        Nfse_InfNfse_OptanteSimplesNacional = nfse_InfNfse_OptanteSimplesNacional;
    }

    public String getNfse_InfNfse_IncentivadorCultural() {
        return Nfse_InfNfse_IncentivadorCultural;
    }

    public void setNfse_InfNfse_IncentivadorCultural(String nfse_InfNfse_IncentivadorCultural) {
        Nfse_InfNfse_IncentivadorCultural = nfse_InfNfse_IncentivadorCultural;
    }

    public String getNfse_InfNfse_Competencia() {
        return Nfse_InfNfse_Competencia;
    }

    public void setNfse_InfNfse_Competencia(String nfse_InfNfse_Competencia) {
        Nfse_InfNfse_Competencia = nfse_InfNfse_Competencia;
    }

    public String getNfse_InfNfse_RegimeEspecialTributacao() {
        return Nfse_InfNfse_RegimeEspecialTributacao;
    }

    public void setNfse_InfNfse_RegimeEspecialTributacao(String nfse_InfNfse_RegimeEspecialTributacao) {
        Nfse_InfNfse_RegimeEspecialTributacao = nfse_InfNfse_RegimeEspecialTributacao;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_ValorServicos() {
        return Nfse_InfNfse_Servico_Valores_ValorServicos;
    }

    public void setNfse_InfNfse_Servico_Valores_ValorServicos(BigDecimal nfse_InfNfse_Servico_Valores_ValorServicos) {
        Nfse_InfNfse_Servico_Valores_ValorServicos = nfse_InfNfse_Servico_Valores_ValorServicos;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_ValorDeducoes() {
        return Nfse_InfNfse_Servico_Valores_ValorDeducoes;
    }

    public void setNfse_InfNfse_Servico_Valores_ValorDeducoes(BigDecimal nfse_InfNfse_Servico_Valores_ValorDeducoes) {
        Nfse_InfNfse_Servico_Valores_ValorDeducoes = nfse_InfNfse_Servico_Valores_ValorDeducoes;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_ValorPis() {
        return Nfse_InfNfse_Servico_Valores_ValorPis;
    }

    public void setNfse_InfNfse_Servico_Valores_ValorPis(BigDecimal nfse_InfNfse_Servico_Valores_ValorPis) {
        Nfse_InfNfse_Servico_Valores_ValorPis = nfse_InfNfse_Servico_Valores_ValorPis;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_ValorCofins() {
        return Nfse_InfNfse_Servico_Valores_ValorCofins;
    }

    public void setNfse_InfNfse_Servico_Valores_ValorCofins(BigDecimal nfse_InfNfse_Servico_Valores_ValorCofins) {
        Nfse_InfNfse_Servico_Valores_ValorCofins = nfse_InfNfse_Servico_Valores_ValorCofins;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_ValorInss() {
        return Nfse_InfNfse_Servico_Valores_ValorInss;
    }

    public void setNfse_InfNfse_Servico_Valores_ValorInss(BigDecimal nfse_InfNfse_Servico_Valores_ValorInss) {
        Nfse_InfNfse_Servico_Valores_ValorInss = nfse_InfNfse_Servico_Valores_ValorInss;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_ValorIr() {
        return Nfse_InfNfse_Servico_Valores_ValorIr;
    }

    public void setNfse_InfNfse_Servico_Valores_ValorIr(BigDecimal nfse_InfNfse_Servico_Valores_ValorIr) {
        Nfse_InfNfse_Servico_Valores_ValorIr = nfse_InfNfse_Servico_Valores_ValorIr;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_ValorCsll() {
        return Nfse_InfNfse_Servico_Valores_ValorCsll;
    }

    public void setNfse_InfNfse_Servico_Valores_ValorCsll(BigDecimal nfse_InfNfse_Servico_Valores_ValorCsll) {
        Nfse_InfNfse_Servico_Valores_ValorCsll = nfse_InfNfse_Servico_Valores_ValorCsll;
    }

    public String getNfse_InfNfse_Servico_Valores_IssRetido() {
        return Nfse_InfNfse_Servico_Valores_IssRetido;
    }

    public void setNfse_InfNfse_Servico_Valores_IssRetido(String nfse_InfNfse_Servico_Valores_IssRetido) {
        Nfse_InfNfse_Servico_Valores_IssRetido = nfse_InfNfse_Servico_Valores_IssRetido;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_ValorIss() {
        return Nfse_InfNfse_Servico_Valores_ValorIss;
    }

    public void setNfse_InfNfse_Servico_Valores_ValorIss(BigDecimal nfse_InfNfse_Servico_Valores_ValorIss) {
        Nfse_InfNfse_Servico_Valores_ValorIss = nfse_InfNfse_Servico_Valores_ValorIss;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_ValorIssRetido() {
        return Nfse_InfNfse_Servico_Valores_ValorIssRetido;
    }

    public void setNfse_InfNfse_Servico_Valores_ValorIssRetido(BigDecimal nfse_InfNfse_Servico_Valores_ValorIssRetido) {
        Nfse_InfNfse_Servico_Valores_ValorIssRetido = nfse_InfNfse_Servico_Valores_ValorIssRetido;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_OutrasRetencoes() {
        return Nfse_InfNfse_Servico_Valores_OutrasRetencoes;
    }

    public void setNfse_InfNfse_Servico_Valores_OutrasRetencoes(BigDecimal nfse_InfNfse_Servico_Valores_OutrasRetencoes) {
        Nfse_InfNfse_Servico_Valores_OutrasRetencoes = nfse_InfNfse_Servico_Valores_OutrasRetencoes;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_BaseCalculo() {
        return Nfse_InfNfse_Servico_Valores_BaseCalculo;
    }

    public void setNfse_InfNfse_Servico_Valores_BaseCalculo(BigDecimal nfse_InfNfse_Servico_Valores_BaseCalculo) {
        Nfse_InfNfse_Servico_Valores_BaseCalculo = nfse_InfNfse_Servico_Valores_BaseCalculo;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_Aliquota() {
        return Nfse_InfNfse_Servico_Valores_Aliquota;
    }

    public void setNfse_InfNfse_Servico_Valores_Aliquota(BigDecimal nfse_InfNfse_Servico_Valores_Aliquota) {
        Nfse_InfNfse_Servico_Valores_Aliquota = nfse_InfNfse_Servico_Valores_Aliquota;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_ValorLiquidoNfse() {
        return Nfse_InfNfse_Servico_Valores_ValorLiquidoNfse;
    }

    public void setNfse_InfNfse_Servico_Valores_ValorLiquidoNfse(BigDecimal nfse_InfNfse_Servico_Valores_ValorLiquidoNfse) {
        Nfse_InfNfse_Servico_Valores_ValorLiquidoNfse = nfse_InfNfse_Servico_Valores_ValorLiquidoNfse;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_DescontoCondicionado() {
        return Nfse_InfNfse_Servico_Valores_DescontoCondicionado;
    }

    public void setNfse_InfNfse_Servico_Valores_DescontoCondicionado(BigDecimal nfse_InfNfse_Servico_Valores_DescontoCondicionado) {
        Nfse_InfNfse_Servico_Valores_DescontoCondicionado = nfse_InfNfse_Servico_Valores_DescontoCondicionado;
    }

    public BigDecimal getNfse_InfNfse_Servico_Valores_DescontoIncondicionado() {
        return Nfse_InfNfse_Servico_Valores_DescontoIncondicionado;
    }

    public void setNfse_InfNfse_Servico_Valores_DescontoIncondicionado(BigDecimal nfse_InfNfse_Servico_Valores_DescontoIncondicionado) {
        Nfse_InfNfse_Servico_Valores_DescontoIncondicionado = nfse_InfNfse_Servico_Valores_DescontoIncondicionado;
    }

    public String getNfse_InfNfse_Servico_ItemListaServico() {
        return Nfse_InfNfse_Servico_ItemListaServico;
    }

    public void setNfse_InfNfse_Servico_ItemListaServico(String nfse_InfNfse_Servico_ItemListaServico) {
        Nfse_InfNfse_Servico_ItemListaServico = nfse_InfNfse_Servico_ItemListaServico;
    }

    public String getNfse_InfNfse_Servico_CodigoCnae() {
        return Nfse_InfNfse_Servico_CodigoCnae;
    }

    public void setNfse_InfNfse_Servico_CodigoCnae(String nfse_InfNfse_Servico_CodigoCnae) {
        Nfse_InfNfse_Servico_CodigoCnae = nfse_InfNfse_Servico_CodigoCnae;
    }

    public String getNfse_InfNfse_Servico_CodigoTributacaoMunicipio() {
        return Nfse_InfNfse_Servico_CodigoTributacaoMunicipio;
    }

    public void setNfse_InfNfse_Servico_CodigoTributacaoMunicipio(String nfse_InfNfse_Servico_CodigoTributacaoMunicipio) {
        Nfse_InfNfse_Servico_CodigoTributacaoMunicipio = nfse_InfNfse_Servico_CodigoTributacaoMunicipio;
    }

    public String getNfse_InfNfse_Servico_Discriminacao() {
        return Nfse_InfNfse_Servico_Discriminacao;
    }

    public void setNfse_InfNfse_Servico_Discriminacao(String nfse_InfNfse_Servico_Discriminacao) {
        Nfse_InfNfse_Servico_Discriminacao = nfse_InfNfse_Servico_Discriminacao;
    }

    public String getNfse_InfNfse_Servico_CodigoMunicipio() {
        return Nfse_InfNfse_Servico_CodigoMunicipio;
    }

    public void setNfse_InfNfse_Servico_CodigoMunicipio(String nfse_InfNfse_Servico_CodigoMunicipio) {
        Nfse_InfNfse_Servico_CodigoMunicipio = nfse_InfNfse_Servico_CodigoMunicipio;
    }

    public BigDecimal getNfse_InfNfse_ValorCredito() {
        return Nfse_InfNfse_ValorCredito;
    }

    public void setNfse_InfNfse_ValorCredito(BigDecimal nfse_InfNfse_ValorCredito) {
        Nfse_InfNfse_ValorCredito = nfse_InfNfse_ValorCredito;
    }

    public String getNfse_InfNfse_PrestadorServico_IdentificacaoPrestador_Cnpj() {
        return Nfse_InfNfse_PrestadorServico_IdentificacaoPrestador_Cnpj;
    }

    public void setNfse_InfNfse_PrestadorServico_IdentificacaoPrestador_Cnpj(String nfse_InfNfse_PrestadorServico_IdentificacaoPrestador_Cnpj) {
        Nfse_InfNfse_PrestadorServico_IdentificacaoPrestador_Cnpj = nfse_InfNfse_PrestadorServico_IdentificacaoPrestador_Cnpj;
    }

    public String getNfse_InfNfse_PrestadorServico_IdentificacaoPrestador_InscricaoMunicipal() {
        return Nfse_InfNfse_PrestadorServico_IdentificacaoPrestador_InscricaoMunicipal;
    }

    public void setNfse_InfNfse_PrestadorServico_IdentificacaoPrestador_InscricaoMunicipal(String nfse_InfNfse_PrestadorServico_IdentificacaoPrestador_InscricaoMunicipal) {
        Nfse_InfNfse_PrestadorServico_IdentificacaoPrestador_InscricaoMunicipal = nfse_InfNfse_PrestadorServico_IdentificacaoPrestador_InscricaoMunicipal;
    }

    public String getNfse_InfNfse_PrestadorServico_RazaoSocial() {
        return Nfse_InfNfse_PrestadorServico_RazaoSocial;
    }

    public void setNfse_InfNfse_PrestadorServico_RazaoSocial(String nfse_InfNfse_PrestadorServico_RazaoSocial) {
        Nfse_InfNfse_PrestadorServico_RazaoSocial = nfse_InfNfse_PrestadorServico_RazaoSocial;
    }

    public String getNfse_InfNfse_PrestadorServico_NomeFantasia() {
        return Nfse_InfNfse_PrestadorServico_NomeFantasia;
    }

    public void setNfse_InfNfse_PrestadorServico_NomeFantasia(String nfse_InfNfse_PrestadorServico_NomeFantasia) {
        Nfse_InfNfse_PrestadorServico_NomeFantasia = nfse_InfNfse_PrestadorServico_NomeFantasia;
    }

    public String getNfse_InfNfse_PrestadorServico_Endereco_Endereco() {
        return Nfse_InfNfse_PrestadorServico_Endereco_Endereco;
    }

    public void setNfse_InfNfse_PrestadorServico_Endereco_Endereco(String nfse_InfNfse_PrestadorServico_Endereco_Endereco) {
        Nfse_InfNfse_PrestadorServico_Endereco_Endereco = nfse_InfNfse_PrestadorServico_Endereco_Endereco;
    }

    public String getNfse_InfNfse_PrestadorServico_Endereco_Numero() {
        return Nfse_InfNfse_PrestadorServico_Endereco_Numero;
    }

    public void setNfse_InfNfse_PrestadorServico_Endereco_Numero(String nfse_InfNfse_PrestadorServico_Endereco_Numero) {
        Nfse_InfNfse_PrestadorServico_Endereco_Numero = nfse_InfNfse_PrestadorServico_Endereco_Numero;
    }

    public String getNfse_InfNfse_PrestadorServico_Endereco_Complemento() {
        return Nfse_InfNfse_PrestadorServico_Endereco_Complemento;
    }

    public void setNfse_InfNfse_PrestadorServico_Endereco_Complemento(String nfse_InfNfse_PrestadorServico_Endereco_Complemento) {
        Nfse_InfNfse_PrestadorServico_Endereco_Complemento = nfse_InfNfse_PrestadorServico_Endereco_Complemento;
    }

    public String getNfse_InfNfse_PrestadorServico_Endereco_Bairro() {
        return Nfse_InfNfse_PrestadorServico_Endereco_Bairro;
    }

    public void setNfse_InfNfse_PrestadorServico_Endereco_Bairro(String nfse_InfNfse_PrestadorServico_Endereco_Bairro) {
        Nfse_InfNfse_PrestadorServico_Endereco_Bairro = nfse_InfNfse_PrestadorServico_Endereco_Bairro;
    }

    public String getNfse_InfNfse_PrestadorServico_Endereco_CodigoMunicipio() {
        return Nfse_InfNfse_PrestadorServico_Endereco_CodigoMunicipio;
    }

    public void setNfse_InfNfse_PrestadorServico_Endereco_CodigoMunicipio(String nfse_InfNfse_PrestadorServico_Endereco_CodigoMunicipio) {
        Nfse_InfNfse_PrestadorServico_Endereco_CodigoMunicipio = nfse_InfNfse_PrestadorServico_Endereco_CodigoMunicipio;
    }

    public String getNfse_InfNfse_PrestadorServico_Endereco_Uf() {
        return Nfse_InfNfse_PrestadorServico_Endereco_Uf;
    }

    public void setNfse_InfNfse_PrestadorServico_Endereco_Uf(String nfse_InfNfse_PrestadorServico_Endereco_Uf) {
        Nfse_InfNfse_PrestadorServico_Endereco_Uf = nfse_InfNfse_PrestadorServico_Endereco_Uf;
    }

    public String getNfse_InfNfse_PrestadorServico_Endereco_Cep() {
        return Nfse_InfNfse_PrestadorServico_Endereco_Cep;
    }

    public void setNfse_InfNfse_PrestadorServico_Endereco_Cep(String nfse_InfNfse_PrestadorServico_Endereco_Cep) {
        Nfse_InfNfse_PrestadorServico_Endereco_Cep = nfse_InfNfse_PrestadorServico_Endereco_Cep;
    }

    public String getNfse_InfNfse_PrestadorServico_Contato_Telefone() {
        return Nfse_InfNfse_PrestadorServico_Contato_Telefone;
    }

    public void setNfse_InfNfse_PrestadorServico_Contato_Telefone(String nfse_InfNfse_PrestadorServico_Contato_Telefone) {
        Nfse_InfNfse_PrestadorServico_Contato_Telefone = nfse_InfNfse_PrestadorServico_Contato_Telefone;
    }

    public String getNfse_InfNfse_PrestadorServico_Contato_Email() {
        return Nfse_InfNfse_PrestadorServico_Contato_Email;
    }

    public void setNfse_InfNfse_PrestadorServico_Contato_Email(String nfse_InfNfse_PrestadorServico_Contato_Email) {
        Nfse_InfNfse_PrestadorServico_Contato_Email = nfse_InfNfse_PrestadorServico_Contato_Email;
    }

    public String getNfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cpf() {
        return Nfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cpf;
    }

    public void setNfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cpf(String nfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cpf) {
        Nfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cpf = nfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cpf;
    }

    public String getNfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cnpj() {
        return Nfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cnpj;
    }

    public void setNfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cnpj(String nfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cnpj) {
        Nfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cnpj = nfse_InfNfse_TomadorServico_IdentificacaoTomador_CpfCnpj_Cnpj;
    }

    public String getNfse_InfNfse_TomadorServico_IdentificacaoTomador_InscricaoMunicipal() {
        return Nfse_InfNfse_TomadorServico_IdentificacaoTomador_InscricaoMunicipal;
    }

    public void setNfse_InfNfse_TomadorServico_IdentificacaoTomador_InscricaoMunicipal(String nfse_InfNfse_TomadorServico_IdentificacaoTomador_InscricaoMunicipal) {
        Nfse_InfNfse_TomadorServico_IdentificacaoTomador_InscricaoMunicipal = nfse_InfNfse_TomadorServico_IdentificacaoTomador_InscricaoMunicipal;
    }

    public String getNfse_InfNfse_TomadorServico_RazaoSocial() {
        return Nfse_InfNfse_TomadorServico_RazaoSocial;
    }

    public void setNfse_InfNfse_TomadorServico_RazaoSocial(String nfse_InfNfse_TomadorServico_RazaoSocial) {
        Nfse_InfNfse_TomadorServico_RazaoSocial = nfse_InfNfse_TomadorServico_RazaoSocial;
    }

    public String getNfse_InfNfse_TomadorServico_Endereco_Endereco() {
        return Nfse_InfNfse_TomadorServico_Endereco_Endereco;
    }

    public void setNfse_InfNfse_TomadorServico_Endereco_Endereco(String nfse_InfNfse_TomadorServico_Endereco_Endereco) {
        Nfse_InfNfse_TomadorServico_Endereco_Endereco = nfse_InfNfse_TomadorServico_Endereco_Endereco;
    }

    public String getNfse_InfNfse_TomadorServico_Endereco_Numero() {
        return Nfse_InfNfse_TomadorServico_Endereco_Numero;
    }

    public void setNfse_InfNfse_TomadorServico_Endereco_Numero(String nfse_InfNfse_TomadorServico_Endereco_Numero) {
        Nfse_InfNfse_TomadorServico_Endereco_Numero = nfse_InfNfse_TomadorServico_Endereco_Numero;
    }

    public String getNfse_InfNfse_TomadorServico_Endereco_Complemento() {
        return Nfse_InfNfse_TomadorServico_Endereco_Complemento;
    }

    public void setNfse_InfNfse_TomadorServico_Endereco_Complemento(String nfse_InfNfse_TomadorServico_Endereco_Complemento) {
        Nfse_InfNfse_TomadorServico_Endereco_Complemento = nfse_InfNfse_TomadorServico_Endereco_Complemento;
    }

    public String getNfse_InfNfse_TomadorServico_Endereco_Bairro() {
        return Nfse_InfNfse_TomadorServico_Endereco_Bairro;
    }

    public void setNfse_InfNfse_TomadorServico_Endereco_Bairro(String nfse_InfNfse_TomadorServico_Endereco_Bairro) {
        Nfse_InfNfse_TomadorServico_Endereco_Bairro = nfse_InfNfse_TomadorServico_Endereco_Bairro;
    }

    public String getNfse_InfNfse_TomadorServico_Endereco_CodigoMunicipio() {
        return Nfse_InfNfse_TomadorServico_Endereco_CodigoMunicipio;
    }

    public void setNfse_InfNfse_TomadorServico_Endereco_CodigoMunicipio(String nfse_InfNfse_TomadorServico_Endereco_CodigoMunicipio) {
        Nfse_InfNfse_TomadorServico_Endereco_CodigoMunicipio = nfse_InfNfse_TomadorServico_Endereco_CodigoMunicipio;
    }

    public String getNfse_InfNfse_TomadorServico_Endereco_Uf() {
        return Nfse_InfNfse_TomadorServico_Endereco_Uf;
    }

    public void setNfse_InfNfse_TomadorServico_Endereco_Uf(String nfse_InfNfse_TomadorServico_Endereco_Uf) {
        Nfse_InfNfse_TomadorServico_Endereco_Uf = nfse_InfNfse_TomadorServico_Endereco_Uf;
    }

    public String getNfse_InfNfse_TomadorServico_Endereco_Cep() {
        return Nfse_InfNfse_TomadorServico_Endereco_Cep;
    }

    public void setNfse_InfNfse_TomadorServico_Endereco_Cep(String nfse_InfNfse_TomadorServico_Endereco_Cep) {
        Nfse_InfNfse_TomadorServico_Endereco_Cep = nfse_InfNfse_TomadorServico_Endereco_Cep;
    }

    public String getNfse_InfNfse_TomadorServico_Contato_Telefone() {
        return Nfse_InfNfse_TomadorServico_Contato_Telefone;
    }

    public void setNfse_InfNfse_TomadorServico_Contato_Telefone(String nfse_InfNfse_TomadorServico_Contato_Telefone) {
        Nfse_InfNfse_TomadorServico_Contato_Telefone = nfse_InfNfse_TomadorServico_Contato_Telefone;
    }

    public String getNfse_InfNfse_TomadorServico_Contato_Email() {
        return Nfse_InfNfse_TomadorServico_Contato_Email;
    }

    public void setNfse_InfNfse_TomadorServico_Contato_Email(String nfse_InfNfse_TomadorServico_Contato_Email) {
        Nfse_InfNfse_TomadorServico_Contato_Email = nfse_InfNfse_TomadorServico_Contato_Email;
    }

    public String getNfse_InfNfse_OrgaoGerador_CodigoMunicipio() {
        return Nfse_InfNfse_OrgaoGerador_CodigoMunicipio;
    }

    public void setNfse_InfNfse_OrgaoGerador_CodigoMunicipio(String nfse_InfNfse_OrgaoGerador_CodigoMunicipio) {
        Nfse_InfNfse_OrgaoGerador_CodigoMunicipio = nfse_InfNfse_OrgaoGerador_CodigoMunicipio;
    }

    public String getNfse_InfNfse_OrgaoGerador_Uf() {
        return Nfse_InfNfse_OrgaoGerador_Uf;
    }

    public void setNfse_InfNfse_OrgaoGerador_Uf(String nfse_InfNfse_OrgaoGerador_Uf) {
        Nfse_InfNfse_OrgaoGerador_Uf = nfse_InfNfse_OrgaoGerador_Uf;
    }

    public String getNfseCancelamento_Confirmacao_InfConfirmacaoCancelamento_Sucesso() {
        return NfseCancelamento_Confirmacao_InfConfirmacaoCancelamento_Sucesso;
    }

    public void setNfseCancelamento_Confirmacao_InfConfirmacaoCancelamento_Sucesso(String nfseCancelamento_Confirmacao_InfConfirmacaoCancelamento_Sucesso) {
        NfseCancelamento_Confirmacao_InfConfirmacaoCancelamento_Sucesso = nfseCancelamento_Confirmacao_InfConfirmacaoCancelamento_Sucesso;
    }
}
