package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Fornecedor", strict = false)
public class Fornecedor {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("cpfcnpj")
	@Element(name = "CpfCnpj", required = false)
		private String cpfCnpj;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("nif")
	@Element(name = "Nif", required = false)
		private String nif;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("naonif")
	@Element(name = "NaoNif", required = false)
		private String naoNif;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("nome")
	@Element(name = "Nome", required = false)
		private String nome;

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNaoNif() {
		return naoNif;
	}

	public void setNaoNif(String naoNif) {
		this.naoNif = naoNif;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
