abstract class Shape {
    public abstract double area();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}

public class OCPDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(3.0);
        Shape rect = new Rectangle(4, 5);
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rect.area());
    }
}

