package net.lulli.metadao.service.internal;

import net.lulli.metadao.DbConnectionManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


public class OsgiDbManager extends DbConnectionManager
{

    static Logger log = Logger.getLogger("OsgiDbManager");
    private static OsgiDbManager instance;

    public static OsgiDbManager getInstance()
    {
        if (instance == null)
        {
            instance = new OsgiDbManager();
        }
        return instance;
    }

    protected void init()
    {
        connection_counter = 0;
        connections = new ArrayList<Connection>();
        try
        {
            Class.forName(DRIVER_CLASS_NAME);

        } catch (Exception e)
        {
            log.error(e.getMessage());
        }
        for (int i = 0; i < pool_size; i++)
        {
            try (Connection singleConn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD))
            {
                connections.add(singleConn);
            } catch (Exception e)
            {
                log.error(e.getMessage());
            }
        }
    }

    private OsgiDbManager()
    {
        log.debug("--------------------------------------------------");
        JDBC_URL = System.getProperty("shape.JDBC_URL");
        log.debug("JDBC_URL=" + JDBC_URL);
        DRIVER_CLASS_NAME = System.getProperty("shape.DRIVER_CLASS_NAME");
        DB_USER = System.getProperty("shape.DB_USER");
        DB_PASSWORD = System.getProperty("shape.DB_PASSWORD");
        log.debug("JDBC_URL =" + JDBC_URL);
        log.debug("DRIVER_CLASS_NAME =" + DRIVER_CLASS_NAME);
        log.debug("DB_USER =" + DB_USER);
        log.debug("DB_PASSWORD =" + DB_PASSWORD);
        init();
    }
}