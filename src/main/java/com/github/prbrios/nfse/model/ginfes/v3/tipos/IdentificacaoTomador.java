package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "IdentificacaoTomador")
public class IdentificacaoTomador {

	@Element(name = "CpfCnpj", required = false)
	protected CpfCnpj cpfCnpj;

	@Element(name = "InscricaoMunicipal", required = false)
	protected String inscricaoMunicipal;

	public CpfCnpj getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(CpfCnpj cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

}
