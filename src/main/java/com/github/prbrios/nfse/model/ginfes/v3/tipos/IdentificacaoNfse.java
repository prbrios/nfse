package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "IdentificacaoNfse")
public class IdentificacaoNfse {

	@Element(name = "Numero", required = false)
	private String numero;

	@Element(name = "Cnpj", required = false)
	private String cnpj;

	@Element(name = "InscricaoMunicipal", required = false)
	private String inscricaoMunicipal;

	@Element(name = "CodigoMunicipio", required = false)
	private String codigoMunicipio;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}
}
