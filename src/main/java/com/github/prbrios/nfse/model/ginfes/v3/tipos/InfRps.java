package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "InfRps")
public class InfRps {

	@Attribute(name = "Id", required = false)
	protected String id;

	@Element(name = "IdentificacaoRps", required = false)
	protected IdentificacaoRps identificacaoRps;

	@Element(name = "DataEmissao", required = false)
	protected String dataEmissao;

	@Element(name = "NaturezaOperacao", required = false)
	protected String naturezaOperacao;

	@Element(name = "RegimeEspecialTributacao", required = false)
	protected String regimeEspecialTributacao;

	@Element(name = "OptanteSimplesNacional", required = false)
	protected String optanteSimplesNacional;

	@Element(name = "IncentivadorCultural", required = false)
	protected String incentivadorCultural;

	@Element(name = "Status", required = false)
	protected String status;

	@Element(name = "RpsSubstituido", required = false)
	protected IdentificacaoRps rpsSubstituido;

	@Element(name = "Servico", required = false)
	protected DadosServico servico;

	@Element(name = "Prestador", required = false)
	protected IdentificacaoPrestador prestador;

	@Element(name = "Tomador", required = false)
	protected DadosTomador tomador;

	@Element(name = "IntermediarioServico", required = false)
	protected IdentificacaoIntermediarioServico intermediarioServico;

	@Element(name = "ConstrucaoCivil", required = false)
	protected DadosConstrucaoCivil construcaoCivil;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IdentificacaoRps getIdentificacaoRps() {
		return identificacaoRps;
	}

	public void setIdentificacaoRps(IdentificacaoRps identificacaoRps) {
		this.identificacaoRps = identificacaoRps;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public IdentificacaoRps getRpsSubstituido() {
		return rpsSubstituido;
	}

	public void setRpsSubstituido(IdentificacaoRps rpsSubstituido) {
		this.rpsSubstituido = rpsSubstituido;
	}

	public DadosServico getServico() {
		return servico;
	}

	public void setServico(DadosServico servico) {
		this.servico = servico;
	}

	public IdentificacaoPrestador getPrestador() {
		return prestador;
	}

	public void setPrestador(IdentificacaoPrestador prestador) {
		this.prestador = prestador;
	}

	public DadosTomador getTomador() {
		return tomador;
	}

	public void setTomador(DadosTomador tomador) {
		this.tomador = tomador;
	}

	public IdentificacaoIntermediarioServico getIntermediarioServico() {
		return intermediarioServico;
	}

	public void setIntermediarioServico(IdentificacaoIntermediarioServico intermediarioServico) {
		this.intermediarioServico = intermediarioServico;
	}

	public DadosConstrucaoCivil getConstrucaoCivil() {
		return construcaoCivil;
	}

	public void setConstrucaoCivil(DadosConstrucaoCivil construcaoCivil) {
		this.construcaoCivil = construcaoCivil;
	}

}
