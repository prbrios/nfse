package com.github.prbrios.nfse.model.ginfes.v4.tipos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@JsonRootName("listarps")
@Root(name = "ListaRps")
public class ListaRps {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("rps")
    @ElementList(name = "Rps", required = false, inline = true)
    protected List<Rps> rps = new ArrayList<Rps>();

    public List<Rps> getRps() {
        return rps;
    }

    public void setRps(List<Rps> rps) {
        this.rps = rps;
    }

}
