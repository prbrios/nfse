package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "IdentificacaoNfse", strict = false)
public class IdentificacaoNfse {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("numero")
	@Element(name = "Numero", required = false)
	private String numero;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("cnpj")
	@Element(name = "Cnpj", required = false)
	private String cnpj;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("inscricaomunicipal")
	@Element(name = "InscricaoMunicipal", required = false)
	private String inscricaoMunicipal;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigomunicipio")
	@Element(name = "CodigoMunicipio", required = false)
	private String codigoMunicipio;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}
}
