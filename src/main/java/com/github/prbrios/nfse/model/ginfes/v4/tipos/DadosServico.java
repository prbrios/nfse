package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@JsonRootName("dadosservico")
@Root(name = "DadosServico", strict = false)
public class DadosServico {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valores")
	@Element(name = "Valores", required = false)
	protected Valores valores;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("itemlistaservico")
	@Element(name = "ItemListaServico", required = false)
	protected String itemListaServico;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigocnae")
	@Element(name = "CodigoCnae", required = false)
	protected String codigoCnae;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigotributacaomunicipio")
	@Element(name = "CodigoTributacaoMunicipio", required = false)
	protected String codigoTributacaoMunicipio;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("discriminacao")
	@Element(name = "Discriminacao", required = false)
	protected String discriminacao;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigomunicipio")
	@Element(name = "CodigoMunicipio", required = false)
	protected String codigoMunicipio;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigonbs")
	@Element(name = "CodigoNbs", required = false)
	protected String codigoNbs;

	public Valores getValores() {
		return valores;
	}

	public void setValores(Valores valores) {
		this.valores = valores;
	}

	public String getItemListaServico() {
		return itemListaServico;
	}

	public void setItemListaServico(String itemListaServico) {
		this.itemListaServico = itemListaServico;
	}

	public String getCodigoCnae() {
		return codigoCnae;
	}

	public void setCodigoCnae(String codigoCnae) {
		this.codigoCnae = codigoCnae;
	}

	public String getCodigoTributacaoMunicipio() {
		return codigoTributacaoMunicipio;
	}

	public void setCodigoTributacaoMunicipio(String codigoTributacaoMunicipio) {
		this.codigoTributacaoMunicipio = codigoTributacaoMunicipio;
	}

	public String getDiscriminacao() {
		return discriminacao;
	}

	public void setDiscriminacao(String discriminacao) {
		this.discriminacao = discriminacao;
	}

	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getCodigoNbs() {
		return codigoNbs;
	}

	public void setCodigoNbs(String codigoNbs) {
		this.codigoNbs = codigoNbs;
	}
}
