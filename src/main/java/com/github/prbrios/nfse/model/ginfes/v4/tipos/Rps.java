package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.github.prbrios.nfse.model.signature.Signature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@JsonRootName("rps")
@Root(name = "Rps", strict = false)
public class Rps {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("infrps")
	@Element(name = "InfRps", required = false)
	protected InfRps infRps;

	@Element(name = "Signature", required = false)
	protected Signature signature;

	public InfRps getInfRps() {
		return infRps;
	}

	public void setInfRps(InfRps infRps) {
		this.infRps = infRps;
	}

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}

}
