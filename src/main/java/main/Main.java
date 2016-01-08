package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.TaskRequestsServlet;

import java.util.logging.Logger;

/**
 * @author Guskov Artem
 *         on 08.01.2016.
 */
public class Main {

    public static Logger logger = Logger.getGlobal();

    public static void main(String[] args) {

        TaskRequestsServlet taskRequestsServlet = new TaskRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(taskRequestsServlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        try {
            server.join();
            logger.info("Server started");
            server.start();
        } catch (Exception e) {
            logger.warning("Try to start server. Exception: " + e);
            e.printStackTrace();
        }
    }
}
