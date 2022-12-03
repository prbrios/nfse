package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CompNfse")
public class CompNfse {

	@Element(name = "Nfse", required = false)
	private Nfse nfse;

	@Element(name = "NfseCancelamento", required = false)
	private CancelamentoNfse nfseCancelamento;

	@Element(name = "NfseSubstituicao", required = false)
	private SubstituicaoNfse nfseSubstituicao;

	public Nfse getNfse() {
		return nfse;
	}

	public void setNfse(Nfse nfse) {
		this.nfse = nfse;
	}

	public CancelamentoNfse getNfseCancelamento() {
		return nfseCancelamento;
	}

	public void setNfseCancelamento(CancelamentoNfse nfseCancelamento) {
		this.nfseCancelamento = nfseCancelamento;
	}

	public SubstituicaoNfse getNfseSubstituicao() {
		return nfseSubstituicao;
	}

	public void setNfseSubstituicao(SubstituicaoNfse nfseSubstituicao) {
		this.nfseSubstituicao = nfseSubstituicao;
	}
}
