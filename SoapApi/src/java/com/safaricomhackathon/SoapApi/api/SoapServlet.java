/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safaricomhackathon.SoapApi.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author jngetich
 */
@WebServlet(name = "SoapApi", urlPatterns = {"/Soapservlet"})
public class SoapServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        String requestString = "";
        String outresponse = "";

        try {
            StringBuilder stringBuilder = new StringBuilder(256);

            BufferedReader reader = request.getReader();
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                line = reader.readLine();
            }
            requestString = stringBuilder.toString();

            if (requestString.isEmpty()) {

                outresponse = "Empty request body!";

            } else {

                outresponse = new RequestProcessor().processRequest(requestString);

            }

            reader.close();

        } catch (IOException ex) {

        }

        out.print(outresponse);

        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.print("GET METHOD NOT ALLOWED");
    }

    public boolean isJSON(String request) {
        try {
            JSONObject jsonObject = new JSONObject(request);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
