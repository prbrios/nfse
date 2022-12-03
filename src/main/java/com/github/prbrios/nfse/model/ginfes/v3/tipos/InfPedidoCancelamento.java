package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "InfPedidoCancelamento")
public class InfPedidoCancelamento {

	@Attribute(name = "Id", required = false)
	private String id;

	@Element(name = "IdentificacaoNfse", required = false)
	private IdentificacaoNfse identificacaoNfse;

	@Element(name = "CodigoCancelamento", required = false)
	private String codigoCancelamento;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IdentificacaoNfse getIdentificacaoNfse() {
		return identificacaoNfse;
	}

	public void setIdentificacaoNfse(IdentificacaoNfse identificacaoNfse) {
		this.identificacaoNfse = identificacaoNfse;
	}

	public String getCodigoCancelamento() {
		return codigoCancelamento;
	}

	public void setCodigoCancelamento(String codigoCancelamento) {
		this.codigoCancelamento = codigoCancelamento;
	}
}
