package com.practice.web.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "ServerServiceDemo", targetNamespace = "http://soap.web.practice.com")
public interface ServerServiceDemo {
    @WebMethod
    String emrService(@WebParam(name = "data") String data);

}
