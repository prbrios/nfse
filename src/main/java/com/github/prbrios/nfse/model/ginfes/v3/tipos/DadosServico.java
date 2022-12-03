package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DadosServico")
public class DadosServico {

	@Element(name = "Valores", required = false)
	protected Valores valores;

	@Element(name = "ItemListaServico", required = false)
	protected String itemListaServico;

	@Element(name = "CodigoCnae", required = false)
	protected String codigoCnae;

	@Element(name = "CodigoTributacaoMunicipio", required = false)
	protected String codigoTributacaoMunicipio;

	@Element(name = "Discriminacao", required = false)
	protected String discriminacao;

	@Element(name = "CodigoMunicipio", required = false)
	protected String codigoMunicipio;

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
}
