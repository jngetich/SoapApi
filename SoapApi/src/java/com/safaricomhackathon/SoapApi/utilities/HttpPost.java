/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safaricomhackathon.SoapApi.utilities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author jngetich
 */
public class HttpPost {

    public String HttpPost(String data, String url) {
        
        StringBuffer stringBuffer = new StringBuffer();
        String response = "";
        try {
            URL oURL = new URL(url);
            HttpURLConnection con = (HttpURLConnection) oURL.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Content-type", "text/xml; charset=utf-8");
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            con.setConnectTimeout(15000);
            con.setReadTimeout(45000);
            OutputStream reqStream = con.getOutputStream();
            reqStream.write(data.getBytes());

            int responseCode = con.getResponseCode();
            String inputLine;
            BufferedReader bufferedReader = null;
                InputStream resStream = con.getInputStream();
                InputStreamReader streamReader = new InputStreamReader(resStream);
                bufferedReader = new BufferedReader(streamReader);
                while ((inputLine = bufferedReader.readLine()) != null) {
                    stringBuffer.append(inputLine);
                }
                response = stringBuffer.toString();
            
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));

            response = e.getMessage();
        }

        return response;

    }

}
