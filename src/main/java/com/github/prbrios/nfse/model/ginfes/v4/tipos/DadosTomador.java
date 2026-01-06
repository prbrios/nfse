package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@JsonRootName("dadostomador")
@Root(name = "DadosTomador", strict = false)
public class DadosTomador {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("identificacaotomador")
	@Element(name = "IdentificacaoTomador", required = false)
	protected IdentificacaoTomador identificacaoTomador;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("razaosocial")
	@Element(name = "RazaoSocial", required = false)
	protected String razaoSocial;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("endereco")
	@Element(name = "Endereco", required = false)
	protected Endereco endereco;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("contato")
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
