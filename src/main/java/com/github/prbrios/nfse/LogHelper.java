package com.github.prbrios.nfse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LogHelper {

    public static void salvarArquivo(final String conteudo, final String nomeCompletoDoArquivo) throws IOException {

        File file = new File(nomeCompletoDoArquivo);
        if (!file.exists())
            file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(conteudo.getBytes());
        fos.flush();
        fos.close();

    }

}
