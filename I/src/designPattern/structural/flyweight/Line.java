package designPattern.structural.flyweight;

import java.awt.*;

public class Line implements Shape {
    public Line() {
        System.out.println("create line object");
        try {
            // add deplay to see when a new object is begin created
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void draw(Graphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        g.drawLine(x, y, x + width, y);
    }
}
