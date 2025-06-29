abstract class Bird {}

interface Flyable {
    void fly();
}

class Sparrow extends Bird implements Flyable {
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Ostrich extends Bird {
    public void run() {
        System.out.println("Ostrich is running");
    }
}

public class LSPDemo {
    public static void main(String[] args) {
        Flyable sparrow = new Sparrow();
        sparrow.fly();

        Ostrich ostrich = new Ostrich();
        ostrich.run();
    }
}

