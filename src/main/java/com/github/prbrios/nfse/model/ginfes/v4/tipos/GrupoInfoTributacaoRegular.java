package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "GrupoInfoTributacaoRegular", strict = false)
public class GrupoInfoTributacaoRegular {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigosittribreg")
	@Element(name = "CodigoSitTribReg", required = false)
		private String codigoSitTribReg;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigoclasstribreg")
	@Element(name = "CodigoClassTribReg", required = false)
		private String codigoClassTribReg;

	public String getCodigoSitTribReg() {
		return codigoSitTribReg;
	}

	public void setCodigoSitTribReg(String codigoSitTribReg) {
		this.codigoSitTribReg = codigoSitTribReg;
	}

	public String getCodigoClassTribReg() {
		return codigoClassTribReg;
	}

	public void setCodigoClassTribReg(String codigoClassTribReg) {
		this.codigoClassTribReg = codigoClassTribReg;
	}

}
