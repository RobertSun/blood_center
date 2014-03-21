package example;

import org.dlbc.ws.NIWebService;
import org.dlbc.ws.NIWebServiceSoap;

/**
 * Created by IntelliJ IDEA.
 * User: echo
 * Date: 7/5/11
 * Time: 6:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldClient {
  public static void main(String[] argv) {
    NIWebService service  = new NIWebService();
    NIWebServiceSoap port = service.getNIWebServiceSoap();
    port.getCollectPlaceList();
    //invoke business method
  }
}