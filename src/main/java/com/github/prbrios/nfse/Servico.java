package com.github.prbrios.nfse;

import com.github.prbrios.nfse.ce.fortaleza.FortalezaCEService;
import com.github.prbrios.nfse.impressao.InformacoesPrestador;
import com.github.prbrios.nfse.impressao.Impressao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Servico<A, B, C, D, E, F> {
    static final Logger LOG = LoggerFactory.getLogger(Servico.class);

    B enviarLoteRps(A enviarLoteRpsEnvio) throws Exception;
    D consultarLoteRps(C consultarLoteRpsEnvio) throws Exception;
    F cancelarNfse(E cancelarNfseEnvio) throws Exception;
    Impressao impressao(String xml, String logomarca, boolean cancelada, InformacoesPrestador prestador) throws Exception;

}
