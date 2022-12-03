package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import com.github.prbrios.nfse.model.signature.Signature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CancelamentoNfse")
public class CancelamentoNfse {

	@Element(name = "Confirmacao", required = false)
	private ConfirmacaoCancelamento confirmacao;

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
