package com.github.prbrios.nfse.model.ginfes.v3;

import com.github.prbrios.nfse.model.ginfes.v3.tipos.ListaMensagemRetorno;
import org.simpleframework.xml.Root;

@Root(name = "ConsultarSituacaoLoteRpsResposta")
public class ConsultarSituacaoLoteRpsResposta {
	protected String numeroLote;
	protected String situacao;
	protected ListaMensagemRetorno listaMensagemRetorno;
}
