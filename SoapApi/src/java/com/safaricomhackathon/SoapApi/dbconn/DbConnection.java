/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safaricomhackathon.SoapApi.dbconn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author jngetich
 */
public class DbConnection {

    public Connection conn = null;
    javax.sql.DataSource ds;
    public Statement stmt = null;
    public ResultSet rs = null;
    public Context ctx = null;

    public DbConnection() {

        this.conn = getDbConn();
    }

    public Connection getDbConn() {
        Connection connection = null;

        try {
            String dsName = "jdbc/ToyotaCarShowroom";
            ctx = new InitialContext();
            ds = (javax.sql.DataSource) ctx.lookup(dsName);
            connection = ds.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
