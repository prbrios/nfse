package com.github.prbrios.nfse.model.ginfes.v4;

import com.github.prbrios.nfse.model.ginfes.v4.tipos.ListaMensagemRetorno;
import org.simpleframework.xml.Root;

@Root(name = "ConsultarSituacaoLoteRpsResposta", strict = false)
public class ConsultarSituacaoLoteRpsResposta {
	protected String numeroLote;
	protected String situacao;
	protected ListaMensagemRetorno listaMensagemRetorno;
}
