package by.teachmeskills.lesson25;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {

    public static final String PATH_REQUEST_PARAMETER_NAME = "path";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getParameter(PATH_REQUEST_PARAMETER_NAME);
        File file = new File(path);
        String fileName = file.getName();

        if (file.exists()) {
            response.setHeader("Content-Disposition", "inline;filename=" + fileName);
            try (FileInputStream in = new FileInputStream(file);
                 OutputStream out = response.getOutputStream()) {
                response.setStatus(200);
                byte[] buffer = new byte[1024];
                int numBytesRead;
                while ((numBytesRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, numBytesRead);
                }
            }
        } else {
            response.setStatus(404);
        }
    }
}
