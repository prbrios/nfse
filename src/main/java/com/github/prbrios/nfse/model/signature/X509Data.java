package com.github.prbrios.nfse.model.signature;

import org.simpleframework.xml.Element;

public class X509Data {

    @Element(name = "X509Certificate", required = false)
    private String x509certificate;

	public String getX509certificate() {
		return x509certificate;
	}

	public void setX509certificate(String x509certificate) {
		this.x509certificate = x509certificate;
	}

}
