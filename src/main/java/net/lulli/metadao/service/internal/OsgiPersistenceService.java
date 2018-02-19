package net.lulli.metadao.service.internal;

import net.lulli.metadao.DbConnectionManager;
import net.lulli.metadao.MetaPersistenceManagerImpl;
import net.lulli.metadao.api.MetaPersistenceManager;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Service;

@Component(label = "MetaPersistenceManager", immediate = true, policy = ConfigurationPolicy.OPTIONAL)
@Service(value = {MetaPersistenceManager.class})
public class OsgiPersistenceService extends MetaPersistenceManagerImpl implements MetaPersistenceManager
{

    public DbConnectionManager getDbConnectionManager() {
        OsgiDbManager dbManager = OsgiDbManager.getInstance();
        this.setSQLDialect(MYSQL);
        return dbManager;
    }


}
