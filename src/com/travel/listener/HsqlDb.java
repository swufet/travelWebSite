package com.travel.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hsqldb.server.Server;;;

/**
 * Application Lifecycle Listener implementation class HsqlDb
 *
 */
@WebListener
public class HsqlDb implements ServletContextListener {
	Server server = new Server();
	public static final int PORT = 9001;
    /**
     * Default constructor. 
     */
    public HsqlDb() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
	    String path=arg0.getServletContext().getRealPath("/WEB-INF/db/travel/");
	    String dbName="traveldb";
	    server.setDatabaseName(0, dbName);
	    server.setDatabasePath(0, path+dbName);
	    server.setPort(9001);
	    server.setSilent(true);
	    server.setNoSystemExit(true);
        server.start(); // 实质和命令类似，也是创建数据库并启动服务，如果数据库存在，则直接启动即可
        System.out.println("hsqldb started...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
}
