package com.travel.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hsqldb.server.Server;

public class HSQLUtil {
	public static final int PORT = 9001;
    public static final String DB_NAME = "mydb"; // 数据库文件名，同时也是本类中的数据库名
    public static final String DB_PATH = "B:/db/";
    public static final String USER_NAME = "SA";
    public static final String PASSWORD = "";
    public static final int SERVER_MODE = 0;
    public static final int STAND_ALONE_MODE = 1; // In-Process
    public static int mode = SERVER_MODE; // 记录当前用什么模式，开发时用Server，发布时用standalone

    /**
     * 启动数据库服务
     */
    public static boolean startHSQL() {
        if (mode == SERVER_MODE) {
//            if (!HSQLUtil.isConnected()) {
                Server server = new Server();// 它可是hsqldb.jar里面的类啊。
                server.setDatabaseName(0, DB_NAME);
                server.setDatabasePath(0, DB_PATH + DB_NAME);
                server.setPort(PORT);
                server.setSilent(true);
                server.setNoSystemExit(true);
                server.start(); // 实质和命令类似，也是创建数据库并启动服务，如果数据库存在，则直接启动即可
                System.out.println("hsqldb started...1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
//              }
            }

        } else if (mode == STAND_ALONE_MODE) {
        	System.out.println("hsqldb started...2");
            // standalone模式，打开连接就同时启动数据库，所以这里可以什么都不做
        }
        System.out.println("hsqldb started...3");
        return true;
    }

    /**
     * 关闭数据库服务
     */
    public static boolean stopHSQL() {
        try {
            Statement statement = getConnection().createStatement();
            getConnection().close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HSQLUtil.class.getName()).log(Level.SEVERE, null,
                    ex);
            return false;
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            if (mode == SERVER_MODE) {
                conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:" + PORT + "/" + DB_NAME,USER_NAME, PASSWORD);
            } else if (mode == STAND_ALONE_MODE) {
                conn = DriverManager.getConnection("jdbc:hsqldb:file:"
                        + DB_PATH + DB_NAME, USER_NAME, PASSWORD);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HSQLUtil.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (SQLException ex) {
            Logger.getLogger(HSQLUtil.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return conn;
    }

    /**
     * 判断服务器是否已开启
     *
     * @return
     */
    public static boolean isConnected() {
        Connection hsqlConn = HSQLUtil.getConnection();
        boolean isOpened = false;

        if (hsqlConn == null) {
            return false;
        }
        try {
            isOpened = !hsqlConn.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                hsqlConn.close();
            } catch (SQLException e) {
            }
        }
        return isOpened;
    }
}
