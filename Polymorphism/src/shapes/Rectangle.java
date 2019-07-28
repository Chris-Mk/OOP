package shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return this.height;
    }

    public Double getWidth() {
        return this.width;
    }

    @Override
    public Double calculateArea() {
        return this.height * this.width;
    }

    @Override
    public Double calculatePerimeter() {
        return (this.width + this.height) * 2;
    }
}
