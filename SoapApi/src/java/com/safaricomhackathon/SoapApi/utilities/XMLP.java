/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safaricomhackathon.SoapApi.utilities;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author jngetich
 */
public class XMLP extends DefaultHandler {

    public static String value = "";
    public static Attributes attribbute;
    public static HashMap<String, String> map = new HashMap<String, String>();

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("AddResult")) {
            map.put("AddResult", value);
            value = "";

        }
        if (qName.equalsIgnoreCase("DivideResult")) {
            map.put("DivideResult", value);
            value = "";

        }
        if (qName.equalsIgnoreCase("MultiplyResult")) {
            map.put("MultiplyResult", value);
            value = "";

        }
        if (qName.equalsIgnoreCase("SubtractResult")) {
            map.put("SubtractResult", value);
            value = "";

        }
         if (qName.equalsIgnoreCase("ItemA")) {
            map.put("ItemA", value);
            value = "";

        } if (qName.equalsIgnoreCase("ItemB")) {
            map.put("ItemB", value);
            value = "";

        } if (qName.equalsIgnoreCase("Service")) {
            map.put("Service", value);
            value = "";

        }

    }

    @Override
    public void characters(char ch[], int start, int len) {
        value = new String(ch, start, len);
        System.out.println();

    }

    public HashMap parsexml(String xml) {
        HashMap<String, String> data = new HashMap<String, String>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new InputSource(new StringReader(xml)), this);
            data = new HashMap(map);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
        }
        return data;

    }
}
