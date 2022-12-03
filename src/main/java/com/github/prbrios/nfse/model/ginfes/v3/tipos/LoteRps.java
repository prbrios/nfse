package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.*;

import java.util.ArrayList;
import java.util.List;

@Root(name = "LoteRps")
public class LoteRps {

	@Attribute(name = "Id", required = false)
	protected String id;

	@Element(name = "NumeroLote", required = false)
	@Namespace(reference = "http://www.ginfes.com.br/tipos_v03.xsd")
	protected String numeroLote;

	@Element(name = "Cnpj", required = false)
	@Namespace(reference = "http://www.ginfes.com.br/tipos_v03.xsd")
	protected String cnpj;

	@Element(name = "InscricaoMunicipal", required = false)
	@Namespace(reference = "http://www.ginfes.com.br/tipos_v03.xsd")
	protected String inscricaoMunicipal;

	@Element(name = "QuantidadeRps", required = false)
	@Namespace(reference = "http://www.ginfes.com.br/tipos_v03.xsd")
	protected String quantidadeRps;

	@Element(name = "ListaRps", required = false)
	protected ListaRps listaRps;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getQuantidadeRps() {
		return quantidadeRps;
	}

	public void setQuantidadeRps(String quantidadeRps) {
		this.quantidadeRps = quantidadeRps;
	}

	public ListaRps getListaRps() {
		return listaRps;
	}

	public void setListaRps(ListaRps listaRps) {
		this.listaRps = listaRps;
	}

}
