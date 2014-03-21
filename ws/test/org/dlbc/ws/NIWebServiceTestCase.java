package org.dlbc.ws;

import org.dlbc.ws.handler.HeaderHandlerResolver;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.List;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: echo
 * Date: 7/5/11
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class NIWebServiceTestCase {
    @Test
    public void service() throws DatatypeConfigurationException {
        NIWebService service = new NIWebService();
        assertNotNull("NIWebService is NULL",service);
        service.setHandlerResolver(new HeaderHandlerResolver());
        NIWebServiceSoap port = service.getNIWebServiceSoap();
        assertNotNull("Soap port is NULL", port);
        List<CollectPlaceDic> places = port.getCollectPlaceList().getCollectPlaceDic();

        for(CollectPlaceDic place : places){
            System.out.println("--------------------");
            System.out.println(place.code);
            System.out.println(place.getName());
        }



    }
}
