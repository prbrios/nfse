package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Imovel", strict = false)
public class Imovel {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("inscimobfisc")
	@Element(name = "InscImobFisc", required = false)
		private String inscImobFisc;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigocib")
	@Element(name = "CodigoCIB", required = false)
		private String codigoCIB;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("endereco")
	@Element(name = "Endereco", required = false)
	private Endereco endereco;

	public String getInscImobFisc() {
		return inscImobFisc;
	}

	public void setInscImobFisc(String inscImobFisc) {
		this.inscImobFisc = inscImobFisc;
	}

	public String getCodigoCIB() {
		return codigoCIB;
	}

	public void setCodigoCIB(String codigoCIB) {
		this.codigoCIB = codigoCIB;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
