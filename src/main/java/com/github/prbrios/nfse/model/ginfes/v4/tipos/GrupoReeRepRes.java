package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "GrupoReeRepRes", strict = false)
public class GrupoReeRepRes {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("documentos")
	@ElementList(name = "Documentos", required = false, inline = true)
	private List<Documentos> documentos = new ArrayList<>();

	public List<Documentos> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documentos> documentos) {
		this.documentos = documentos;
	}
}
