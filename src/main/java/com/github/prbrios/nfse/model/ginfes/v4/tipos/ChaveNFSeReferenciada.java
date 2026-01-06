package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Text;

@Element(name="ChaveNFSeReferenciada", data=true)
public class ChaveNFSeReferenciada {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("value")
	@Text
	public String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
