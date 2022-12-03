package com.github.prbrios.nfse.model.ginfes.v2.tipos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "MensagemRetorno")
public class MensagemRetorno {

	@Element(name = "Codigo", required = false)
	@Namespace(reference = "http://www.ginfes.com.br/tipos")
	private String codigo;

	@Element(name = "Mensagem", required = false)
	@Namespace(reference = "http://www.ginfes.com.br/tipos")
	private String mensagem;

	@Element(name = "Correcao", required = false)
	@Namespace(reference = "http://www.ginfes.com.br/tipos")
	private String correcao;

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
