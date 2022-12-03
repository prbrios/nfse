package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "ListaMensagemRetorno")
public class ListaMensagemRetorno {

	@ElementList(name = "MensagemRetorno", required = false, inline = true)
	protected List<MensagemRetorno> mensagemRetorno = new ArrayList<MensagemRetorno>();

	public List<MensagemRetorno> getMensagemRetorno() {
		return mensagemRetorno;
	}

	public void setMensagemRetorno(List<MensagemRetorno> mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}
}
