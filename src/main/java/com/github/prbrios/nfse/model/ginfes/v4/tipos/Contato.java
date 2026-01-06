package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@JsonRootName("contato")
@Root(name = "Contato", strict = false)
public class Contato {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("telefone")
	@Element(name = "Telefone", required = false)
	protected String telefone;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("email")
	@Element(name = "Email", required = false)
	protected String email;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
