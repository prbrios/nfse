package com.github.prbrios.nfse.model.ginfes.v3;

import com.github.prbrios.nfse.model.ginfes.v3.tipos.IdentificacaoIntermediarioServico;
import com.github.prbrios.nfse.model.ginfes.v3.tipos.IdentificacaoPrestador;
import com.github.prbrios.nfse.model.ginfes.v3.tipos.IdentificacaoTomador;
import com.github.prbrios.nfse.model.signature.Signature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root
/*@NamespaceList({
	@Namespace(reference = "http://www.ginfes.com.br/tipos_v03.xsd"),
	@Namespace(reference = "http://www.ginfes.com.br/servico_consultar_nfse_envio_v03.xsd", prefix = "ns2"),
	@Namespace(reference = "http://www.w3.org/2000/09/xmldsig#", prefix = "ns3")
})*/
@Namespace(reference = "http://www.ginfes.com.br/servico_consultar_nfse_envio_v03.xsd", prefix = "ns2")
public class ConsultarNfseEnvio {

	@Element(name = "Prestador", required = false)
	@Namespace(reference = "http://www.ginfes.com.br/servico_consultar_nfse_envio_v03.xsd")
	protected IdentificacaoPrestador prestador;

	@Element(name = "NumeroNfse", required = false)
	@Namespace(reference = "http://www.ginfes.com.br/servico_consultar_nfse_envio_v03.xsd")
	protected String numeroNfse;

	@Element(name = "PeriodoEmissao", required = false)
	protected PeriodoEmissao periodoEmissao;

	@Element(name = "Tomador", required = false)
	protected IdentificacaoTomador tomador;

	@Element(name = "IntermediarioServico", required = false)
	protected IdentificacaoIntermediarioServico intermediarioServico;

	@Element(name = "Signature", required = false)
	protected Signature signature;

	public IdentificacaoPrestador getPrestador() {
		return prestador;
	}

	public void setPrestador(IdentificacaoPrestador prestador) {
		this.prestador = prestador;
	}

	public String getNumeroNfse() {
		return numeroNfse;
	}

	public void setNumeroNfse(String numeroNfse) {
		this.numeroNfse = numeroNfse;
	}

	public PeriodoEmissao getPeriodoEmissao() {
		return periodoEmissao;
	}

	public void setPeriodoEmissao(PeriodoEmissao periodoEmissao) {
		this.periodoEmissao = periodoEmissao;
	}

	public IdentificacaoTomador getTomador() {
		return tomador;
	}

	public void setTomador(IdentificacaoTomador tomador) {
		this.tomador = tomador;
	}

	public IdentificacaoIntermediarioServico getIntermediarioServico() {
		return intermediarioServico;
	}

	public void setIntermediarioServico(IdentificacaoIntermediarioServico intermediarioServico) {
		this.intermediarioServico = intermediarioServico;
	}

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}

	public class PeriodoEmissao {

		@Element(name = "DataInicial", required = false)
		protected String dataInicial;

		@Element(name = "DataFinal", required = false)
		protected String dataFinal;

		public String getDataInicial() {
			return dataInicial;
		}

		public void setDataInicial(String dataInicial) {
			this.dataInicial = dataInicial;
		}

		public String getDataFinal() {
			return dataFinal;
		}

		public void setDataFinal(String dataFinal) {
			this.dataFinal = dataFinal;
		}

	}
}
