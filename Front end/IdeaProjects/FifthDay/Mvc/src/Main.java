import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import controller.HelloController;

class HelloHandler implements HttpHandler{
    public void handle(HttpExchange exchange) throws IOException{
        if("GET".equals(exchange.getRequestMethod())) {
            HelloController controller = new HelloController();
            String response = controller.sayHello();
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        else {
            exchange.sendResponseHeaders(405,-1);
        }
    }

}
public class Main{
    public static void main(String args[]) throws IOException{
        HttpServer server=HttpServer.create(new InetSocketAddress(8080),0);
        server.createContext("/hello",new HelloHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started at http://localhost:8080");
    }
}
