package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Element;

public class IdentificacaoOrgaoGerador {

	@Element(name = "CodigoMunicipio", required = false)
	private String codigoMunicipio;

	@Element(name = "Uf", required = false)
	private String uf;

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
}
