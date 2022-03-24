package com.practice.web.soap;

import com.practice.model.soap.head.RequestHead;
import com.practice.model.soap.message.PayeeInformation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "ServerServiceDemo", targetNamespace = "http://soap.web.practice.com")
public interface ServerServiceDemo {
    @WebMethod
    String emrService(@WebParam(name = "requestHead",header = true) RequestHead requestHead,
                      @WebParam(name = "payeeInformation") PayeeInformation payeeInformation);

}
