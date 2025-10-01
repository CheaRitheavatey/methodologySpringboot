public class Main{
    public static void main(String[] args) {

        Printer printer = new Printer("Epson");
        printer.draw();
        printer.print();

        Shape square = new Shape("Square", "Blue");
        square.draw();
        square.resize(200);


    }
}


class Shape implements Drawable, Drawable.Resizable {
    // data field
    private String name;
    private String color;
    private static int shapeAmount=0;

    // constructor
    Shape(String name, String color) {
        this.name = name;
        this.color = color;
        this.shapeAmount++;
    }


    @Override
    public void resize(int percentage) {
        if (percentage > MAX_RESIZE_PERCENTAGE) {
            System.out.println("Cannot");
        } else {
            System.out.println("Resize: " + this.name + " by " + percentage);
        }
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + this.name + " colored "  + this.color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static int getShapeAmount() {
        return shapeAmount;
    }


}

class Printer implements Printable {
    // data field
    private String printerName;

    // constructor
    Printer(String printerName) {
        this.printerName = printerName;
    }


    @Override
    public void draw() {
        System.out.println("Drawing using the printer: "  + this.printerName);
    }

    @Override
    public String getColor() {
        return "Pink";
    }

    @Override
    public void print() {
        System.out.println("Print a document on the " + this.printerName);
    }

    @Override
    public String getPaerSize() {
        return Printable.super.getPaerSize();
    }

}