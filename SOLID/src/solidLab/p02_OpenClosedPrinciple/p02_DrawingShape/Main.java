package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.DrawingManager;
import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        DrawingManager drawingManager = new DrawingManagerImpl();
        drawingManager.draw(circle);
        drawingManager.draw(rectangle);
    }
}
