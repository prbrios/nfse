package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DadosIbsCbs", strict = false)
public class DadosIbsCbs {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigoindicadorfinalidadenfse")
	@Element(name = "CodigoIndicadorFinalidadeNFSe", required = false)
	protected String codigoIndicadorFinalidadeNFSe;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigoindicadoroperacaousoconsumopessoal")
	@Element(name = "CodigoIndicadorOperacaoUsoConsumoPessoal", required = false)
	protected String codigoIndicadorOperacaoUsoConsumoPessoal;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("codigoindicadoroperacao")
	@Element(name = "CodigoIndicadorOperacao", required = false)
	protected String codigoIndicadorOperacao;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("tipoop")
	@Element(name = "TipoOp", required = false)
	protected String tipoOp;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("gruponfsereferenciada")
	@Element(name = "GrupoNFSeReferenciada", required = false)
	protected GrupoNFSeReferenciada grupoNFSeReferenciada;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("tipoentegovernamental")
	@Element(name = "TipoEnteGovernamental", required = false)
	protected String tipoEnteGovernamental;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("inddest")
	@Element(name = "IndDest", required = false)
	protected String indDest;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("destinatario")
	@Element(name = "Destinatario", required = false)
	protected Destinatario destinatario;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("imovel")
	@Element(name = "Imovel", required = false)
	protected Imovel imovel;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valores")
	@Element(name = "Valores", required = false)
	protected ValoresIbsCbs valores;

	public String getCodigoIndicadorFinalidadeNFSe() {
		return codigoIndicadorFinalidadeNFSe;
	}

	public void setCodigoIndicadorFinalidadeNFSe(String codigoIndicadorFinalidadeNFSe) {
		this.codigoIndicadorFinalidadeNFSe = codigoIndicadorFinalidadeNFSe;
	}

	public String getCodigoIndicadorOperacaoUsoConsumoPessoal() {
		return codigoIndicadorOperacaoUsoConsumoPessoal;
	}

	public void setCodigoIndicadorOperacaoUsoConsumoPessoal(String codigoIndicadorOperacaoUsoConsumoPessoal) {
		this.codigoIndicadorOperacaoUsoConsumoPessoal = codigoIndicadorOperacaoUsoConsumoPessoal;
	}

	public String getCodigoIndicadorOperacao() {
		return codigoIndicadorOperacao;
	}

	public void setCodigoIndicadorOperacao(String codigoIndicadorOperacao) {
		this.codigoIndicadorOperacao = codigoIndicadorOperacao;
	}

	public String getTipoOp() {
		return tipoOp;
	}

	public void setTipoOp(String tipoOp) {
		this.tipoOp = tipoOp;
	}

	public GrupoNFSeReferenciada getGrupoNFSeReferenciada() {
		return grupoNFSeReferenciada;
	}

	public void setGrupoNFSeReferenciada(GrupoNFSeReferenciada grupoNFSeReferenciada) {
		this.grupoNFSeReferenciada = grupoNFSeReferenciada;
	}

	public String getTipoEnteGovernamental() {
		return tipoEnteGovernamental;
	}

	public void setTipoEnteGovernamental(String tipoEnteGovernamental) {
		this.tipoEnteGovernamental = tipoEnteGovernamental;
	}

	public String getIndDest() {
		return indDest;
	}

	public void setIndDest(String indDest) {
		this.indDest = indDest;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public ValoresIbsCbs getValores() {
		return valores;
	}

	public void setValores(ValoresIbsCbs valores) {
		this.valores = valores;
	}
}
