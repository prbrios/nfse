package com.github.prbrios.nfse.model.ginfes.v4;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.github.prbrios.nfse.model.signature.Signature;
import com.github.prbrios.nfse.model.ginfes.v4.tipos.LoteRps;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import java.io.StringWriter;

@JsonRootName("enviarloterpsenvio")
@Root(name = "EnviarLoteRpsEnvio", strict = false)
@NamespaceList({
	@Namespace(reference = "http://www.ginfes.com.br/servico_enviar_lote_rps_envio_v03.xsd")
})
public class EnviarLoteRpsEnvio {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("loterps")
	@Element(name = "LoteRps", required = false)
	protected LoteRps loteRps;

	@Element(name = "Signature", required = false)
	protected Signature signature;

	public LoteRps getLoteRps() {
		return loteRps;
	}

	public void setLoteRps(LoteRps loteRps) {
		this.loteRps = loteRps;
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
