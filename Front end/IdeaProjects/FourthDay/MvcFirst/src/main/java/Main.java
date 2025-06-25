//import controller.HelloController;
//
//import java.io.IOException;
//import java.io.OutputStream;
//
//public class Main {
//}


import java.io.*;
import java.net.net.InetSocketAddress;

import controller.HelloController;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.service.annotation.HttpExchange;

class HelloHandler implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            HelloController controller = new HelloController();
            String response = controller.sayHello();
            exchange.sendResponseHeaders( 200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        else{
            exchange.sendResponseHeaders( 405, -1);
        }
    }
}