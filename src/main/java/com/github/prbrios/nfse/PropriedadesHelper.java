package com.github.prbrios.nfse;

import java.io.IOException;
import java.util.Properties;

public class PropriedadesHelper {

    private final Properties propriedades;

    public PropriedadesHelper(final String arquivo) {
        propriedades = new Properties();
        try {
            propriedades.load(getClass().getClassLoader().getResourceAsStream(arquivo));
        } catch (IOException ioex) { /**/ }
    }

    public String lerPropriedade(String nomeDaChave) {
        return propriedades.getProperty(nomeDaChave, "");
    }
}
