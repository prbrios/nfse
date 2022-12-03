package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Endereco")
public class Endereco {

	@Element(name = "Endereco", required = false)
	protected String endereco;

	@Element(name = "Numero", required = false)
	protected String numero;

	@Element(name = "Complemento", required = false)
	protected String complemento;

	@Element(name = "Bairro", required = false)
	protected String bairro;

	@Element(name = "CodigoMunicipio", required = false)
	protected String codigoMunicipio;

	@Element(name = "Uf", required = false)
	protected String uf;

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
