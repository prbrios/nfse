package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "IdentificacaoOrgaoGerador", strict = false)
public class IdentificacaoOrgaoGerador {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigomunicipio")
	@Element(name = "CodigoMunicipio", required = false)
		private String codigoMunicipio;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("uf")
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
