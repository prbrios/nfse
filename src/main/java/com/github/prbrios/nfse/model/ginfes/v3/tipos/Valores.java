package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Valores")
public class Valores {

	@Element(name = "ValorServicos", required = false)
	protected String valorServicos;

	@Element(name = "ValorDeducoes", required = false)
	protected String valorDeducoes;

	@Element(name = "ValorPis", required = false)
	protected String valorPis;

	@Element(name = "ValorCofins", required = false)
	protected String valorCofins;

	@Element(name = "ValorInss", required = false)
	protected String valorInss;

	@Element(name = "ValorIr", required = false)
	protected String valorIr;

	@Element(name = "ValorCsll", required = false)
	protected String valorCsll;

	@Element(name = "IssRetido", required = false)
	protected String issRetido;

	@Element(name = "ValorIss", required = false)
	protected String valorIss;

	@Element(name = "ValorIssRetido", required = false)
	protected String valorIssRetido;

	@Element(name = "OutrasRetencoes", required = false)
	protected String outrasRetencoes;

	@Element(name = "BaseCalculo", required = false)
	protected String baseCalculo;

	@Element(name = "Aliquota", required = false)
	protected String aliquota;

	@Element(name = "ValorLiquidoNfse", required = false)
	protected String valorLiquidoNfse;

	@Element(name = "DescontoIncondicionado", required = false)
	protected String descontoIncondicionado;

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
