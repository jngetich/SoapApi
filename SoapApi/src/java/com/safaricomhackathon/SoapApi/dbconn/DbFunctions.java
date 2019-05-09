/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safaricomhackathon.SoapApi.dbconn;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author jngetich
 */
public class DbFunctions {

    private DbConnection dbConn = new DbConnection();

    private void getDBconn() {
        this.dbConn = new DbConnection();
    }

    //INSETING CALCULATION DETAILS TO THE DATABASE
    public boolean storeValues(Map<String,String> requestMap) {
        boolean excecute = false;
        try {
            String sqlString = "INSERT INTO TBSOAPUI (service,valueA,valueB,result)\n"
                    + "VALUES(?,?,?,?); ";
            Map<Integer, Object> params = new HashMap<>();
            PreparedStatement preparedStatement = dbConn.conn.prepareStatement(sqlString);
            preparedStatement.setString(1, requestMap.get("Service"));
            preparedStatement.setString(2, requestMap.get("ItemA"));
            preparedStatement.setString(3, requestMap.get("ItemB"));
            preparedStatement.setString(4, requestMap.get("result"));
            excecute = preparedStatement.execute();
            excecute = true;
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return excecute;

    }

}
