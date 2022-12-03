package com.github.prbrios.nfse.model.signature;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;

import java.util.List;

public class Reference {

    @Attribute(name = "URI", required = false)
    private String uri;

    @Path("Transforms")
    @ElementList(entry = "Transform", inline = true, required = false)
    private List<Transform> transform;

    @Element(name = "DigestMethod", required = false)
    private DigestMethod digestMethod;

    @Element(name = "DigestValue", required = false)
    private String digestValue;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<Transform> getTransform() {
		return transform;
	}

	public void setTransform(List<Transform> transform) {
		this.transform = transform;
	}

	public DigestMethod getDigestMethod() {
		return digestMethod;
	}

	public void setDigestMethod(DigestMethod digestMethod) {
		this.digestMethod = digestMethod;
	}

	public String getDigestValue() {
		return digestValue;
	}

	public void setDigestValue(String digestValue) {
		this.digestValue = digestValue;
	}

}
