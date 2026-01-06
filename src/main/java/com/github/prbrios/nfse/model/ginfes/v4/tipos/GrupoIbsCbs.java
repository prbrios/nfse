package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "GrupoIbsCbs", strict = false)
public class GrupoIbsCbs {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("cst")
	@Element(name = "CST", required = false)
		private String CST;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigoclasstrib")
	@Element(name = "CodigoClassTrib", required = false)
		private String codigoClassTrib;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigocreditopresumido")
	@Element(name = "CodigoCreditoPresumido", required = false)
		private String codigoCreditoPresumido;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("grupoinfotributacaoregular")
	@Element(name = "GrupoInfoTributacaoRegular", required = false)
	private GrupoInfoTributacaoRegular grupoInfoTributacaoRegular;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("grupodiferimento")
	@Element(name = "GrupoDiferimento", required = false)
	private GrupoDiferimento grupoDiferimento;

	public String getCST() {
		return CST;
	}

	public void setCST(String CST) {
		this.CST = CST;
	}

	public String getCodigoClassTrib() {
		return codigoClassTrib;
	}

	public void setCodigoClassTrib(String codigoClassTrib) {
		this.codigoClassTrib = codigoClassTrib;
	}

	public String getCodigoCreditoPresumido() {
		return codigoCreditoPresumido;
	}

	public void setCodigoCreditoPresumido(String codigoCreditoPresumido) {
		this.codigoCreditoPresumido = codigoCreditoPresumido;
	}

	public GrupoInfoTributacaoRegular getGrupoInfoTributacaoRegular() {
		return grupoInfoTributacaoRegular;
	}

	public void setGrupoInfoTributacaoRegular(GrupoInfoTributacaoRegular grupoInfoTributacaoRegular) {
		this.grupoInfoTributacaoRegular = grupoInfoTributacaoRegular;
	}

	public GrupoDiferimento getGrupoDiferimento() {
		return grupoDiferimento;
	}

	public void setGrupoDiferimento(GrupoDiferimento grupoDiferimento) {
		this.grupoDiferimento = grupoDiferimento;
	}
}
