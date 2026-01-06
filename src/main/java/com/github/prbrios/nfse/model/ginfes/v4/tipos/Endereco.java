package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@JsonRootName("Endereco")
@Root(name = "Endereco", strict = false)
public class Endereco {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("endereco")
	@Element(name = "Endereco", required = false)
	protected String endereco;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("numero")
	@Element(name = "Numero", required = false)
	protected String numero;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("complemento")
	@Element(name = "Complemento", required = false)
	protected String complemento;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("bairro")
	@Element(name = "Bairro", required = false)
	protected String bairro;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigomunicipio")
	@Element(name = "CodigoMunicipio", required = false)
	protected String codigoMunicipio;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("uf")
	@Element(name = "Uf", required = false)
	protected String uf;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("cep")
	@Element(name = "Cep", required = false)
	protected String cep;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
