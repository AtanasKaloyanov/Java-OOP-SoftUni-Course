package T06SOLID.Lab.p03_LiskovSubstitution.p01_Square;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Shape> shapeList = new ArrayList<>();

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(1);
        rectangle.setHeight(5);

        Square square = new Square();
        square.setRadius(3);

        shapeList.add(rectangle);
        shapeList.add(square);

        for (Shape shape : shapeList) {
            System.out.println(shape.getArea());
        }


    }
}
