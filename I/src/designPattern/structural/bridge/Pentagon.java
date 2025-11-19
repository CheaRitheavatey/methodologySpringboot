package designPattern.structural.bridge;

public class Pentagon extends Shape{
    public Pentagon(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.println("pantagon colored with ");

        // color is from shape class
        color.applyColor();
    }
}
