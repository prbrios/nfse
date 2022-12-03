package com.github.prbrios.nfse.model.signature;

import org.simpleframework.xml.Attribute;

public class Transform {

    @Attribute(name = "Algorithm", required = false)
    private String algorithm;

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

}
