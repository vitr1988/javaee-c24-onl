package by.teachmeskills.lesson26.servlet;

import by.teachmeskills.lesson26.service.StorageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    private StorageService storageService = new StorageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !id.isEmpty() && id.matches("\\d+")) {
//            req.setAttribute("name", "requestName");
//            req.getSession().setAttribute("name", storageService.getById(Long.valueOf(id)));
            getServletContext().setAttribute("name", "applicationName");

        }
        req.getRequestDispatcher("/WEB-INF/info.jsp").forward(req, resp);
        transform(null);
    }

    @Nullable
    public String transform(@Nullable String str) {
        String result;
        if (str == null || str.trim().isEmpty()) {
            System.out.println("null-строка");
            return null;
        }
        result = "str" + str + "str";

        for (Integer i: List.of(1, 2, 3, 4, 5)) {

        }

        return result;
    }
}
