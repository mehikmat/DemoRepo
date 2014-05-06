package test.jaxws.client;

import test.jaxws.server.services.CalculatorService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * @author <a href="mailto:me.hemant.available@gmail.com">Hikmat Dhamee</a>
 */
public class CalculatorServiceClient {

    /**
     * Service Client
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/ws/calc?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://impl.server.jaxws.test/", "CalculatorServiceImplService");

        Service service = Service.create(url, qname);

        CalculatorService calcSvc = service.getPort(CalculatorService.class);

        System.out.println(calcSvc.mul(5,6));

    }
}
