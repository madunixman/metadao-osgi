package net.lulli.metadao.service.internal;

import net.lulli.metadao.DbConnectionManager;
import net.lulli.metadao.MetaPersistenceManagerImpl;

public class OsgiPersistenceManager extends MetaPersistenceManagerImpl
{

    public DbConnectionManager getDbConnectionManager() {
        OsgiDbManager dbManager = OsgiDbManager.getInstance();
        this.setSQLDialect(MYSQL);
        return dbManager;
    }


}
