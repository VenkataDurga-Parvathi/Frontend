import java.util.*;

class Singleton {
    public static Singleton single_instance = null;
    public String s;

    private Singleton() {
        s = "String from Singleton class";
    }

    public static Singleton Singleton() {
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }
}

class Geeks {
    public static void main(String args[]) {
        Singleton x = Singleton.Singleton();
        Singleton y = Singleton.Singleton();
        x.s = (x.s).toUpperCase();
        System.out.println("String from x: " + x.s + ", y: " + y.s);
        y.s = (y.s).toLowerCase();
        System.out.println("String from x: " + x.s + ", y: " + y.s);
    }
}