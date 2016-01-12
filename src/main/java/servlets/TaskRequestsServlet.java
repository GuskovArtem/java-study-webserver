package servlets;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Guskov Artem
 *         on 08.01.2016.
 */
public class TaskRequestsServlet extends HttpServlet {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException
  {

    Map<String, Object> pageVariables = new HashMap<>();
    String value = request.getParameter("key");
    pageVariables.put("value", value == null ? "" : value);

    response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));

    response.setContentType("text/html;charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);

  }

  public void doPost(HttpServletRequest request,
                     HttpServletResponse response) throws ServletException, IOException
  {
    Map<String, Object> pageVariables = new HashMap<>();
    String value = request.getParameter("key");
    pageVariables.put("value", value == null ? "" : value);

    response.setContentType("text/html;charset=utf-8");

    response.setStatus(HttpServletResponse.SC_OK);

    response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
  }
}
