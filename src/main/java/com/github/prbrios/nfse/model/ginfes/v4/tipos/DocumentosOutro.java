package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DocumentosOutro", strict = false)
public class DocumentosOutro {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("numerodocumentooutro")
	@Element(name = "NumeroDocumentoOutro", required = false)
		private String numeroDocumentoOutro;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("descdocumentooutro")
	@Element(name = "DescDocumentoOutro", required = false)
		private String descDocumentoOutro;

	public String getNumeroDocumentoOutro() {
		return numeroDocumentoOutro;
	}

	public void setNumeroDocumentoOutro(String numeroDocumentoOutro) {
		this.numeroDocumentoOutro = numeroDocumentoOutro;
	}

	public String getDescDocumentoOutro() {
		return descDocumentoOutro;
	}

	public void setDescDocumentoOutro(String descDocumentoOutro) {
		this.descDocumentoOutro = descDocumentoOutro;
	}
}
