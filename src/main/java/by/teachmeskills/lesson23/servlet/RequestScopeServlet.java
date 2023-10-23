package by.teachmeskills.lesson23.servlet;

import by.teachmeskills.lesson23.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request")
public class RequestScopeServlet extends HttpServlet {

    public static final String REQUEST_ATTRIBUTE_NAME = "reqAttr";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = new UserDto("Vitalii", "vitr1988");
        System.out.println("try to put attribute");
        req.setAttribute(REQUEST_ATTRIBUTE_NAME, userDto);
        System.out.println("putting attribute succeeded");
        req.getRequestDispatcher("/other").forward(req, resp);
    }
}
