package lesson34.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class Hw32 extends HttpServlet {

    private final Map<String, TriConsumer<String, HttpServletRequest, HttpServletResponse>> VIEW_AND_LOGIC =
            Map.of("home", this::dispatchView,
                    "default", this::dispatchView,
                    "minsk", this::dispatchView);

    private void dispatchView(String view, HttpServletRequest req, HttpServletResponse resp) {
        try {
            getServletContext().getNamedDispatcher(view).forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewName = req.getParameter("viewName");
        VIEW_AND_LOGIC.getOrDefault(viewName, (s, t1, t2) -> {
            // do nothing
        }).consume(viewName, req, resp);
    }

    public void consume(String view) {

    }
}
