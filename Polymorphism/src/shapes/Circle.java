package shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return this.radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }
}
