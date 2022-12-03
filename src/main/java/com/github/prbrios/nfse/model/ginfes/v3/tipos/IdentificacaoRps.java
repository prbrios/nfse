package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "IdentificacaoRps")
public class IdentificacaoRps {

	@Element(name = "Numero", required = false)
	protected String numero;

	@Element(name = "Serie", required = false)
	protected String serie;

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
