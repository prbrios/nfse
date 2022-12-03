package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ConfirmacaoCancelamento")
public class ConfirmacaoCancelamento {

	@Attribute(name = "Id", required = false)
	private String id;

	@Element(name = "Pedido", required = false)
	private PedidoCancelamento pedido;

	@Element(name = "InfConfirmacaoCancelamento", required = false)
	private InfConfirmacaoCancelamento infConfirmacaoCancelamento;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PedidoCancelamento getPedido() {
		return pedido;
	}

	public void setPedido(PedidoCancelamento pedido) {
		this.pedido = pedido;
	}

	public InfConfirmacaoCancelamento getInfConfirmacaoCancelamento() {
		return infConfirmacaoCancelamento;
	}

	public void setInfConfirmacaoCancelamento(InfConfirmacaoCancelamento infConfirmacaoCancelamento) {
		this.infConfirmacaoCancelamento = infConfirmacaoCancelamento;
	}
}
