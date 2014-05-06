package test.jaxws.server.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Calculator Service Interface
 *
 * @author Hikmat Dhamee
 * @version 1.0
 * @since 1.0
 * @time 12:02
 * @date 5/6/14.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CalculatorService {
    /**
     * calculates sum of two numbers
     * @param a
     * @param b
     * @return
     */
    @WebMethod
    public double sum( int a,int b);

    /**
     * calculates multiplication of two numbers
     * @param a
     * @param b
     * @return
     */
    @WebMethod
    public double mul( double a, double b);

    /**
     * calculates subtraction of two numbers
     * @param a
     * @param b
     * @return
     */
    @WebMethod
    public double sub( double a, double b);

    /**
     * calculates division of two numbers
     * @param a
     * @param b
     * @return
     */
    @WebMethod
    public double div( double a, double b);
}
