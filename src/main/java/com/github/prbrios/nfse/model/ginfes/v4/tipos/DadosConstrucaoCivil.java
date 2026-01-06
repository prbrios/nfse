package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ConstrucaoCivil", strict = false)
public class DadosConstrucaoCivil {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigoobra")
	@Element(name = "CodigoObra", required = false)
	protected String codigoObra;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("art")
	@Element(name = "Art", required = false)
	protected String art;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("inscimobfiscal")
	@Element(name = "InscImobFiscal", required = false)
	protected String inscImobFiscal;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("cadnacobra")
	@Element(name = "CadNacObra", required = false)
	protected String cadNacObra;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("endereco")
	@Element(name = "Endereco", required = false)
	protected Endereco endereco;

	public String getCodigoObra() {
		return codigoObra;
	}

	public void setCodigoObra(String codigoObra) {
		this.codigoObra = codigoObra;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public String getInscImobFiscal() {
		return inscImobFiscal;
	}

	public void setInscImobFiscal(String inscImobFiscal) {
		this.inscImobFiscal = inscImobFiscal;
	}

	public String getCadNacObra() {
		return cadNacObra;
	}

	public void setCadNacObra(String cadNacObra) {
		this.cadNacObra = cadNacObra;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
