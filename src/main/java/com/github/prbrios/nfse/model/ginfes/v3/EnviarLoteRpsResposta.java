package com.github.prbrios.nfse.model.ginfes.v3;

import com.github.prbrios.nfse.model.ginfes.v3.tipos.ListaMensagemRetorno;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "EnviarLoteRpsResposta")
public class EnviarLoteRpsResposta {

	@Attribute(name = "schemaLocation")
    @Namespace(reference = "https://iss.fortaleza.ce.gov.br/grpfor/schema/V2/tipos_v02.xsd", prefix = "xsi")
    private String mSchemaLocation;

	@Element(name = "NumeroLote", required = false)
	protected String numeroLote;

	@Element(name = "DataRecebimento", required = false)
	protected String dataRecebimento;

	@Element(name = "Protocolo", required = false)
	protected String protocolo;

	@Element(name = "ListaMensagemRetorno", required = false)
	protected ListaMensagemRetorno listaMensagemRetorno;

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	public String getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(String dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public ListaMensagemRetorno getListaMensagemRetorno() {
		return listaMensagemRetorno;
	}

	public void setListaMensagemRetorno(ListaMensagemRetorno listaMensagemRetorno) {
		this.listaMensagemRetorno = listaMensagemRetorno;
	}

}
