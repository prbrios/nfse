package com.github.prbrios.nfse.model.ginfes.v3;

import com.github.prbrios.nfse.model.ginfes.v3.tipos.CompNfse;
import com.github.prbrios.nfse.model.ginfes.v3.tipos.ListaMensagemRetorno;

import java.util.ArrayList;
import java.util.List;

public class ConsultarNfseResposta {

	protected ListaNfse listaNfse;
	protected ListaMensagemRetorno listaMensagemRetorno;

	public class ListaNfse {
		protected List<CompNfse> compNfse = new ArrayList<CompNfse>();
	}
}
