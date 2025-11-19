import designPattern.abstractFactory.PCFactory;
import designPattern.abstractFactory.ServerFactory;
import designPattern.creatioinal.Computer;
import designPattern.creatioinal.ComputerFactory;
import designPattern.prototype.Employee;
import designPattern.singleton.Singleton;
import designPattern.structural.adapter.SocketAdapter;
import designPattern.structural.adapter.SocketAdapterImplementation;
import designPattern.structural.adapter.Volt;
import designPattern.structural.composite.Circle;
import designPattern.structural.composite.DrawingComposite;
import designPattern.structural.composite.Triangle;
import designPattern.structural.facade.HelperFacade;
import designPattern.structural.facade.MySqlHelper;
import designPattern.structural.facade.OracleHelper;
import designPattern.structural.flyweight.ClientDrawing;
import designPattern.structural.proxy.CommandExecutor;
import designPattern.structural.proxy.CommandExecutorProxy;


import java.sql.Connection;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        testFacade();
//        testFlyWeight();
//        testProxy();
//        testComposite();
//        testAdapter();
//        testPrototype();
//        testBuilder();
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

    private static void testPrototype() {
        Employee employee = new Employee();
        employee.loadData();

        // create a new object from already exisiting object
        Employee employee1 = (Employee) employee.clone();
//        List<String> list1 = employee1.getEmployeeList();
//        list1.add("1");
        employee1.getEmployeeList().add("new member");

        System.out.println("Employee: " + employee.getEmployeeList());
        System.out.println("Employee 1: " + employee1.getEmployeeList());
    }

    public static void testAdapter() {
        SocketAdapter socketAdapter = new SocketAdapterImplementation();

        Volt v1 = socketAdapter.get3volt();
        Volt v2 = socketAdapter.get12volt();
        Volt v3 = socketAdapter.get120volt();

        System.out.println("Volt 1: " + v1.getVolt());
        System.out.println("Volt 2: " + v2.getVolt());
        System.out.println("Volt 3: " + v3.getVolt());
    }

    public static void testComposite() {

        designPattern.structural.composite.Shape triangle = new Triangle();
        designPattern.structural.composite.Shape circle = new Circle();

        DrawingComposite drawing = new DrawingComposite();
        drawing.add(triangle);
        drawing.add(circle);
        drawing.draw("green");
    }

    public static void testProxy() {
        CommandExecutor executor = new CommandExecutorProxy("admin", "correct");
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand("rm -rf abc.pd");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void testFlyWeight() {
        ClientDrawing clientDrawing = new ClientDrawing(500,500);
    }

    public static void testFacade() {
        // before we have a facade
        Connection mySqlConnection = MySqlHelper.getMySqlConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlPDFReport("table1", mySqlConnection);

        Connection oracleConnection = OracleHelper.getOracleConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOracleHTMLReport("table2", oracleConnection);

        // after we have a facade
        HelperFacade.generateReport(HelperFacade.DBType.ORACLE, HelperFacade.ReportType.PDF,"table1");
        HelperFacade.generateReport(HelperFacade.DBType.MYSQL, HelperFacade.ReportType.HTML,"table2");
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