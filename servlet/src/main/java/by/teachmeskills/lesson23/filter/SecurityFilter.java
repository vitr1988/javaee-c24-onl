package by.teachmeskills.lesson23.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/session", "/context"}, servletNames = "yetAnotherServlet")
@WebFilter(urlPatterns = "/context")
public class SecurityFilter extends HttpFilter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        // preconditions
        if (req.getSession().getAttribute("test") == null) {
            res.getWriter().println("You should be authenticated");
        } else {
            chain.doFilter(req, res);
        }
        // postconditions
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
