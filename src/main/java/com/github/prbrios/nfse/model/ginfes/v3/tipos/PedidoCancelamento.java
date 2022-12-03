package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import com.github.prbrios.nfse.model.signature.Signature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "PedidoCancelamento")
public class PedidoCancelamento {

	@Element(name = "InfPedidoCancelamento", required = false)
	private InfPedidoCancelamento infPedidoCancelamento;

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
