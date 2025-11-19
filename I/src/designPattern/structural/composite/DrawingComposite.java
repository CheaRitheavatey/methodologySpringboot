package designPattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

// composite class where it will hold all the leaf like circle, triangle... so we need to loop thru all leaf
public class DrawingComposite implements Shape {
    // collect of shape aka laef
    private List<Shape> shape = new ArrayList<>();
    @Override
    public void draw(String fillColor) {
        for (Shape s : shape) {
            s.draw(fillColor);
        }
    }

    // add shape to collection
    public void add(Shape s) {
        shape.add(s);
    }

    // remove shape or leaf from collectoin
    public void remove(Shape s) {
        shape.remove(s);
    }

    // clear collection
    public void clear() {
        System.out.println("clearing all shape from collection");
        shape.clear();
    }
}
