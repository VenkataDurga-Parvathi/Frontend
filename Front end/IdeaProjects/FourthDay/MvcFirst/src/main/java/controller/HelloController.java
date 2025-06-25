package controller;

//import org.apache.catalina.User;
import model.User;

public class HelloController {
    public String sayHello(){
        User user = new User("Suma");
        return "<html><body><h1>Hello, " + user.getName() + "!</h1></body></html>";
    }
}
