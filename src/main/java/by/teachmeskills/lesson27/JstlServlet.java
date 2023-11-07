package by.teachmeskills.lesson27;

import by.teachmeskills.lesson27.dto.ElementDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet("/jstl")
public class JstlServlet extends HttpServlet {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        req.setAttribute("flag", flag == null || flag.trim().isEmpty()
                ? null
                : Boolean.valueOf(flag)
        );
        req.setAttribute("type", "TEXT");
        req.getSession().setAttribute("elems",
                List.of(new ElementDto("Milk", 1),
                        new ElementDto("Cheese", 2),
                        new ElementDto("Bread", 3),
                        new ElementDto("Tomato", 4),
                        new ElementDto("Cucumber", 5)));

        getServletContext().setAttribute("now", new Date());

        getServletContext().setAttribute("formattedNow", DATE_TIME_FORMATTER.format(LocalDateTime.now()));

        req.getSession().setAttribute("money", new BigDecimal("132131413"));

        getServletContext().getRequestDispatcher("/WEB-INF/jstl.jsp").forward(req, resp);
    }
}
