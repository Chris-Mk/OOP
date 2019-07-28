package PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        return point.getPointX() >= this.bottomLeft.getPointY() &&
                point.getPointY() >= this.bottomLeft.getPointY() &&
                point.getPointX() <= topRight.getPointX() &&
                point.getPointY() <= topRight.getPointY();
    }
}
