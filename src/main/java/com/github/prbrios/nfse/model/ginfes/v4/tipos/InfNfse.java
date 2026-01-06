package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "InfNfse", strict = false)
public class InfNfse {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("id")
	@Attribute(name = "Id", required = false)
	private String id;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("numero")
	@Element(name = "Numero", required = false)
	private String numero;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigoverificacao")
	@Element(name = "CodigoVerificacao", required = false)
	private String codigoVerificacao;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("dataemissao")
	@Element(name = "DataEmissao", required = false)
	private String dataEmissao;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("identificacaorps")
	@Element(name = "IdentificacaoRps", required = false)
	private IdentificacaoRps identificacaoRps;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("dataemissaorps")
	@Element(name = "DataEmissaoRps", required = false)
	private String dataEmissaoRps;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("naturezaoperacao")
	@Element(name = "NaturezaOperacao", required = false)
	private String naturezaOperacao;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("regimeespecialtributacao")
	@Element(name = "RegimeEspecialTributacao", required = false)
	private String regimeEspecialTributacao;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("optantesimplesnacional")
	@Element(name = "OptanteSimplesNacional", required = false)
	private String optanteSimplesNacional;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("incentivadorcultural")
	@Element(name = "IncentivadorCultural", required = false)
	private String incentivadorCultural;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("competencia")
	@Element(name = "Competencia", required = false)
	private String competencia;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("nfsesubstituida")
	@Element(name = "NfseSubstituida", required = false)
	private String nfseSubstituida;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("outrasinformacoes")
	@Element(name = "OutrasInformacoes", required = false)
	private String outrasInformacoes;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("servico")
	@Element(name = "Servico", required = false)
	private DadosServico servico;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valorcredito")
	@Element(name = "ValorCredito", required = false)
	private String valorCredito;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("prestadorservico")
	@Element(name = "PrestadorServico", required = false)
	private DadosPrestador prestadorServico;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("tomadorservico")
	@Element(name = "TomadorServico", required = false)
	private DadosTomador tomadorServico;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("intermediarioservico")
	@Element(name = "IntermediarioServico", required = false)
	private IdentificacaoIntermediarioServico intermediarioServico;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("orgaogerador")
	@Element(name = "OrgaoGerador", required = false)
	private IdentificacaoOrgaoGerador orgaoGerador;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("construcaocivil")
	@Element(name = "ConstrucaoCivil", required = false)
	private DadosConstrucaoCivil construcaoCivil;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigoVerificacao() {
		return codigoVerificacao;
	}

	public void setCodigoVerificacao(String codigoVerificacao) {
		this.codigoVerificacao = codigoVerificacao;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public IdentificacaoRps getIdentificacaoRps() {
		return identificacaoRps;
	}

	public void setIdentificacaoRps(IdentificacaoRps identificacaoRps) {
		this.identificacaoRps = identificacaoRps;
	}

	public String getDataEmissaoRps() {
		return dataEmissaoRps;
	}

	public void setDataEmissaoRps(String dataEmissaoRps) {
		this.dataEmissaoRps = dataEmissaoRps;
	}

	public String getNaturezaOperacao() {
		return naturezaOperacao;
	}

	public void setNaturezaOperacao(String naturezaOperacao) {
		this.naturezaOperacao = naturezaOperacao;
	}

	public String getRegimeEspecialTributacao() {
		return regimeEspecialTributacao;
	}

	public void setRegimeEspecialTributacao(String regimeEspecialTributacao) {
		this.regimeEspecialTributacao = regimeEspecialTributacao;
	}

	public String getOptanteSimplesNacional() {
		return optanteSimplesNacional;
	}

	public void setOptanteSimplesNacional(String optanteSimplesNacional) {
		this.optanteSimplesNacional = optanteSimplesNacional;
	}

	public String getIncentivadorCultural() {
		return incentivadorCultural;
	}

	public void setIncentivadorCultural(String incentivadorCultural) {
		this.incentivadorCultural = incentivadorCultural;
	}

	public String getCompetencia() {
		return competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public String getNfseSubstituida() {
		return nfseSubstituida;
	}

	public void setNfseSubstituida(String nfseSubstituida) {
		this.nfseSubstituida = nfseSubstituida;
	}

	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}

	public void setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}

	public DadosServico getServico() {
		return servico;
	}

	public void setServico(DadosServico servico) {
		this.servico = servico;
	}

	public String getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(String valorCredito) {
		this.valorCredito = valorCredito;
	}

	public DadosPrestador getPrestadorServico() {
		return prestadorServico;
	}

	public void setPrestadorServico(DadosPrestador prestadorServico) {
		this.prestadorServico = prestadorServico;
	}

	public DadosTomador getTomadorServico() {
		return tomadorServico;
	}

	public void setTomadorServico(DadosTomador tomadorServico) {
		this.tomadorServico = tomadorServico;
	}

	public IdentificacaoIntermediarioServico getIntermediarioServico() {
		return intermediarioServico;
	}

	public void setIntermediarioServico(IdentificacaoIntermediarioServico intermediarioServico) {
		this.intermediarioServico = intermediarioServico;
	}

	public IdentificacaoOrgaoGerador getOrgaoGerador() {
		return orgaoGerador;
	}

	public void setOrgaoGerador(IdentificacaoOrgaoGerador orgaoGerador) {
		this.orgaoGerador = orgaoGerador;
	}

	public DadosConstrucaoCivil getConstrucaoCivil() {
		return construcaoCivil;
	}

	public void setConstrucaoCivil(DadosConstrucaoCivil construcaoCivil) {
		this.construcaoCivil = construcaoCivil;
	}
}
