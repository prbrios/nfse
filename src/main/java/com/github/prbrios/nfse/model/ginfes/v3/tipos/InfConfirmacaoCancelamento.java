package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "InfConfirmacaoCancelamento")
public class InfConfirmacaoCancelamento {

	@Element(name = "Sucesso", required = false)
	private Boolean sucesso;

	@Element(name = "DataHora", required = false)
	private String dataHora;

	public Boolean getSucesso() {
		return sucesso;
	}

	public void setSucesso(Boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
}
