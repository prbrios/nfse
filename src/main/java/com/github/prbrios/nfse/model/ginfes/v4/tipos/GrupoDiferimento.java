package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "GrupoDiferimento", strict = false)
public class GrupoDiferimento {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("percentualdiferimentoibsuf")
	@Element(name = "PercentualDiferimentoIbsUf", required = false)
		private String percentualDiferimentoIbsUf;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("percentualdiferimentoibsmun")
	@Element(name = "PercentualDiferimentoIbsMun", required = false)
		private String percentualDiferimentoIbsMun;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("percentualdiferimentocbs")
	@Element(name = "PercentualDiferimentoCbs", required = false)
		private String percentualDiferimentoCbs;

	public String getPercentualDiferimentoIbsUf() {
		return percentualDiferimentoIbsUf;
	}

	public void setPercentualDiferimentoIbsUf(String percentualDiferimentoIbsUf) {
		this.percentualDiferimentoIbsUf = percentualDiferimentoIbsUf;
	}

	public String getPercentualDiferimentoIbsMun() {
		return percentualDiferimentoIbsMun;
	}

	public void setPercentualDiferimentoIbsMun(String percentualDiferimentoIbsMun) {
		this.percentualDiferimentoIbsMun = percentualDiferimentoIbsMun;
	}

	public String getPercentualDiferimentoCbs() {
		return percentualDiferimentoCbs;
	}

	public void setPercentualDiferimentoCbs(String percentualDiferimentoCbs) {
		this.percentualDiferimentoCbs = percentualDiferimentoCbs;
	}
}
