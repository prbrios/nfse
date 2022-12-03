package com.github.prbrios.nfse.impressao;

public class InformacoesPrestador {
    protected String endereco;
    protected String numero;
    protected String complemento;
    protected String bairro;
    protected String cep;
    protected String codigoMunicipio;
    protected String uf;
    protected String razaoSocial;
    protected String telefone;
    protected String email;
    protected String nomeFantasia;

    public InformacoesPrestador(String endereco, String numero, String complemento, String bairro, String cep, String codigoMunicipio, String uf, String razaoSocial, String telefone, String email, String nomeFantasia) {
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.codigoMunicipio = codigoMunicipio;
        this.uf = uf;
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
        this.email = email;
        this.nomeFantasia = nomeFantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public String getUf() {
        return uf;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
