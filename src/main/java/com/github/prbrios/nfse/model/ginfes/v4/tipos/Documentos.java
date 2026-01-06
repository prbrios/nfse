package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Documentos", strict = false)
public class Documentos {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("documentosfiscaiseletronicos")
	@Element(name = "DocumentosFiscaisEletronicos", required = false)
	private DocumentosFiscaisEletronicos documentosFiscaisEletronicos;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("documentosfiscaisoutro")
	@Element(name = "DocumentosFiscaisOutro", required = false)
	private DocumentosFiscaisOutro documentosFiscaisOutro;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("documentosoutro")
	@Element(name = "DocumentosOutro", required = false)
	private DocumentosOutro documentosOutro;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("fornecedor")
	@Element(name = "Fornecedor", required = false)
	private Fornecedor fornecedor;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("dataemissaodocumento")
	@Element(name = "DataEmissaoDocumento", required = false)
		private String dataEmissaoDocumento;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("datacompetenciadocumento")
	@Element(name = "DataCompetenciaDocumento", required = false)
		private String dataCompetenciaDocumento;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("tiporeerepres")
	@Element(name = "TipoReeRepRes", required = false)
		private String tipoReeRepRes;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("desctiporeerepres")
	@Element(name = "DescTipoReeRepRes", required = false)
		private String descTipoReeRepRes;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valorreerepres")
	@Element(name = "ValorReeRepRes", required = false)
		private String valorReeRepRes;

	public DocumentosFiscaisEletronicos getDocumentosFiscaisEletronicos() {
		return documentosFiscaisEletronicos;
	}

	public void setDocumentosFiscaisEletronicos(DocumentosFiscaisEletronicos documentosFiscaisEletronicos) {
		this.documentosFiscaisEletronicos = documentosFiscaisEletronicos;
	}

	public DocumentosFiscaisOutro getDocumentosFiscaisOutro() {
		return documentosFiscaisOutro;
	}

	public void setDocumentosFiscaisOutro(DocumentosFiscaisOutro documentosFiscaisOutro) {
		this.documentosFiscaisOutro = documentosFiscaisOutro;
	}

	public DocumentosOutro getDocumentosOutro() {
		return documentosOutro;
	}

	public void setDocumentosOutro(DocumentosOutro documentosOutro) {
		this.documentosOutro = documentosOutro;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDataEmissaoDocumento() {
		return dataEmissaoDocumento;
	}

	public void setDataEmissaoDocumento(String dataEmissaoDocumento) {
		this.dataEmissaoDocumento = dataEmissaoDocumento;
	}

	public String getDataCompetenciaDocumento() {
		return dataCompetenciaDocumento;
	}

	public void setDataCompetenciaDocumento(String dataCompetenciaDocumento) {
		this.dataCompetenciaDocumento = dataCompetenciaDocumento;
	}

	public String getTipoReeRepRes() {
		return tipoReeRepRes;
	}

	public void setTipoReeRepRes(String tipoReeRepRes) {
		this.tipoReeRepRes = tipoReeRepRes;
	}

	public String getDescTipoReeRepRes() {
		return descTipoReeRepRes;
	}

	public void setDescTipoReeRepRes(String descTipoReeRepRes) {
		this.descTipoReeRepRes = descTipoReeRepRes;
	}

	public String getValorReeRepRes() {
		return valorReeRepRes;
	}

	public void setValorReeRepRes(String valorReeRepRes) {
		this.valorReeRepRes = valorReeRepRes;
	}
}
