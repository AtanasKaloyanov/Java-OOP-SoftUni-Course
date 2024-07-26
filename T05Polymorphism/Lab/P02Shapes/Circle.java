package T05Polymorphism.Lab.P02Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * this.radius * Math.PI);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.radius * this.radius * Math.PI);
    }

    public final Double getRadius() {
        return radius;
    }
}
