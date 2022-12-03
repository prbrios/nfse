package com.github.prbrios.nfse;

import com.github.prbrios.nfse.Ambiente;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Configuracao {

    private Ambiente ambiente;
    private TipoCertificado tipoCertificado;
    private String certificado;
    private String senhaCertificado;
    private String diretorioLog;

    public Configuracao(Ambiente ambiente, TipoCertificado tipoCertificado, String certificado, String senhaCertificado, String diretorioLog) throws Exception {

        if (ambiente == null)
            throw new Exception("Ambiente nao informado");

        if (tipoCertificado == null)
            throw new Exception("TipoCertificado nao informado");

        if (certificado == null)
            throw new Exception("Certificado nao informado");

        if (tipoCertificado.equals(TipoCertificado.A1) && !new File(certificado).exists())
            throw new Exception("Arquivo certificado invalido");

        if (senhaCertificado == null)
            throw new Exception("Senha do Certificado nao informada");

        if (diretorioLog == null)
           diretorioLog = System.getProperty("user.dir");

        if (diretorioLog != null && !new File(diretorioLog).isDirectory())
            throw new Exception("Diretorio de log invalido");

        this.ambiente = ambiente;
        this.tipoCertificado = tipoCertificado;
        this.certificado = certificado;
        this.senhaCertificado = senhaCertificado;
        this.diretorioLog = diretorioLog;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public TipoCertificado getTipoCertificado() {
        return tipoCertificado;
    }

    public String getCertificado() {
        return certificado;
    }

    public String getSenhaCertificado() {
        return senhaCertificado;
    }

    public String getDiretorioLog() {
        return diretorioLog;
    }
}
