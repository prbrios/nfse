package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "GrupoNFSeReferenciada", strict = false)
public class GrupoNFSeReferenciada {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("chavenfsereferenciada")
	@ElementList(entry = "ChaveNFSeReferenciada", inline = true)
		private List<String> chaveNFSeReferenciada = new ArrayList<>();

	public List<String> getChaveNFSeReferenciada() {
		return chaveNFSeReferenciada;
	}

	public void setChaveNFSeReferenciada(List<String> chaveNFSeReferenciada) {
		this.chaveNFSeReferenciada = chaveNFSeReferenciada;
	}
}
