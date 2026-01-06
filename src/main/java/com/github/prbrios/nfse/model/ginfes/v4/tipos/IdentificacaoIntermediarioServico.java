package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "IdentificacaoIntermediarioServico", strict = false)
public class IdentificacaoIntermediarioServico {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("razaosocial")
	@Element(name = "RazaoSocial", required = false)
	protected String razaoSocial;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("cpfcnpj")
	@Element(name = "CpfCnpj", required = false)
	protected CpfCnpj cpfCnpj;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("inscricaomunicipal")
	@Element(name = "InscricaoMunicipal", required = false)
	protected String inscricaoMunicipal;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("endereco")
	@Element(name = "Endereco", required = false)
	protected Endereco endereco;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("contato")
	@Element(name = "Contato", required = false)
	protected Contato contato;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public CpfCnpj getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(CpfCnpj cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
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
