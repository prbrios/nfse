package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DocumentosFiscaisEletronicos", strict = false)
public class DocumentosFiscaisEletronicos {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("tipochavedfe")
	@Element(name = "TipoChaveDFe", required = false)
		private String tipoChaveDFe;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("desctipochavedfe")
	@Element(name = "DescTipoChaveDFe", required = false)
		private String descTipoChaveDFe;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("chavedfe")
	@Element(name = "ChaveDFe", required = false)
		private String chaveDFe;

	public String getTipoChaveDFe() {
		return tipoChaveDFe;
	}

	public void setTipoChaveDFe(String tipoChaveDFe) {
		this.tipoChaveDFe = tipoChaveDFe;
	}

	public String getDescTipoChaveDFe() {
		return descTipoChaveDFe;
	}

	public void setDescTipoChaveDFe(String descTipoChaveDFe) {
		this.descTipoChaveDFe = descTipoChaveDFe;
	}

	public String getChaveDFe() {
		return chaveDFe;
	}

	public void setChaveDFe(String chaveDFe) {
		this.chaveDFe = chaveDFe;
	}
}
