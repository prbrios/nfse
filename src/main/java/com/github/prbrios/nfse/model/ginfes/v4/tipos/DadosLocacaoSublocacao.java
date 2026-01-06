package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DadosLocacaoSublocacao", strict = false)
public class DadosLocacaoSublocacao {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("categoriaservico")
	@Element(name = "CategoriaServico", required = false)
	protected String categoriaServico;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("tipoobjeto")
	@Element(name = "TipoObjeto", required = false)
	protected String tipoObjeto;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("extensao")
	@Element(name = "Extensao", required = false)
	protected String extensao;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("numeropostes")
	@Element(name = "NumeroPostes", required = false)
	protected String numeroPostes;

	public String getCategoriaServico() {
		return categoriaServico;
	}

	public void setCategoriaServico(String categoriaServico) {
		this.categoriaServico = categoriaServico;
	}

	public String getTipoObjeto() {
		return tipoObjeto;
	}

	public void setTipoObjeto(String tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public String getNumeroPostes() {
		return numeroPostes;
	}

	public void setNumeroPostes(String numeroPostes) {
		this.numeroPostes = numeroPostes;
	}
}
