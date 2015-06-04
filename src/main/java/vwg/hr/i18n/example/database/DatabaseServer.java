package vwg.hr.i18n.example.database;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;

import java.io.IOException;
import java.util.Properties;

/**
 * Start HSQL Server
 * <p/>
 * http://ykchee.blogspot.de/2012/09/embedding-hsqldb-server-instance-in.html
 */
public class DatabaseServer implements SmartLifecycle {
    private final Logger logger = LoggerFactory.getLogger(DatabaseServer.class);
    private HsqlProperties properties;
    private Server server;
    private boolean running = false;

    public DatabaseServer(Properties props) {
        properties = new HsqlProperties(props);
    }

    public boolean isRunning() {
        if (server != null)
            server.checkRunning(running);
        return running;
    }

    public void start() {
        synchronized (this) {
            if (server == null) {
                logger.info("Starting HSQL server...");
                server = new Server();
                try {
                    server.setProperties(properties);
                    server.start();
                    running = true;
                } catch (ServerAcl.AclFormatException afe) {
                    logger.error("Error starting HSQL server.", afe);
                } catch (IOException e) {
                    logger.error("Error starting HSQL server.", e);
                }
            }
        }
    }

    public void stop() {
        logger.info("Stopping HSQL server...");
        synchronized (this) {
            if (server != null) {
                server.stop();
                running = false;
            }
        }
    }

    public int getPhase() {
        return 0;
    }

    public boolean isAutoStartup() {
        return true;
    }

    public void stop(Runnable runnable) {
        logger.info("Stopping HSQL server...");
        synchronized (this) {
            stop();
            runnable.run();
        }
    }
}
