package com.github.prbrios.nfse.model.ginfes.v4;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.prbrios.nfse.model.ginfes.v4.tipos.IdentificacaoPrestador;
import com.github.prbrios.nfse.model.signature.Signature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import java.io.StringWriter;

@Namespace(reference = "http://www.ginfes.com.br/servico_consultar_lote_rps_envio_v03.xsd")
@Root(name = "ConsultarLoteRpsEnvio", strict = false)
public class ConsultarLoteRpsEnvio {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("prestador")
	@Element(name = "Prestador")
	protected IdentificacaoPrestador prestador;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("protocolo")
	@Element(name = "Protocolo")
	protected String protocolo;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("signature")
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

    @Override
    public String toString() {
        try {

            StringWriter sw = new StringWriter();
            Persister persister = new Persister(new Format(0));
            persister.write(this, sw);

            return sw.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
