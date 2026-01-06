package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@JsonRootName("valores")
@Root(name = "Valores", strict = false)
public class Valores {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valorservicos")
	@Element(name = "ValorServicos", required = false)
	protected String valorServicos;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valordeducoes")
	@Element(name = "ValorDeducoes", required = false)
	protected String valorDeducoes;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valorpis")
	@Element(name = "ValorPis", required = false)
	protected String valorPis;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valorcofins")
	@Element(name = "ValorCofins", required = false)
	protected String valorCofins;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valorinss")
	@Element(name = "ValorInss", required = false)
	protected String valorInss;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valorir")
	@Element(name = "ValorIr", required = false)
	protected String valorIr;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valorcsll")
	@Element(name = "ValorCsll", required = false)
	protected String valorCsll;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("issretido")
	@Element(name = "IssRetido", required = false)
	protected String issRetido;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valoriss")
	@Element(name = "ValorIss", required = false)
	protected String valorIss;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valorissretido")
	@Element(name = "ValorIssRetido", required = false)
	protected String valorIssRetido;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("outrasretencoes")
	@Element(name = "OutrasRetencoes", required = false)
	protected String outrasRetencoes;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("basecalculo")
	@Element(name = "BaseCalculo", required = false)
	protected String baseCalculo;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("aliquota")
	@Element(name = "Aliquota", required = false)
	protected String aliquota;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valorliquidonfse")
	@Element(name = "ValorLiquidoNfse", required = false)
	protected String valorLiquidoNfse;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("descontoincondicionado")
	@Element(name = "DescontoIncondicionado", required = false)
	protected String descontoIncondicionado;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("descontocondicionado")
	@Element(name = "DescontoCondicionado", required = false)
	protected String descontoCondicionado;

	public String getValorServicos() {
		return valorServicos;
	}

	public void setValorServicos(String valorServicos) {
		this.valorServicos = valorServicos;
	}

	public String getValorDeducoes() {
		return valorDeducoes;
	}

	public void setValorDeducoes(String valorDeducoes) {
		this.valorDeducoes = valorDeducoes;
	}

	public String getValorPis() {
		return valorPis;
	}

	public void setValorPis(String valorPis) {
		this.valorPis = valorPis;
	}

	public String getValorCofins() {
		return valorCofins;
	}

	public void setValorCofins(String valorCofins) {
		this.valorCofins = valorCofins;
	}

	public String getValorInss() {
		return valorInss;
	}

	public void setValorInss(String valorInss) {
		this.valorInss = valorInss;
	}

	public String getValorIr() {
		return valorIr;
	}

	public void setValorIr(String valorIr) {
		this.valorIr = valorIr;
	}

	public String getValorCsll() {
		return valorCsll;
	}

	public void setValorCsll(String valorCsll) {
		this.valorCsll = valorCsll;
	}

	public String getIssRetido() {
		return issRetido;
	}

	public void setIssRetido(String issRetido) {
		this.issRetido = issRetido;
	}

	public String getValorIss() {
		return valorIss;
	}

	public void setValorIss(String valorIss) {
		this.valorIss = valorIss;
	}

	public String getValorIssRetido() {
		return valorIssRetido;
	}

	public void setValorIssRetido(String valorIssRetido) {
		this.valorIssRetido = valorIssRetido;
	}

	public String getOutrasRetencoes() {
		return outrasRetencoes;
	}

	public void setOutrasRetencoes(String outrasRetencoes) {
		this.outrasRetencoes = outrasRetencoes;
	}

	public String getBaseCalculo() {
		return baseCalculo;
	}

	public void setBaseCalculo(String baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public String getAliquota() {
		return aliquota;
	}

	public void setAliquota(String aliquota) {
		this.aliquota = aliquota;
	}

	public String getValorLiquidoNfse() {
		return valorLiquidoNfse;
	}

	public void setValorLiquidoNfse(String valorLiquidoNfse) {
		this.valorLiquidoNfse = valorLiquidoNfse;
	}

	public String getDescontoIncondicionado() {
		return descontoIncondicionado;
	}

	public void setDescontoIncondicionado(String descontoIncondicionado) {
		this.descontoIncondicionado = descontoIncondicionado;
	}

	public String getDescontoCondicionado() {
		return descontoCondicionado;
	}

	public void setDescontoCondicionado(String descontoCondicionado) {
		this.descontoCondicionado = descontoCondicionado;
	}
}
