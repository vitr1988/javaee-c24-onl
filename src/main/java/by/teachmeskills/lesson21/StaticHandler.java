package by.teachmeskills.lesson21;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StaticHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        String filename = "src/main/resources" + path;
        File file = new File(filename);
        if (file.exists()) {
            Headers headers = exchange.getResponseHeaders();
            headers.set("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, file.length());
            try (OutputStream os = exchange.getResponseBody();
                 FileInputStream fis = new FileInputStream(file)) {
                int count;
                byte[] buffer = new byte[1024];
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                }
            }
        } else {
            String response = "File not found";
            exchange.sendResponseHeaders(404, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}
