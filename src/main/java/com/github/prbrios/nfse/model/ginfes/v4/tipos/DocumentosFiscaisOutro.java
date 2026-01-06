package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DocumentosFiscaisOutro", strict = false)
public class DocumentosFiscaisOutro {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigomunicipiodocfiscal")
	@Element(name = "CodigoMunicipioDocFiscal", required = false)
		private String codigoMunicipioDocFiscal;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("numerodocumentofiscal")
	@Element(name = "NumeroDocumentoFiscal", required = false)
		private String numeroDocumentoFiscal;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("desctipochavedfe")
	@Element(name = "DescTipoChaveDFe", required = false)
		private String descTipoChaveDFe;

	public String getCodigoMunicipioDocFiscal() {
		return codigoMunicipioDocFiscal;
	}

	public void setCodigoMunicipioDocFiscal(String codigoMunicipioDocFiscal) {
		this.codigoMunicipioDocFiscal = codigoMunicipioDocFiscal;
	}

	public String getNumeroDocumentoFiscal() {
		return numeroDocumentoFiscal;
	}

	public void setNumeroDocumentoFiscal(String numeroDocumentoFiscal) {
		this.numeroDocumentoFiscal = numeroDocumentoFiscal;
	}

	public String getDescTipoChaveDFe() {
		return descTipoChaveDFe;
	}

	public void setDescTipoChaveDFe(String descTipoChaveDFe) {
		this.descTipoChaveDFe = descTipoChaveDFe;
	}
}
