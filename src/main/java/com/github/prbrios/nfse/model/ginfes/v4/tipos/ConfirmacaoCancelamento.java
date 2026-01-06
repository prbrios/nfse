package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ConfirmacaoCancelamento", strict = false)
public class ConfirmacaoCancelamento {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("id")
	@Attribute(name = "Id", required = false)
	private String id;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("pedido")
	@Element(name = "Pedido", required = false)
	private PedidoCancelamento pedido;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("infconfirmacaocancelamento")
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
