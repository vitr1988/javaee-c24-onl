package by.teachmeskills.lesson23.servlet;

import by.teachmeskills.lesson23.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static by.teachmeskills.lesson23.servlet.ContextServlet.SERVLET_CONTEXT_ATTRIBUTE_NAME;
import static by.teachmeskills.lesson23.servlet.RequestScopeServlet.REQUEST_ATTRIBUTE_NAME;

@WebServlet(urlPatterns = "/other", name = "yetAnotherServlet")
public class YetAnotherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = (UserDto) req.getAttribute(REQUEST_ATTRIBUTE_NAME);
        resp.setHeader("Content-Type", "text/html");
        if (userDto == null) {
            resp.getWriter().println("You should firstly fetch <a href=\"request\">/request</a>");
        } else {
            resp.getWriter().println("User name %s and login %s".formatted(userDto.getName(), userDto.getLogin()));
            resp.getWriter().println("<br/>Amount of visits /context %s".formatted(Objects.toString(getServletContext().getAttribute(SERVLET_CONTEXT_ATTRIBUTE_NAME), "0")));
        }
    }
}
