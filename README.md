# NFS-e
## Padrão GINFES
### Envio do Lote RPS
```java
import com.github.prbrios.nfse.model.ginfes.v3.EnviarLoteRpsEnvio;
import com.github.prbrios.nfse.model.ginfes.v3.EnviarLoteRpsResposta;
import com.github.prbrios.nfse.Configuracao;
import com.github.prbrios.nfse.Ambiente;
import com.github.prbrios.nfse.TipoCertificado;
import com.github.prbrios.nfse.ce.fortaleza.FortalezaCEService;
import com.github.prbrios.nfse.model.ginfes.v3.tipos.*;

import java.util.ArrayList;
import java.util.List;

public class TesteEnvioLoteRps {

  public static void main(String[] args) throws Exception {

    Configuracao configuracao = new Configuracao(Ambiente.HOMOLOGACAO, TipoCertificado.A1, "D:\\certificado.pfx", "senha-certificado", "D:\\LogXML");
    FortalezaCEService service = new FortalezaCEService(configuracao);
    EnviarLoteRpsResposta resposta = service.enviarLoteRps(getEnviarLoteRpsEnvioObject());

  }

  private static EnviarLoteRpsEnvio getEnviarLoteRpsEnvioObject() {

    IdentificacaoRps identificacaoRps = new IdentificacaoRps();
    identificacaoRps.setSerie("1");
    identificacaoRps.setNumero("1");
    identificacaoRps.setTipo("1");

    IdentificacaoPrestador prestador = new IdentificacaoPrestador();
    prestador.setCnpj("**************");
    prestador.setInscricaoMunicipal("******");

    Valores valores = new Valores();
    valores.setValorServicos("1.00");
    valores.setValorDeducoes("0.00");
    valores.setValorPis("0.00");
    valores.setValorCofins("0.00");
    valores.setValorInss("0.00");
    valores.setValorIr("0.00");
    valores.setValorCsll("0.00");
    valores.setIssRetido("2");
    valores.setValorIss("0.05");
    valores.setValorIssRetido("0.00");
    valores.setOutrasRetencoes("0.00");
    valores.setBaseCalculo("0.00");
    valores.setAliquota("0.05");
    valores.setValorLiquidoNfse("1.00");
    valores.setDescontoIncondicionado("0.00");
    valores.setDescontoCondicionado("0.00");

    DadosServico servico = new DadosServico();
    servico.setCodigoCnae(null);
    servico.setCodigoMunicipio("2304400");
    servico.setDiscriminacao("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book");
    servico.setItemListaServico("1401");
    servico.setCodigoTributacaoMunicipio("951180001");
    servico.setValores(valores);

    Contato contatoTomador = new Contato();
    contatoTomador.setEmail("iuj87ll3w@gmail.com");
    contatoTomador.setTelefone("85999999999");

    CpfCnpj cpfTomador = new CpfCnpj();
    cpfTomador.setCpf("02212575009");

    IdentificacaoTomador identificacaoTomador = new IdentificacaoTomador();
    identificacaoTomador.setInscricaoMunicipal(null);
    identificacaoTomador.setCpfCnpj(cpfTomador);

    Endereco enderecoTomador = new Endereco();
    enderecoTomador.setBairro("CENTRO");
    enderecoTomador.setEndereco("RUA QUINZE");
    enderecoTomador.setNumero("16");
    enderecoTomador.setCodigoMunicipio("2304400");
    enderecoTomador.setComplemento("AP 102");
    enderecoTomador.setUf("CE");
    enderecoTomador.setCep("60345090");

    DadosTomador tomador = new DadosTomador();
    tomador.setContato(contatoTomador);
    tomador.setIdentificacaoTomador(identificacaoTomador);
    tomador.setEndereco(enderecoTomador);
    tomador.setRazaoSocial("PEDRO A CABRAL");

    InfRps infRps = new InfRps();
    infRps.setId("Id-1juh5-oi8u");
    infRps.setIdentificacaoRps(identificacaoRps);
    infRps.setPrestador(prestador);
    infRps.setDataEmissao("2022-11-24T14:00:00");
    infRps.setIncentivadorCultural("2");
    infRps.setNaturezaOperacao("1");
    infRps.setOptanteSimplesNacional("2");
    infRps.setRegimeEspecialTributacao(null);
    infRps.setStatus("1");
    infRps.setServico(servico);
    infRps.setTomador(tomador);

    Rps rps = new Rps();
    rps.setInfRps(infRps);

    List<Rps> rpsArr = new ArrayList<>();
    rpsArr.add(rps);

    ListaRps listaRps = new ListaRps();
    listaRps.setRps(rpsArr);

    LoteRps loteRps = new LoteRps();
    loteRps.setCnpj("**************");
    loteRps.setListaRps(listaRps);
    loteRps.setNumeroLote("1");
    loteRps.setQuantidadeRps("1");
    loteRps.setId("Id1");
    loteRps.setInscricaoMunicipal("******");

    EnviarLoteRpsEnvio enviarLoteRpsEnvio = new EnviarLoteRpsEnvio();
    enviarLoteRpsEnvio.setLoteRps(loteRps);

    return enviarLoteRpsEnvio;
  }
}
```

### Consulta do Lote RPS

```java
import com.github.prbrios.nfse.model.ginfes.v3.ConsultarLoteRpsEnvio;
import com.github.prbrios.nfse.model.ginfes.v3.ConsultarLoteRpsResposta;
import com.github.prbrios.nfse.Configuracao;
import com.github.prbrios.nfse.Ambiente;
import com.github.prbrios.nfse.TipoCertificado;
import com.github.prbrios.nfse.ce.fortaleza.FortalezaCEService;
import com.github.prbrios.nfse.model.ginfes.v3.tipos.*;

public class TesteConsultaLoteRps {

  public static void main(String[] args) throws Exception {

    Configuracao configuracao = new Configuracao(Ambiente.HOMOLOGACAO, TipoCertificado.A1, "D:\\certificado.pfx", "senha-certificado", "D:\\LogXML");
    FortalezaCEService service = new FortalezaCEService(configuracao);
    ConsultarLoteRpsResposta resposta = service.consultarLoteRps(getConsultarLoteRpsEnvioObject());

  }

  private static ConsultarLoteRpsEnvio getConsultarLoteRpsEnvioObject() {

    IdentificacaoPrestador prestador = new IdentificacaoPrestador();
    prestador.setCnpj("**************");
    prestador.setInscricaoMunicipal("******");

    ConsultarLoteRpsEnvio consultarLoteRpsEnvio = new ConsultarLoteRpsEnvio();
    consultarLoteRpsEnvio.setPrestador(prestador);
    consultarLoteRpsEnvio.setProtocolo("********");

    return consultarLoteRpsEnvio;
  }
}
```

### Cancelamento NFS-e

```java
import com.github.prbrios.nfse.model.ginfes.v2.CancelarNfseEnvio;
import com.github.prbrios.nfse.model.ginfes.v2.CancelarNfseResposta;
import com.github.prbrios.nfse.Configuracao;
import com.github.prbrios.nfse.Ambiente;
import com.github.prbrios.nfse.TipoCertificado;
import com.github.prbrios.nfse.ce.fortaleza.FortalezaCEService;
import com.github.prbrios.nfse.model.ginfes.v2.tipos.*;

public class TesteCancelamentoNfse {

  public static void main(String[] args) throws Exception {

    Configuracao configuracao = new Configuracao(Ambiente.HOMOLOGACAO, TipoCertificado.A1, "D:\\certificado.pfx", "senha-certificado", "D:\\LogXML");
    FortalezaCEService service = new FortalezaCEService(configuracao);
    CancelarNfseResposta resposta = service.cancelarNfse(getCancelarNfseEnvioObject());

  }

  private static CancelarNfseEnvio getCancelarNfseEnvioObject() {

    IdentificacaoPrestador prestador = new IdentificacaoPrestador();
    prestador.setCnpj("**************");
    prestador.setInscricaoMunicipal("******");

    CancelarNfseEnvio cancelarNfseEnvio = new CancelarNfseEnvio();
    cancelarNfseEnvio.setNumeroNfse("******");
    cancelarNfseEnvio.setPrestador(prestador);

    return cancelarNfseEnvio;

  }
}
```

### Impressão RPS

```java
import com.github.prbrios.nfse.Ambiente;
import com.github.prbrios.nfse.Configuracao;
import com.github.prbrios.nfse.TipoCertificado;
import com.github.prbrios.nfse.ce.fortaleza.FortalezaCEService;
import com.github.prbrios.nfse.impressao.InformacoesPrestador;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public class Impressao {

  public static void main(String[] args) throws Exception {

    InformacoesPrestador prestador = new InformacoesPrestador("RUA 10", "10001",
      "AP 102", "NUVENS", "66666666",
      "2304400", "CE", "RAZAO SOCIAL",
      "(85)99999-9999", "email@email.com", "NOME FANTASIA");

    Configuracao configuracao = new Configuracao(Ambiente.HOMOLOGACAO, TipoCertificado.A1, "D:\\certificado.pfx", "senha-certificado", "D:\\LogXML");
    String arquivo = String.format("%s.pdf", UUID.randomUUID().toString());
    byte[] bytesPdf = new FortalezaCEService(configuracao).impressao(xmlRps(), null, false, prestador).bytesPdf();

    // gera o arquivo
    FileOutputStream fos = new FileOutputStream(new File(arquivo));
    fos.write(bytesPdf);
    fos.flush();
    fos.close();

    // abre o arquivo
    Runtime.getRuntime().exec("cmd /C " + arquivo);

  }

  private static String xmlRps() {
    StringBuilder sb = new StringBuilder();
    sb.append("<Rps><InfRps Id=\"51358116-1d3d-4b90-a59c-622d04545008\"><IdentificacaoRps>");
    sb.append("<Numero>14</Numero><Serie>F01</Serie><Tipo>1</Tipo></IdentificacaoRps><Data");
    sb.append("Emissao>2022-11-24T14:00:00</DataEmissao><NaturezaOperacao>1</NaturezaOpera");
    sb.append("cao><OptanteSimplesNacional>2</OptanteSimplesNacional><IncentivadorCultural");
    sb.append(">2</IncentivadorCultural><Status>1</Status><Servico><Valores><ValorServicos");
    sb.append(">100.00</ValorServicos><ValorDeducoes>0.00</ValorDeducoes><ValorPis>0.00</V");
    sb.append("alorPis><ValorCofins>0.00</ValorCofins><ValorInss>0.00</ValorInss><ValorIr>");
    sb.append("0.00</ValorIr><ValorCsll>0.00</ValorCsll><IssRetido>2</IssRetido><ValorIss>");
    sb.append("5.00</ValorIss><ValorIssRetido>0.00</ValorIssRetido><OutrasRetencoes>0.00</");
    sb.append("OutrasRetencoes><BaseCalculo>100.00</BaseCalculo><Aliquota>0.05</Aliquota><");
    sb.append("ValorLiquidoNfse>100.00</ValorLiquidoNfse><DescontoCondicionado>0.00</Desco");
    sb.append("ntoCondicionado></Valores><ItemListaServico>1401</ItemListaServico><CodigoT");
    sb.append("ributacaoMunicipio>951180001</CodigoTributacaoMunicipio><Discriminacao>Lore");
    sb.append("m Ipsum is simply dummy text of the printing and typesetting industry. Lore");
    sb.append("m Ipsum has been the industry&apos;s standard dummy text ever since the 150");
    sb.append("0s, when an unknown printer took a galley of type and scrambled it to make ");
    sb.append("a type specimen book. It has survived not only five centuries, but also the");
    sb.append(" leap into electronic typesetting, remaining essentially unchanged. It was ");
    sb.append("popularised in the 1960s with the release of Letraset sheets containing Lor");
    sb.append("em Ipsum passages, and more recently with desktop publishing software like ");
    sb.append("Aldus PageMaker including versions of Lorem Ipsum. Lorem Ipsum is simply du");
    sb.append("mmy text of the printing and typesetting industry.</Discriminacao><CodigoMu");
    sb.append("nicipio>2304400</CodigoMunicipio></Servico><Prestador><Cnpj xmlns=\"http://");
    sb.append("www.ginfes.com.br/tipos_v03.xsd\">11222333444455</Cnpj><InscricaoMunicipal ");
    sb.append("xmlns=\"http://www.ginfes.com.br/tipos_v03.xsd\">112233</InscricaoMunicipal");
    sb.append("></Prestador><Tomador><IdentificacaoTomador><CpfCnpj><Cpf>26754064064</Cpf>");
    sb.append("</CpfCnpj></IdentificacaoTomador><RazaoSocial>PEDRO A CABRAL</RazaoSocial><");
    sb.append("Endereco><Endereco>RUA 10</Endereco><Numero>10001</Numero><Bairro>NUVENS</B");
    sb.append("airro><CodigoMunicipio>2303709</CodigoMunicipio><Uf>CE</Uf><Cep>61603100</C");
    sb.append("ep></Endereco><Contato><Telefone>85991324004</Telefone><Email>email@email.c");
    sb.append("om</Email></Contato></Tomador></InfRps></Rps>");
    return sb.toString();
  }

}
```

### Impressão NFS-e

```java
import com.github.prbrios.nfse.Ambiente;
import com.github.prbrios.nfse.Configuracao;
import com.github.prbrios.nfse.TipoCertificado;
import com.github.prbrios.nfse.ce.fortaleza.FortalezaCEService;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public class Impressao {

    public static void main(String[] args) throws Exception {

        Configuracao configuracao = new Configuracao(Ambiente.HOMOLOGACAO, TipoCertificado.A1, "D:\\certificado.pfx", "senha-certificado", "D:\\LogXML");
        String arquivo = String.format("%s.pdf", UUID.randomUUID().toString());
        byte[] bytesPdf = new FortalezaCEService(configuracao).impressao(xmlNfse(), null, false, null).bytesPdf();

        // gera o arquivo
        FileOutputStream fos = new FileOutputStream(new File(arquivo));
        fos.write(bytesPdf);
        fos.flush();
        fos.close();

        // abre o arquivo
        Runtime.getRuntime().exec("cmd /C " + arquivo);

    }

    private static String xmlNfse(){
        StringBuilder sb = new StringBuilder();
        sb.append("<Nfse><InfNfse><Numero>8565</Numero><CodigoVerificacao>425422431</CodigoVer");
        sb.append("ificacao><DataEmissao>2022-11-30T22:41:09.185-03:00</DataEmissao><Identific");
        sb.append("acaoRps><Numero>14</Numero><Serie>F01</Serie><Tipo>1</Tipo></IdentificacaoR");
        sb.append("ps><DataEmissaoRps>2022-11-24-03:00</DataEmissaoRps><NaturezaOperacao>1</Na");
        sb.append("turezaOperacao><OptanteSimplesNacional>2</OptanteSimplesNacional><Incentiva");
        sb.append("dorCultural>2</IncentivadorCultural><Competencia>2022-11-24-03:00</Competen");
        sb.append("cia><Servico><Valores><ValorServicos>100</ValorServicos><ValorDeducoes>0</V");
        sb.append("alorDeducoes><ValorPis>0</ValorPis><ValorCofins>0</ValorCofins><ValorInss>0");
        sb.append("</ValorInss><ValorIr>0</ValorIr><ValorCsll>0</ValorCsll><IssRetido>2</IssRe");
        sb.append("tido><ValorIss>5</ValorIss><ValorIssRetido>0</ValorIssRetido><OutrasRetenco");
        sb.append("es>0</OutrasRetencoes><BaseCalculo>100</BaseCalculo><Aliquota>5</Aliquota><");
        sb.append("ValorLiquidoNfse>100</ValorLiquidoNfse><DescontoCondicionado>0</DescontoCon");
        sb.append("dicionado></Valores><ItemListaServico>1401</ItemListaServico><CodigoCnae>95");
        sb.append("1180001</CodigoCnae><CodigoTributacaoMunicipio>951180001</CodigoTributacaoM");
        sb.append("unicipio><Discriminacao>Lorem Ipsum is simply dummy text of the printing an");
        sb.append("d typesetting industry. Lorem Ipsum has been the industry&apos;s standard d");
        sb.append("ummy text ever since the 1500s, when an unknown printer took a galley of ty");
        sb.append("pe and scrambled it to make a type specimen book. It has survived not only ");
        sb.append("five centuries, but also the leap into electronic typesetting, remaining es");
        sb.append("sentially unchanged. It was popularised in the 1960s with the release of Le");
        sb.append("traset sheets containing Lorem Ipsum passages, and more recently with deskt");
        sb.append("op publishing software like Aldus PageMaker including versions of Lorem Ips");
        sb.append("um. Lorem Ipsum is simply dummy text of the printing and typesetting indust");
        sb.append("ry.</Discriminacao><CodigoMunicipio>2304400</CodigoMunicipio></Servico><Val");
        sb.append("orCredito>0</ValorCredito><PrestadorServico><IdentificacaoPrestador><Cnpj x");
        sb.append("mlns=\"http://www.ginfes.com.br/tipos_v03.xsd\">11222333444455</Cnpj><Inscr");
        sb.append("icaoMunicipal xmlns=\"http://www.ginfes.com.br/tipos_v03.xsd\">112233</Insc");
        sb.append("ricaoMunicipal></IdentificacaoPrestador><RazaoSocial>RAZAO SOCIAL</RazaoSoc");
        sb.append("ial><NomeFantasia>NOME FANTASIA</NomeFantasia><Endereco><Endereco>AVENIDA F");
        sb.append("ELIZ</Endereco><Numero>963</Numero><Bairro>ALTO DA MONTANHA</Bairro><Codigo");
        sb.append("Municipio>2304400</CodigoMunicipio><Uf>CE</Uf><Cep>99666333</Cep></Endereco");
        sb.append("><Contato><Telefone>(85)9999-9999</Telefone><Email>teste.app@sefin.fortalez");
        sb.append("a.ce.gov.br</Email></Contato></PrestadorServico><TomadorServico><Identifica");
        sb.append("caoTomador><CpfCnpj><Cpf>26754064064</Cpf></CpfCnpj></IdentificacaoTomador>");
        sb.append("<RazaoSocial>PEDRO A CABRAL</RazaoSocial><Endereco><Endereco>RUA 10</Endere");
        sb.append("co><Numero>10001</Numero><Bairro>NUVENS</Bairro><CodigoMunicipio>2303709</C");
        sb.append("odigoMunicipio><Uf>CE</Uf><Cep>66666666</Cep></Endereco><Contato><Telefone>");
        sb.append("85991324004</Telefone><Email>email@email.com.br</Email></Contato></TomadorS");
        sb.append("ervico><OrgaoGerador><CodigoMunicipio>2304400</CodigoMunicipio><Uf>CE</Uf><");
        sb.append("/OrgaoGerador></InfNfse></Nfse>");
        return sb.toString();
    }

}
```
