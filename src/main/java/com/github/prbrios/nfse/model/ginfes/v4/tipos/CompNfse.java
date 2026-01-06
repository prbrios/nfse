package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CompNfse", strict = false)
public class CompNfse {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("nfse")
	@Element(name = "Nfse", required = false)
	private Nfse nfse;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("nfsecancelamento")
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
