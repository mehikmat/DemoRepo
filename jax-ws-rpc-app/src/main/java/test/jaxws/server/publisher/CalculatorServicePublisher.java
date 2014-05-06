package test.jaxws.server.publisher;

import test.jaxws.server.impl.CalculatorServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Endpoint publisher
 * @author hdhamee,
 * @date 5/5/14 4:49 PM
 * @since 1.0
 * @version 1.0
 */
public class CalculatorServicePublisher {

    /**
     * Publishes calculator service to the world
     * Check at “http://localhost:9999/ws/calc?wsdl”
     * @param args
     */
    public static void main(String[] args) {
        Thread svc=new Thread(new Runnable() {
            @Override
            public void run() {
                Endpoint.publish("http://localhost:9999/ws/calc", new CalculatorServiceImpl());
            }
        });
        System.out.println("Starting Calculator service...........");
        svc.start();
        System.out.println("Successfully started calculator service.............");
        System.out.println("Service URL::> http://localhost:9999/ws/calc");
    }
}
