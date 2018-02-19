package net.lulli.metadao.service;

import net.lulli.metadao.MetaDaoImpl;
import net.lulli.metadao.api.MetaDao;
import org.apache.felix.scr.annotations.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.Map;

@Component(label = "MetaDaoService", immediate = true, policy = ConfigurationPolicy.OPTIONAL)
@Service(value = {MetaDaoService.class})
public class MetaDaoService extends MetaDaoImpl implements MetaDao<Connection>
{
    static Logger log = Logger.getLogger("MetaDaoService");
    String status;

    @Activate
    public void activate(final Map<String, ?> config)
    {
        log.debug("START");
    }

    @Deactivate
    public void deactivate()
    {
        log.debug("STOP");
    }

}

