package T06SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape;

import T06SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.DrawingManager;
import T06SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class DrawingManagerImpl implements DrawingManager {

    @Override
    public void draw(Shape shape) {
        shape.draw();
    }


}
