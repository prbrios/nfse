package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DadosExploracaoRodovias", strict = false)
public class DadosExploracaoRodovias {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("categoriaveiculos")
	@Element(name = "CategoriaVeiculos", required = false)
	protected String categoriaVeiculos;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("numeroeixos")
	@Element(name = "NumeroEixos", required = false)
	protected String numeroEixos;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("rodagem")
	@Element(name = "Rodagem", required = false)
	protected String rodagem;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("sentido")
	@Element(name = "Sentido", required = false)
	protected String sentido;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("placa")
	@Element(name = "Placa", required = false)
	protected String placa;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigoacesso")
	@Element(name = "CodigoAcesso", required = false)
	protected String codigoAcesso;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigocontrato")
	@Element(name = "CodigoContrato", required = false)
	protected String codigoContrato;

	public String getCategoriaVeiculos() {
		return categoriaVeiculos;
	}

	public void setCategoriaVeiculos(String categoriaVeiculos) {
		this.categoriaVeiculos = categoriaVeiculos;
	}

	public String getNumeroEixos() {
		return numeroEixos;
	}

	public void setNumeroEixos(String numeroEixos) {
		this.numeroEixos = numeroEixos;
	}

	public String getRodagem() {
		return rodagem;
	}

	public void setRodagem(String rodagem) {
		this.rodagem = rodagem;
	}

	public String getSentido() {
		return sentido;
	}

	public void setSentido(String sentido) {
		this.sentido = sentido;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCodigoAcesso() {
		return codigoAcesso;
	}

	public void setCodigoAcesso(String codigoAcesso) {
		this.codigoAcesso = codigoAcesso;
	}

	public String getCodigoContrato() {
		return codigoContrato;
	}

	public void setCodigoContrato(String codigoContrato) {
		this.codigoContrato = codigoContrato;
	}
}
