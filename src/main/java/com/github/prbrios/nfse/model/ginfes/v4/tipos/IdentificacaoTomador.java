package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@JsonRootName("identificacaotomador")
@Root(name = "IdentificacaoTomador", strict = false)
public class IdentificacaoTomador {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("cpfcnpj")
	@Element(name = "CpfCnpj", required = false)
	protected CpfCnpj cpfCnpj;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("inscricaomunicipal")
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
