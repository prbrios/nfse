package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DadosPrestador", strict = false)
public class DadosPrestador {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("identificacaoprestador")
	@Element(name = "IdentificacaoPrestador", required = false)
	protected IdentificacaoPrestador identificacaoPrestador;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("razaosocial")
	@Element(name = "RazaoSocial", required = false)
	protected String razaoSocial;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("nomefantasia")
	@Element(name = "NomeFantasia", required = false)
	protected String nomeFantasia;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("endereco")
	@Element(name = "Endereco", required = false)
	protected Endereco endereco;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("contato")
	@Element(name = "Contato", required = false)
	protected Contato contato;

	public IdentificacaoPrestador getIdentificacaoPrestador() {
		return identificacaoPrestador;
	}

	public void setIdentificacaoPrestador(IdentificacaoPrestador identificacaoPrestador) {
		this.identificacaoPrestador = identificacaoPrestador;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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
