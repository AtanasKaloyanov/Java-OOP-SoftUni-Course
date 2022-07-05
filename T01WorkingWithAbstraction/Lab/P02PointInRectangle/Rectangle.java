package T01WorkingWithAbstraction.Lab.P02PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        boolean containsOnX = point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX();
        boolean containsOnY = point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();

        if (containsOnX && containsOnY) {
            return true;
        }
        return false;
    }
}
