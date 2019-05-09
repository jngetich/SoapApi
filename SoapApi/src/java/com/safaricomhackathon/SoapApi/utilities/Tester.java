/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safaricomhackathon.SoapApi.utilities;

import com.safaricomhackathon.SoapApi.api.RequestProcessor;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jngetich
 */
public class Tester {

    public static void main(String[] args) {

        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                + "<soap:Envelope\n"
                + "	xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"\n"
                + "	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
                + "	xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n"
                + "	<soap:Body>\n"
                + "		<ItemA >5\n"
                + "		</ItemA>\n"
                + "		<ItemB>2\n"
                + "		</ItemB>\n"
                + "		<Service>ADDITION\n"
                + "		</Service>\n"
                + "	</soap:Body>\n"
                + "</soap:Envelope>";
        Map<String, String> requestMap = new HashMap<>();
        XMLP parser = new XMLP();
        requestMap = parser.parsexml(xml);
        RequestProcessor processor = new RequestProcessor();
        System.out.println(processor.processRequest(xml));

    }
}
