package designPattern.structural.flyweight;

import java.awt.*;

public class Oval implements Shape{
    // additional property
    private boolean fill;
    public Oval(boolean fill) {
        this.fill = fill;
        System.out.println("creating an oval object with fill: "  + fill);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
        if (fill) {
            g.fillOval(x, y, width, height);
        }

    }
}
