package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DadosPrestador")
public class DadosPrestador {

	@Element(name = "IdentificacaoPrestador", required = false)
	protected IdentificacaoPrestador identificacaoPrestador;

	@Element(name = "RazaoSocial", required = false)
	protected String razaoSocial;

	@Element(name = "NomeFantasia", required = false)
	protected String nomeFantasia;

	@Element(name = "Endereco", required = false)
	protected Endereco endereco;

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
