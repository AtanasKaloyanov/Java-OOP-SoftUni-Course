package T05Polymorphism.Lab.P02Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * this.height + 2 * this.width);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.width * this.height);
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }
}
