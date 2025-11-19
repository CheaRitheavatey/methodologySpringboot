package designPattern.structural.bridge;

public abstract class Shape {
    // composition
    protected Color color;
    public Shape(Color color) {
        this.color = color;
    }
    public abstract void applyColor();

}
