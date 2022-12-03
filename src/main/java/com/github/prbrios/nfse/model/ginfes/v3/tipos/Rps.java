package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import com.github.prbrios.nfse.model.signature.Signature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Rps")
public class Rps {

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
