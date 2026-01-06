package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DadosEventos", strict = false)
public class DadosEventos {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("nomeevento")
	@Element(name = "NomeEvento", required = false)
		private String nomeEvento;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("datainicioevento")
	@Element(name = "DataInicioEvento", required = false)
		private String dataInicioEvento;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("datafimevento")
	@Element(name = "DataFimEvento", required = false)
		private String dataFimEvento;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("identificacaoevento")
	@Element(name = "IdentificacaoEvento", required = false)
		private String identificacaoEvento;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("endereco")
	@Element(name = "Endereco", required = false)
	private Endereco endereco;

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getDataInicioEvento() {
		return dataInicioEvento;
	}

	public void setDataInicioEvento(String dataInicioEvento) {
		this.dataInicioEvento = dataInicioEvento;
	}

	public String getDataFimEvento() {
		return dataFimEvento;
	}

	public void setDataFimEvento(String dataFimEvento) {
		this.dataFimEvento = dataFimEvento;
	}

	public String getIdentificacaoEvento() {
		return identificacaoEvento;
	}

	public void setIdentificacaoEvento(String identificacaoEvento) {
		this.identificacaoEvento = identificacaoEvento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
