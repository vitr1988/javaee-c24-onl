package by.teachmeskills.lesson23.servlet;

import by.teachmeskills.lesson23.dto.CartDto;
import by.teachmeskills.lesson23.dto.ProductDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    public static final String SESSION_ATTRIBUTE_NAME = "sessionAttr";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("test", "test");
        CartDto cartDto = new CartDto();
        cartDto.setLogin("vitr1988");
        cartDto.setProductList(List.of(
                new ProductDto("Bread", new BigDecimal("50")),
                new ProductDto("Milk", new BigDecimal("100"))
        ));
        session.setAttribute(SESSION_ATTRIBUTE_NAME, cartDto);
//        session.setMaxInactiveInterval(123);
    }
}
