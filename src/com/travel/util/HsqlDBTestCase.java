package com.travel.util;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HsqlDBTestCase {

    public static void main(String[] args) {
        HSQLUtil.mode = HSQLUtil.SERVER_MODE;
        HSQLUtil.startHSQL();

        try {
            System.out.println("start to connect hsqldb and excute statements\n");
            Statement statement = HSQLUtil.getConnection().createStatement();
            statement.executeUpdate("create table if not exists customer(id integer primary key,name varchar(32) not null,"
            +"password varchar(64) not null,UNIQUE(name))");
            for (int i = 10; i < 20; i++) {
                String password = UUID.randomUUID().toString();
                String name = password.split("\\-")[0];
                String sql = "insert into customer values(" + i + ",'" + name+ "','" + password + "')";
                int count = statement.executeUpdate(sql);
                System.err.println("excute [ " + sql + " ] "+ (count > 0 ? "Ok" : "Bad"));
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(HsqlDBTestCase.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        HSQLUtil.stopHSQL();
        System.out.println("\ndisconnect to hsqldb");
    }

}
