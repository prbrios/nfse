package com.github.prbrios.nfse.model.ginfes.v4;

import com.github.prbrios.nfse.model.ginfes.v4.tipos.CompNfse;
import com.github.prbrios.nfse.model.ginfes.v4.tipos.ListaMensagemRetorno;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "consultarNfseRpsResposta", strict = false)
public class ConsultarNfseRpsResposta {

	@Attribute(name = "schemaLocation")
    @Namespace(reference = "https://iss.fortaleza.ce.gov.br/grpfor/schema/V2/tipos_v02.xsd", prefix = "xsi")
    private String mSchemaLocation;

	@Element(name = "CompNfse", required = false)
	private CompNfse compNfse;

	@Element(name = "ListaMensagemRetorno", required = false)
	private ListaMensagemRetorno listaMensagemRetorno;

	public CompNfse getCompNfse() {
		return compNfse;
	}

	public void setCompNfse(CompNfse compNfse) {
		this.compNfse = compNfse;
	}

	public ListaMensagemRetorno getListaMensagemRetorno() {
		return listaMensagemRetorno;
	}

	public void setListaMensagemRetorno(ListaMensagemRetorno listaMensagemRetorno) {
		this.listaMensagemRetorno = listaMensagemRetorno;
	}
}
