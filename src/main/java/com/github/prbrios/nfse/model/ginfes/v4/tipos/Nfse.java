package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.prbrios.nfse.model.signature.Signature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Nfse", strict = false)
public class Nfse {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("infnfse")
	@Element(name = "InfNfse", required = false)
	private InfNfse infNfse;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("signature")
	@Element(name = "Signature", required = false)
	private Signature signature;

	public InfNfse getInfNfse() {
		return infNfse;
	}

	public void setInfNfse(InfNfse infNfse) {
		this.infNfse = infNfse;
	}

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}
}
