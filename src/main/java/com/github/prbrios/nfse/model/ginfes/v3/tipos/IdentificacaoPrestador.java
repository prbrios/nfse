package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "IdentificacaoPrestador")
public class IdentificacaoPrestador {

	@Element(name = "Cnpj", required = false)
	@Namespace(reference = "http://www.ginfes.com.br/tipos_v03.xsd")
	protected String cnpj;

	@Element(name = "InscricaoMunicipal", required = false)
	@Namespace(reference = "http://www.ginfes.com.br/tipos_v03.xsd")
	protected String inscricaoMunicipal;

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

}
