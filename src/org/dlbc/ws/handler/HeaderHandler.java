package org.dlbc.ws.handler;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * Created by IntelliJ IDEA.
 * User: echo
 * Date: 7/5/11
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {
    public boolean handleMessage(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outboundProperty.booleanValue()) {
            SOAPMessage message = smc.getMessage();
            try {

                SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.addHeader();

                SOAPElement security =
                    header.addChildElement("ServiceSoapHead","","http://tempuri.org/");

	            SOAPElement username =
	            	security.addChildElement("UserName");
	            username.addTextNode("GH137");

	            SOAPElement password =
	            	security.addChildElement("UserPassword");
	            password.addTextNode("999666");

//                Print out the outbound SOAP message to System.out
                message.writeTo(System.out);
                System.out.println("");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                SOAPMessage message = smc.getMessage();
                message.writeTo(System.out);
                System.out.println("");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return outboundProperty;
    }

    public Set<QName> getHeaders() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean handleFault(SOAPMessageContext soapMessageContext) {
        return true;
    }

    public void close(MessageContext messageContext) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
