package T06SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape;

import T06SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("[]");
    }
}
