package designPattern.structural.composite;

// triangle is the leaf object
public class Triangle implements Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color: " + fillColor);
    }
}
