package com.github.prbrios.nfse.model.ginfes.v3;

import com.github.prbrios.nfse.model.ginfes.v3.tipos.IdentificacaoPrestador;
import com.github.prbrios.nfse.model.signature.Signature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

@Namespace(reference = "http://www.ginfes.com.br/servico_consultar_lote_rps_envio_v03.xsd")
@Root(name = "ConsultarLoteRpsEnvio")
public class ConsultarLoteRpsEnvio {

	@Element(name = "Prestador")
	protected IdentificacaoPrestador prestador;

	@Element(name = "Protocolo")
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
