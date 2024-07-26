package T05Polymorphism.Lab.P02Shapes;

public class Main {
    public static void main(String[] args) {
        // 1. Creating 2 Shapes - One Circle and one Rectangle:
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(5.0, 2.0);

        // 2. Calculation and printing the perimeter and the area of the shapes:
        // 2.1. Circle
        circle.calculatePerimeter();
        circle.calculateArea();
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());

        // 2.2. Rectangle:
        rectangle.calculatePerimeter();
        rectangle.calculateArea();
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
    }
}
