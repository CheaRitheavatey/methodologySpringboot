import designPattern.abstractFactory.PCFactory;
import designPattern.abstractFactory.ServerFactory;
import designPattern.creatioinal.Computer;
import designPattern.creatioinal.ComputerFactory;
import designPattern.singleton.Singleton;

public class Main{
    public static void main(String[] args) {
        testBuilder();
//        testAbstractFactory();

//        TestDesignPattern.testFactory();
//        TestDesignPattern.testSingleton();

        Printer printer = new Printer("Epson");
//        printer.draw();
//        printer.print();

        Shape square = new Shape("Square", "Blue");
//        square.draw();
//        square.resize(200);


    }

    private static void testAbstractFactory() {
        designPattern.abstractFactory.Computer pc = designPattern.abstractFactory.ComputerFactory.getComputer(new PCFactory("6 GB", "200 GB"));
        designPattern.abstractFactory.Computer server = designPattern.abstractFactory.ComputerFactory.getComputer(new ServerFactory("16 GB", "256 GB"));

        System.out.println(pc.getClass().getName() + ": pc");
        System.out.println(server.getClass().getName() + ": server");
    }

    private static void testBuilder() {
        designPattern.builder.Computer c = new designPattern.builder.Computer.ComputerBuilder("10 GB", "128 GB").setGraphiccardEnable(true).build();

        System.out.println(c.getRam());
        System.out.println(c.isGraphiccardEnable());
        System.out.println(c.isBluetoothEnable());
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

class TestDesignPattern {
    // it should be private but i want to test it in main class
    protected static void testFactory() {
        Computer pc = ComputerFactory.getComputer("16 GB", "2 TB", "pc");
        Computer server = ComputerFactory.getComputer("32 GB", "1 TB", "server");

        System.out.println(pc.getClass().getName() + "Factory pc config: "  + pc);
        System.out.println(server.getClass().getName() + "Factory server config: "  + server);
    }

    protected static void testSingleton() {
        // both hashcode should refer to the samememory locaton
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();

        System.out.println("hascode of x "  +x);
        System.out.println("hascode of y "  +y);
    }
}