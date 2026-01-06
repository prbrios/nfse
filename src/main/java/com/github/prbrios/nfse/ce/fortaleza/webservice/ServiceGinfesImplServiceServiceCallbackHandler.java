/**
 * ServiceGinfesImplServiceServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package com.github.prbrios.nfse.ce.fortaleza.webservice;


/**
 *  ServiceGinfesImplServiceServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class ServiceGinfesImplServiceServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public ServiceGinfesImplServiceServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public ServiceGinfesImplServiceServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for cancelarNfse method
     * override this method for handling normal response from cancelarNfse operation
     */
    public void receiveResultcancelarNfse(
        ServiceGinfesImplServiceServiceStub.CancelarNfseResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from cancelarNfse operation
     */
    public void receiveErrorcancelarNfse(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for recepcionarLoteRpsV4 method
     * override this method for handling normal response from recepcionarLoteRpsV4 operation
     */
    public void receiveResultrecepcionarLoteRpsV4(
        ServiceGinfesImplServiceServiceStub.RecepcionarLoteRpsV4Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from recepcionarLoteRpsV4 operation
     */
    public void receiveErrorrecepcionarLoteRpsV4(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for recepcionarLoteRpsV3 method
     * override this method for handling normal response from recepcionarLoteRpsV3 operation
     */
    public void receiveResultrecepcionarLoteRpsV3(
        ServiceGinfesImplServiceServiceStub.RecepcionarLoteRpsV3Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from recepcionarLoteRpsV3 operation
     */
    public void receiveErrorrecepcionarLoteRpsV3(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for consultarLoteRpsV3 method
     * override this method for handling normal response from consultarLoteRpsV3 operation
     */
    public void receiveResultconsultarLoteRpsV3(
        ServiceGinfesImplServiceServiceStub.ConsultarLoteRpsV3Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultarLoteRpsV3 operation
     */
    public void receiveErrorconsultarLoteRpsV3(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for consultarNfsePorRpsV4 method
     * override this method for handling normal response from consultarNfsePorRpsV4 operation
     */
    public void receiveResultconsultarNfsePorRpsV4(
        ServiceGinfesImplServiceServiceStub.ConsultarNfsePorRpsV4Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultarNfsePorRpsV4 operation
     */
    public void receiveErrorconsultarNfsePorRpsV4(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for consultarNfsePorRpsV3 method
     * override this method for handling normal response from consultarNfsePorRpsV3 operation
     */
    public void receiveResultconsultarNfsePorRpsV3(
        ServiceGinfesImplServiceServiceStub.ConsultarNfsePorRpsV3Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultarNfsePorRpsV3 operation
     */
    public void receiveErrorconsultarNfsePorRpsV3(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for consultarLoteRpsV4 method
     * override this method for handling normal response from consultarLoteRpsV4 operation
     */
    public void receiveResultconsultarLoteRpsV4(
        ServiceGinfesImplServiceServiceStub.ConsultarLoteRpsV4Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultarLoteRpsV4 operation
     */
    public void receiveErrorconsultarLoteRpsV4(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for consultarNfseV4 method
     * override this method for handling normal response from consultarNfseV4 operation
     */
    public void receiveResultconsultarNfseV4(
        ServiceGinfesImplServiceServiceStub.ConsultarNfseV4Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultarNfseV4 operation
     */
    public void receiveErrorconsultarNfseV4(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for consultarNfseV3 method
     * override this method for handling normal response from consultarNfseV3 operation
     */
    public void receiveResultconsultarNfseV3(
        ServiceGinfesImplServiceServiceStub.ConsultarNfseV3Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultarNfseV3 operation
     */
    public void receiveErrorconsultarNfseV3(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for consultarSituacaoLoteRpsV3 method
     * override this method for handling normal response from consultarSituacaoLoteRpsV3 operation
     */
    public void receiveResultconsultarSituacaoLoteRpsV3(
        ServiceGinfesImplServiceServiceStub.ConsultarSituacaoLoteRpsV3Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultarSituacaoLoteRpsV3 operation
     */
    public void receiveErrorconsultarSituacaoLoteRpsV3(Exception e) {
    }
}
