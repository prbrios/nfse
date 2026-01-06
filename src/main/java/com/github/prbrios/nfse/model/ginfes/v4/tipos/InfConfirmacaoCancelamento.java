package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "InfConfirmacaoCancelamento", strict = false)
public class InfConfirmacaoCancelamento {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("sucesso")
	@Element(name = "Sucesso", required = false)
	private Boolean sucesso;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("datahora")
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
