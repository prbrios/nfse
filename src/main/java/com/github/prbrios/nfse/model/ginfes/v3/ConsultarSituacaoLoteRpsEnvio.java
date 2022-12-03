package com.github.prbrios.nfse.model.ginfes.v3;

import com.github.prbrios.nfse.model.ginfes.v3.tipos.IdentificacaoPrestador;
import com.github.prbrios.nfse.model.signature.Signature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "ConsultarSituacaoLoteRpsEnvio")
@Namespace(reference = "http://www.ginfes.com.br/servico_consultar_situacao_lote_rps_envio_v03.xsd")
public class ConsultarSituacaoLoteRpsEnvio {

	@Element(name = "Prestador", required = false)
	protected IdentificacaoPrestador prestador;

	@Element(name = "Protocolo", required = false)
	protected String protocolo;

	@Element(name = "Signature", required = false)
	protected Signature signature;

	public IdentificacaoPrestador getPrestador() {
		return prestador;
	}

	public void setPrestador(IdentificacaoPrestador prestador) {
		this.prestador = prestador;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}
}
