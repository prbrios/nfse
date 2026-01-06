package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DadosExportacao", strict = false)
public class DadosExportacao {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("modoprestacao")
	@Element(name = "ModoPrestacao", required = false)
	protected String modoPrestacao;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("vinculoprestacao")
	@Element(name = "VinculoPrestacao", required = false)
	protected String vinculoPrestacao;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("tipomoeda")
	@Element(name = "TipoMoeda", required = false)
	protected String tipoMoeda;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("valorservicoexportacao")
	@Element(name = "ValorServicoExportacao", required = false)
	protected String valorServicoExportacao;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("mecanismocomexprestador")
	@Element(name = "MecanismoComexPrestador", required = false)
	protected String mecanismoComexPrestador;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("mecanismocomextomador")
	@Element(name = "MecanismoComexTomador", required = false)
	protected String mecanismoComexTomador;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("movimentacaotempbens")
	@Element(name = "MovimentacaoTempBens", required = false)
	protected String movimentacaoTempBens;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("numerodeclaracao")
	@Element(name = "NumeroDeclaracao", required = false)
	protected String numeroDeclaracao;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("numeroregistro")
	@Element(name = "NumeroRegistro", required = false)
	protected String numeroRegistro;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("mdic")
	@Element(name = "Mdic", required = false)
	protected String mdic;

	public String getModoPrestacao() {
		return modoPrestacao;
	}

	public void setModoPrestacao(String modoPrestacao) {
		this.modoPrestacao = modoPrestacao;
	}

	public String getVinculoPrestacao() {
		return vinculoPrestacao;
	}

	public void setVinculoPrestacao(String vinculoPrestacao) {
		this.vinculoPrestacao = vinculoPrestacao;
	}

	public String getTipoMoeda() {
		return tipoMoeda;
	}

	public void setTipoMoeda(String tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}

	public String getValorServicoExportacao() {
		return valorServicoExportacao;
	}

	public void setValorServicoExportacao(String valorServicoExportacao) {
		this.valorServicoExportacao = valorServicoExportacao;
	}

	public String getMecanismoComexPrestador() {
		return mecanismoComexPrestador;
	}

	public void setMecanismoComexPrestador(String mecanismoComexPrestador) {
		this.mecanismoComexPrestador = mecanismoComexPrestador;
	}

	public String getMecanismoComexTomador() {
		return mecanismoComexTomador;
	}

	public void setMecanismoComexTomador(String mecanismoComexTomador) {
		this.mecanismoComexTomador = mecanismoComexTomador;
	}

	public String getMovimentacaoTempBens() {
		return movimentacaoTempBens;
	}

	public void setMovimentacaoTempBens(String movimentacaoTempBens) {
		this.movimentacaoTempBens = movimentacaoTempBens;
	}

	public String getNumeroDeclaracao() {
		return numeroDeclaracao;
	}

	public void setNumeroDeclaracao(String numeroDeclaracao) {
		this.numeroDeclaracao = numeroDeclaracao;
	}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public String getMdic() {
		return mdic;
	}

	public void setMdic(String mdic) {
		this.mdic = mdic;
	}
}
