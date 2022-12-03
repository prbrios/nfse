package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DadosTomador")
public class DadosTomador {

	@Element(name = "IdentificacaoTomador", required = false)
	protected IdentificacaoTomador identificacaoTomador;

	@Element(name = "RazaoSocial", required = false)
	protected String razaoSocial;

	@Element(name = "Endereco", required = false)
	protected Endereco endereco;

	@Element(name = "Contato", required = false)
	protected Contato contato;

	public IdentificacaoTomador getIdentificacaoTomador() {
		return identificacaoTomador;
	}

	public void setIdentificacaoTomador(IdentificacaoTomador identificacaoTomador) {
		this.identificacaoTomador = identificacaoTomador;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
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
