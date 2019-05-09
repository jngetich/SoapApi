/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safaricomhackathon.SoapApi.api;

import com.safaricomhackathon.SoapApi.utilities.HttpPost;
import com.safaricomhackathon.SoapApi.utilities.XMLP;
import java.util.HashMap;

/**
 *
 * @author jngetich
 */
public class Calculations {

    HttpPost http = new HttpPost();
    String url = "http://www.dneonline.com/calculator.asmx";

    public int addition(int a, int b) {
        int sum = 0;

        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <tem:Add>\n"
                + "         <tem:intA>" + a + "</tem:intA>\n"
                + "         <tem:intB>" + b + "</tem:intB>\n"
                + "      </tem:Add>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        String response = http.HttpPost(request, "http://www.dneonline.com/calculator.asmx");
        sum = processadditionresponse(response);
        return sum;

    }

    public int processadditionresponse(String xml) {
        int sum = 0;
        XMLP xmlparse = new XMLP();
        HashMap<String, String> data = xmlparse.parsexml(xml);
        String sumString = data.get("AddResult").toString();
        sum = Integer.parseInt(sumString);

        return sum;

    }

    public double division(int a, int b) {
        double sum = 0;

        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <tem:Divide>\n"
                + "         <tem:intA>" + a + "</tem:intA>\n"
                + "         <tem:intB>" + b + "</tem:intB>\n"
                + "      </tem:Divide>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        String response = http.HttpPost(request, url);
        sum = processdivisionresponse(response);
        return sum;

    }

    public double processdivisionresponse(String xml) {
        double sum = 0;
        XMLP xmlparse = new XMLP();
        HashMap<String, String> data = xmlparse.parsexml(xml);
        String sumString = data.get("DivideResult").toString();
        sum = Integer.parseInt(sumString);

        return sum;

    }

    public int multiplication(String a, int b) {
        int sum = 0;
        long val_a_int = 0;
        val_a_int = Long.parseLong(a);

        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <tem:Multiply>\n"
                + "         <tem:intA>" + val_a_int + "</tem:intA>\n"
                + "         <tem:intB>" + b + "</tem:intB>\n"
                + "      </tem:Multiply>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        String response = http.HttpPost(request, url);
        sum = processmultiplicationresponse(response);
        return sum;

    }

    public int processmultiplicationresponse(String xml) {
        int sum = 0;
        XMLP xmlparse = new XMLP();
        HashMap<String, String> data = xmlparse.parsexml(xml);
        String sumString = data.get("MultiplyResult").toString();
        sum = Integer.parseInt(sumString);

        return sum;

    }

    public int subtraction(int a, int b) {
        int sum = 0;

        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <tem:Subtract>\n"
                + "         <tem:intA>" + a + "</tem:intA>\n"
                + "         <tem:intB>" + b + "</tem:intB>\n"
                + "      </tem:Subtract>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        String response = http.HttpPost(request, url);
        sum = processubtractionresponse(response);
        return sum;

    }

    public int processubtractionresponse(String xml) {
        int sum = 0;
        XMLP xmlparse = new XMLP();
        HashMap<String, String> data = xmlparse.parsexml(xml);
        String sumString = data.get("SubtractResult").toString();
        sum = Integer.parseInt(sumString);

        return sum;

    }

}
