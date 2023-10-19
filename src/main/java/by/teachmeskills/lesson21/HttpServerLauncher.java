package by.teachmeskills.lesson21;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerLauncher {

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/hello", new HelloWorldHandler());
        httpServer.createContext("/", new HelloWorldHandler());
        httpServer.createContext("/static", new StaticHandler());
        httpServer.start();
    }
}