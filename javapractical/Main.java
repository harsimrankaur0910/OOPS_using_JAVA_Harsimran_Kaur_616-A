class Shape {
    void area() {
        System.out.println("Area method in Shape");
    }
}

class Circle extends Shape {
    void area() {
        double r = 5;
        double area = 3.14 * r * r;
        System.out.println("Area of Circle = " + area);
    }
}

class Rectangle extends Shape {
    void area() {
        int l = 10, b = 5;
        int area = l * b;
        System.out.println("Area of Rectangle = " + area);
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle();
        Rectangle r = new Rectangle();

        c.area();
        r.area();
    }
}