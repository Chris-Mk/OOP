package solidLab.p03_LiskovSubstitution.p01_Square;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(2.0, 5.0);
        Shape square = new Square(5);

        System.out.println(rectangle.getArea());
        System.out.println(square.getArea());
    }
}
