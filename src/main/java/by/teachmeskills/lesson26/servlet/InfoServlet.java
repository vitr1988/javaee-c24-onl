package by.teachmeskills.lesson26.servlet;

import by.teachmeskills.lesson26.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    private StorageService storageService = new StorageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !id.isEmpty() && id.matches("\\d+")) {
//            req.setAttribute("name", storageService.getById(Long.valueOf(id)));
            req.getSession().setAttribute("name", storageService.getById(Long.valueOf(id)));
        }
        req.getRequestDispatcher("/WEB-INF/info.jsp").forward(req, resp);
    }
}
