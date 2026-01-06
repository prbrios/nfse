package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.prbrios.nfse.model.signature.Signature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CancelamentoNfse", strict = false)
public class CancelamentoNfse {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("confirmacao")
	@Element(name = "Confirmacao", required = false)
	private ConfirmacaoCancelamento confirmacao;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("signature")
	@Element(name = "Signature", required = false)
	private Signature signature;

	public ConfirmacaoCancelamento getConfirmacao() {
		return confirmacao;
	}

	public void setConfirmacao(ConfirmacaoCancelamento confirmacao) {
		this.confirmacao = confirmacao;
	}

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}
}
