package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "MensagemRetorno", strict = false)
public class MensagemRetorno {

	@Element(name = "Codigo", required = false)
	protected String codigo;

	@Element(name = "Mensagem", required = false)
	protected String mensagem;

	@Element(name = "Correcao", required = false)
	protected String correcao;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCorrecao() {
		return correcao;
	}

	public void setCorrecao(String correcao) {
		this.correcao = correcao;
	}
}
