package com.github.prbrios.nfse.model.ginfes.v3;

import com.github.prbrios.nfse.model.ginfes.v3.tipos.LoteRps;
import com.github.prbrios.nfse.model.signature.Signature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;

@Root(name = "EnviarLoteRpsEnvio")
@Namespace(reference = "http://www.ginfes.com.br/servico_enviar_lote_rps_envio_v03.xsd")
public class EnviarLoteRpsEnvio {
    private static final Logger LOG = LoggerFactory.getLogger(EnviarLoteRpsEnvio.class);

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
