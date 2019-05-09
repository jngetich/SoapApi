/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safaricomhackathon.SoapApi.api;

import com.safaricomhackathon.SoapApi.dbconn.DbFunctions;
import com.safaricomhackathon.SoapApi.utilities.XMLP;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jngetich
 */
public class RequestProcessor {

    
    
    //main request processor
    public String processRequest(String request) {
        String response = "";

        Map<String, String> requestMap = new HashMap<>();
        XMLP parser = new XMLP();
        requestMap = parser.parsexml(request);
        int result = 0;

        //get  service from request to determine the kind of transaction
        String service = requestMap.get("Service").trim();

        String ItemA = requestMap.get("ItemA").trim();
        String ItemB = requestMap.get("ItemB").trim();

        int a = Integer.parseInt(ItemA);
        int b = Integer.parseInt(ItemB);;

        
        switch (service) {
            case "ADDITION":
                result = new Calculations().addition(a, b);

                break;
            case "SUBTRACTION":
                result = new Calculations().subtraction(a, b);
                break;
            case "DIVISION":
                double val = new Calculations().division(a, b);
                result = (int) val;

                break;
            case "MULTIPLICATION":
                result = new Calculations().multiplication(ItemA, b);
                break;

        }
        response = String.valueOf(result);

        requestMap.put("result", response);
        DbFunctions dbf = new DbFunctions();
        dbf.storeValues(requestMap);

        return response;
    }

}
