package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@JsonRootName("cpfcnpj")
@Root(name = "CpfCnpj", strict = false)
public class CpfCnpj {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("cnpj")
	@Element(name = "Cnpj", required = false)
	protected String cnpj;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("cpf")
	@Element(name = "Cpf", required = false)
	protected String cpf;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
