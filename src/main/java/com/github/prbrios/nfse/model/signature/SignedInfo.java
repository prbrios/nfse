package com.github.prbrios.nfse.model.signature;

import org.simpleframework.xml.Element;

public class SignedInfo {

    @SuppressWarnings("unused")
	private static final long serialVersionUID = -5878065134465400530L;

    @Element(name = "CanonicalizationMethod", required = false)
    private CanonicalizationMethod canonicalizationMethod;

    @Element(name = "SignatureMethod", required = false)
    private SignatureMethod signatureMethod;

    @Element(name = "Reference", required = false)
    private Reference reference;

    public CanonicalizationMethod getCanonicalizationMethod() {
        return this.canonicalizationMethod;
    }

    public void setCanonicalizationMethod(final CanonicalizationMethod canonicalizationMethod) {
        this.canonicalizationMethod = canonicalizationMethod;
    }

    public SignatureMethod getSignatureMethod() {
        return this.signatureMethod;
    }

    public void setSignatureMethod(final SignatureMethod signatureMethod) {
        this.signatureMethod = signatureMethod;
    }

    public Reference getReference() {
        return this.reference;
    }

    public void setReference(final Reference reference) {
        this.reference = reference;
    }

}
