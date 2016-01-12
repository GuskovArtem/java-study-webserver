package main;

import accounts.AccountService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

import java.util.logging.Logger;

/**
 * @author Guskov Artem
 *         on 08.01.2016.
 */
public class Main {

  public static Logger logger = Logger.getGlobal();

  public static void main(String[] args) {

    AccountService accountService = new AccountService();
    SignInServlet signInServlet = new SignInServlet(accountService);
    SignUpServlet signUpServlet = new SignUpServlet(accountService);

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.addServlet(new ServletHolder(signUpServlet), "/signup");
    context.addServlet(new ServletHolder(signInServlet), "/signin");

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
