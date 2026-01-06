package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ValoresIbsCbs", strict = false)
public class ValoresIbsCbs {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("gruporeerepres")
	@Element(name = "GrupoReeRepRes", required = false)
	private GrupoReeRepRes grupoReeRepRes;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("tributosibscbs")
	@Element(name = "TributosIbsCbs", required = false)
	private TributosIbsCbs tributosIbsCbs;

	public GrupoReeRepRes getGrupoReeRepRes() {
		return grupoReeRepRes;
	}

	public void setGrupoReeRepRes(GrupoReeRepRes grupoReeRepRes) {
		this.grupoReeRepRes = grupoReeRepRes;
	}

	public TributosIbsCbs getTributosIbsCbs() {
		return tributosIbsCbs;
	}

	public void setTributosIbsCbs(TributosIbsCbs tributosIbsCbs) {
		this.tributosIbsCbs = tributosIbsCbs;
	}
}
