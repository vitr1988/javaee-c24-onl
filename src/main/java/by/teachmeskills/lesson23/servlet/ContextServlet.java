package by.teachmeskills.lesson23.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context")
public class ContextServlet extends HttpServlet {

    public static final String SERVLET_CONTEXT_ATTRIBUTE_NAME = "scAttr";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (getServletContext().getAttribute(SERVLET_CONTEXT_ATTRIBUTE_NAME) == null) {
            resp.getWriter().println("First attempt to visit servlet /context");
            getServletContext().setAttribute(SERVLET_CONTEXT_ATTRIBUTE_NAME, 1);
        }
        else {
            getServletContext().setAttribute(SERVLET_CONTEXT_ATTRIBUTE_NAME,
                    (int) getServletContext().getAttribute(SERVLET_CONTEXT_ATTRIBUTE_NAME) + 1);
        }
    }
}
