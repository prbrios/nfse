package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.prbrios.nfse.model.signature.Signature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "PedidoCancelamento", strict = false)
public class PedidoCancelamento {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("infpedidocancelamento")
	@Element(name = "InfPedidoCancelamento", required = false)
	private InfPedidoCancelamento infPedidoCancelamento;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("signature")
	@Element(name = "Signature", required = false)
	private Signature signature;

	public InfPedidoCancelamento getInfPedidoCancelamento() {
		return infPedidoCancelamento;
	}

	public void setInfPedidoCancelamento(InfPedidoCancelamento infPedidoCancelamento) {
		this.infPedidoCancelamento = infPedidoCancelamento;
	}

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}

}
