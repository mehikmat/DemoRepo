package test.jaxws.server.impl;

import test.jaxws.server.services.CalculatorService;

import javax.jws.WebService;

/*
 * Service Endpoint Interface Implementation
 * @author hdhamee,
 * @date 5/5/14 4:49 PM
 * @since 1.0
 * @version 1.0
 */
@WebService(endpointInterface = "test.jaxws.server.services.CalculatorService")
public class CalculatorServiceImpl implements CalculatorService {
    /**
     * Calculates sum
     * @param a
     * @param b
     * @return
     */
    @Override
    public double sum( int a,int b) {
        return a+b;
    }

    /**
     * Calculates multiplication
     * @param a
     * @param b
     * @return
     */
    @Override
    public double mul( double a, double b){

        return a*b;
    }

    /**
     * Calculates subtraction
     * @param a
     * @param b
     * @return
     */
    @Override
    public double sub( double a, double b){

        return a-b;
    }

    /**
     * Calculates division
     * @param a
     * @param b
     * @return
     */
    @Override
    public double div( double a, double b){

        return a/b;
    }
}
