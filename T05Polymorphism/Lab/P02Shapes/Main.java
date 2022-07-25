package T05Polymorphism.Lab.P02Shapes;

public class Main {
    public static void main(String[] args) {
        Shape firstShape = new Rectangle(5.4, 4.2);
        System.out.println(firstShape.calculateArea());
        System.out.println(firstShape.calculatePerimeter());

        Shape secondShape = new Circle(2.5);
        System.out.println(secondShape.calculateArea());
        System.out.println(secondShape.calculatePerimeter());

    }
}
