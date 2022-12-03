package com.github.prbrios.nfse;

public enum Ambiente {

    PRODUCAO {
        @Override
        public String getUrl() {
            return "https://iss.fortaleza.ce.gov.br/grpfor-iss/ServiceGinfesImplService";
        }
    },

    HOMOLOGACAO {
        @Override
        public String getUrl() {
            return "http://isshomo.sefin.fortaleza.ce.gov.br/grpfor-iss/ServiceGinfesImplService";
        }
    };

    public abstract String getUrl();

}
