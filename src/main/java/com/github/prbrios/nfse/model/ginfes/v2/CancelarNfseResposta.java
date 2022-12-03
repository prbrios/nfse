package com.github.prbrios.nfse.model.ginfes.v2;

import com.github.prbrios.nfse.model.ginfes.v2.tipos.MensagemRetorno;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(reference = "http://www.ginfes.com.br/servico_cancelar_nfse_resposta")
@Root(name = "CancelarNfseResposta")
public class CancelarNfseResposta {

	@Attribute(name = "schemaLocation", required = false)
	private String schemaLocation;

	@Element(name = "Sucesso", required = false)
	private Boolean sucesso;

	@Element(name = "DataHora", required = false)
	private String dataHora;

	@Element(name = "MensagemRetorno", required = false)
	private MensagemRetorno mensagemRetorno;

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public Boolean getSucesso() {
		return sucesso;
	}

	public void setSucesso(Boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public MensagemRetorno getMensagemRetorno() {
		return mensagemRetorno;
	}

	public void setMensagemRetorno(MensagemRetorno mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}
}
