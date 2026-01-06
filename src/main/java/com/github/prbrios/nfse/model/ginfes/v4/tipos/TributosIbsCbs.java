package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TributosIbsCbs", strict = false)
public class TributosIbsCbs {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("grupoibscbs")
	@Element(name = "GrupoIbsCbs", required = false)
	private GrupoIbsCbs grupoIbsCbs;

	public GrupoIbsCbs getGrupoIbsCbs() {
		return grupoIbsCbs;
	}

	public void setGrupoIbsCbs(GrupoIbsCbs grupoIbsCbs) {
		this.grupoIbsCbs = grupoIbsCbs;
	}
}
