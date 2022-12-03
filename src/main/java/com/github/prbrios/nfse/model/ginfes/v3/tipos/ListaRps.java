package com.github.prbrios.nfse.model.ginfes.v3.tipos;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "ListaRps")
@Namespace(reference = "http://www.ginfes.com.br/tipos_v03.xsd")
public class ListaRps {

    @ElementList(name = "Rps", required = false, inline = true)
    protected List<Rps> rps = new ArrayList<Rps>();

    public List<Rps> getRps() {
        return rps;
    }

    public void setRps(List<Rps> rps) {
        this.rps = rps;
    }

}
