package com.github.prbrios.nfse.model.ginfes.v4;


import com.github.prbrios.nfse.model.ginfes.v4.tipos.ListaMensagemRetorno;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "EnviarLoteRpsResposta", strict = false)
public class EnviarLoteRpsResposta {

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
