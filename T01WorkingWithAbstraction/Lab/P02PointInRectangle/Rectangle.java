package T01WorkingWithAbstraction.Lab.P02PointInRectangle;

public class Rectangle {
    private int xMin;
    private int yMin;
    private int xMax;
    private int yMax;

    public Rectangle(int xMin, int yMin, int xMax, int yMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public boolean contains(Point point) {
        int x = point.getX();
        int y = point.getY();

        boolean isXInRect = x >= this.xMin && x <= this.xMax;
        boolean isYinRect = y >= this.yMin && y <= this.yMax;
        return isXInRect && isYinRect;
    }
}
/*
                    5
                    4
                    3     .
                    2
                    1
     -5 -4 -3 -2 -1 0 1 2 3 4 5
                   -1
                   -2
                   -3
                   -4
                   -5
 */

