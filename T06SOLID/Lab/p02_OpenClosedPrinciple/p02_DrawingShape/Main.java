package T06SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape;


import T06SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.DrawingManager;
import T06SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class Main {
    public static void main(String[] args) {

        Shape roundCircle = new Circle();
        DrawingManager boss = new DrawingManagerImpl();
        boss.draw(roundCircle);

        Shape field = new Rectangle();
        DrawingManager secondBoss = new DrawingManagerImpl();
        secondBoss.draw(field);
    }
}
