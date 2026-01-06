package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@JsonRootName("identificacaorps")
@Root(name = "IdentificacaoRps", strict = false)
public class IdentificacaoRps {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("numero")
	@Element(name = "Numero", required = false)
	protected String numero;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("serie")
	@Element(name = "Serie", required = false)
	protected String serie;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("tipo")
	@Element(name = "Tipo", required = false)
	protected String tipo;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
