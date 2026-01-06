package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "InfPedidoCancelamento", strict = false)
public class InfPedidoCancelamento {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("id")
	@Attribute(name = "Id", required = false)
	private String id;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("identificacaonfse")
	@Element(name = "IdentificacaoNfse", required = false)
	private IdentificacaoNfse identificacaoNfse;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigocancelamento")
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
