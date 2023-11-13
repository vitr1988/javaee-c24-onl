package by.teachmeskills.lesson25;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static by.teachmeskills.lesson25.FileDownloadServlet.PATH_REQUEST_PARAMETER_NAME;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String list;
        try (Stream<Path> stream = Files.list(Path.of("/tmp"))) {
            list = stream
                    .map(it -> "<li><a target=\"_blank\" href=\"" + req.getContextPath() + "/download?" + PATH_REQUEST_PARAMETER_NAME + "=" + it + "\">" + it + "</a></li>")
                    .collect(Collectors.joining());
        }
        resp.getWriter().println("<ul>" + list + "</ul>");
    }
}
