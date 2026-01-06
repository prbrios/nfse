package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Destinatario", strict = false)
public class Destinatario {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("cpfcnpj")
	@Element(name = "CpfCnpj", required = false)
	private CpfCnpj cpfCnpj;

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

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("endereco")
	@Element(name = "Endereco", required = false)
	private Endereco endereco;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("contato")
	@Element(name = "Contato", required = false)
	private Contato contato;

	public CpfCnpj getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(CpfCnpj cpfCnpj) {
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
}
