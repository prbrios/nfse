package com.github.prbrios.nfse.model.ginfes.v3;

import com.github.prbrios.nfse.model.ginfes.v3.tipos.CompNfse;
import com.github.prbrios.nfse.model.ginfes.v3.tipos.ListaMensagemRetorno;
import org.simpleframework.xml.*;

import java.util.ArrayList;
import java.util.List;

@Namespace(reference = "http://www.ginfes.com.br/servico_consultar_lote_rps_resposta_v03.xsd")
@Root(name = "ConsultarLoteRpsResposta")
public class ConsultarLoteRpsResposta {

	@Attribute(name = "schemaLocation")
    @Namespace(reference = "https://iss.fortaleza.ce.gov.br/grpfor/schema/V2/tipos_v02.xsd", prefix = "xsi")
    private String mSchemaLocation;

	@Element(name = "ListaNfse", required = false)
	protected ListaNfse listaNfse;

	@Element(name = "ListaMensagemRetorno", required = false)
	protected ListaMensagemRetorno listaMensagemRetorno;

	public ListaNfse getListaNfse() {
		return listaNfse;
	}

	public void setListaNfse(ListaNfse listaNfse) {
		this.listaNfse = listaNfse;
	}

	public ListaMensagemRetorno getListaMensagemRetorno() {
		return listaMensagemRetorno;
	}

	public void setListaMensagemRetorno(ListaMensagemRetorno listaMensagemRetorno) {
		this.listaMensagemRetorno = listaMensagemRetorno;
	}

	@Root(name = "ListaNfse")
	public static class ListaNfse {

		@ElementList(name = "CompNfse", required = false, inline = true)
		protected List<CompNfse> compNfse = new ArrayList<CompNfse>();

		public List<CompNfse> getCompNfse() {
			return compNfse;
		}

		public void setCompNfse(List<CompNfse> compNfse) {
			this.compNfse = compNfse;
		}
	}
}
