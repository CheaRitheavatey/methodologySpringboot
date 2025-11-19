package designPattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    // create hashmap cuz we dont want to create a new obj all the time thats y hashmap is used
    private static final Map<ShapeType, Shape> map = new HashMap<>();
    public static Shape getShape(ShapeType shapeType) {
        Shape shapeImplementation = map.get(shapeType);

        if (shapeImplementation == null) {
            if (shapeType.equals(ShapeType.OVAL_FILL)) {
                shapeImplementation = new Oval(true);
            } else if (shapeType.equals(ShapeType.OVAL_NO_FILL)) {
                shapeImplementation = new Oval(false);
            } else if (shapeType.equals(ShapeType.LINE)) {
                shapeImplementation = new Line();
            }

            map.put(shapeType, shapeImplementation);
        }

        return shapeImplementation;
    }

    public static enum ShapeType {
        LINE,
        OVAL_FILL,
        OVAL_NO_FILL
    }
}
