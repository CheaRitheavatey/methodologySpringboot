package designPattern.structural.flyweight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientDrawing extends JFrame {
    private final int width;
    private final int height;

   private static final ShapeFactory.ShapeType[] shapes = {ShapeFactory.ShapeType.LINE, ShapeFactory.ShapeType.OVAL_FILL, ShapeFactory.ShapeType.OVAL_NO_FILL};
   private static final Color[] color = {Color.RED, Color.GREEN, Color.BLUE};

   // constructor
    public ClientDrawing(int width, int height) {
        this.width = width;
        this.height = height;

        // add panel
        Container container = getContentPane();

        JButton button = new JButton("Draw");
        final JPanel panel = new JPanel();

        container.add(panel, BorderLayout.CENTER);
        container.add(button, BorderLayout.SOUTH);

        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        // what the button suppose to do
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = panel.getGraphics();
                for (int i = 0; i < 5; i++) {
                    Shape shape = ShapeFactory.getShape(getRandomShape());
                    shape.draw(g, getRandomX(), getRandomY(), getRandomWithd(), getRandomHeight(), getRandomColor());
                }
            }
        });



    }

    private Color getRandomColor() {
        return color[(int)(Math.random() * color.length)];
    }

    private int getRandomHeight() {
        return (int) (Math.random() * height/3);
    }

    private int getRandomWithd() {
        return  (int) (Math.random() * width/3);
    }

    private int getRandomY() {
        return (int) (Math.random() * height);
    }

    private int getRandomX() {
        return (int) (Math.random() * width);
    }

    private ShapeFactory.ShapeType getRandomShape() {
        return  shapes[(int)(Math.random() * shapes.length)];
    }
}
