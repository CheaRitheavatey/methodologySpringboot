import Practice.InvalidStudentException;
import Practice.Student;
import designPattern.abstractFactory.PCFactory;
import designPattern.abstractFactory.ServerFactory;
import designPattern.behavorial.chainnotresponsible.ATMDispenseChain;
import designPattern.behavorial.chainnotresponsible.Currency;
import designPattern.behavorial.mediator.*;
import designPattern.behavorial.template.GlassHouse;
import designPattern.behavorial.template.WoodenHouse;
import designPattern.creatioinal.Computer;
import designPattern.creatioinal.ComputerFactory;
import designPattern.prototype.Employee;
import designPattern.singleton.Singleton;
import designPattern.structural.adapter.SocketAdapter;
import designPattern.structural.adapter.SocketAdapterImplementation;
import designPattern.structural.adapter.Volt;
import designPattern.structural.bridge.GreenColor;
import designPattern.structural.bridge.Pentagon;
import designPattern.structural.bridge.RedColor;
import designPattern.structural.composite.Circle;
import designPattern.structural.composite.DrawingComposite;
import designPattern.structural.composite.Triangle;
import designPattern.structural.decorator.BasicCar;
import designPattern.structural.decorator.Car;
import designPattern.structural.decorator.LuxuryCar;
import designPattern.structural.decorator.SportCar;
import designPattern.structural.facade.HelperFacade;
import designPattern.structural.facade.MySqlHelper;
import designPattern.structural.facade.OracleHelper;
import designPattern.structural.flyweight.ClientDrawing;
import designPattern.structural.proxy.CommandExecutor;
import designPattern.structural.proxy.CommandExecutorProxy;


import java.sql.Connection;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
//        home practice
        testStudentBuilderPractice();

//        testChainotResponsibility();
//        testMediator();
//        testTemplate();
//        testDecorator();

//        testBridge();
//        testFacade();
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
        designPattern.builder.Computer c = new designPattern.builder.Computer.ComputerBuilder("10 GB", "128 GB")
                .setGraphiccardEnable(true)
                .build();

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

    public static void testBridge() {
        designPattern.structural.bridge.Shape triangle = new designPattern.structural.bridge.Triangle(new RedColor());
        designPattern.structural.bridge.Shape pentagon = new Pentagon(new GreenColor());

        triangle.applyColor();
        pentagon.applyColor();

    }
    public static void testDecorator() {
        Car c = new BasicCar();
        c.assemble(); // this is the basic car
        System.out.println("----------------------");

        Car sportCar = new SportCar(new BasicCar());
        sportCar.assemble(); // this is the sport car feature
        System.out.println("----------------------");

        Car luxuryCar = new LuxuryCar(new BasicCar());
        luxuryCar.assemble();
    }

    public static void testTemplate() {
        WoodenHouse woodenHouse = new WoodenHouse();
        woodenHouse.buildHouse();
        System.out.println("----------------------");

        GlassHouse glassHouse = new GlassHouse();
        glassHouse.buildHouse();
    }

    public static void testMediator() {
        ChatMediator mediator = new ChatMediatorImplementation();
        User u1 = new UserImplementation(mediator, "Joe");
        User u2 = new UserImplementation(mediator, "Sarah");
        User u3 = new UserImplementation(mediator, "James");

        mediator.addUser(u1);
        mediator.addUser(u2);
        mediator.addUser(u3);

        u1.send("hi this is joe, how are you doing?");
        u2.send("hi joe, its sarah, im doing good");
    }

    public static void testChainotResponsibility() {
        Scanner scanner = new Scanner(System.in);

        ATMDispenseChain atm = new ATMDispenseChain();
        int amount = 1;
        boolean notAccept = true;
        while (notAccept) {
            if (amount % 10 != 0 || amount == 0) {
                System.out.println("amount should be multiple of 10 \nEnter amount to dispences");
                amount = scanner.nextInt();
            } else {
                notAccept = false;
            }

        }
            atm.d1.dispenseCurrency(new Currency(amount));

    }

    public static void testStudentBuilderPractice() {
        try {
            Student student = new Student.StudentBuilder()
                    .setName("Alice")
                    .setEmail("alice@exampple.com")
                    .setMajor("CS")
                    .build();

            System.out.println(student.getAge());
            System.out.println(student.getName());
            System.out.println(student.getEmail());
            System.out.println(student.getMajor());
        } catch (InvalidStudentException e) {
            System.out.println(e.getMessage());
        }
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