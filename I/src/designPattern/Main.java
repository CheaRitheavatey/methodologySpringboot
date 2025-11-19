package designPattern;

import designPattern.structural.adapter.SocketAdapter;
import designPattern.structural.adapter.SocketAdapterImplementation;
import designPattern.structural.adapter.Volt;
import designPattern.structural.bridge.GreenColor;
import designPattern.structural.bridge.Pentagon;
import designPattern.structural.bridge.RedColor;
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

public class Main {
    public static void main(String[] args) {
        testBridge();
//        testFacade();
//        testFlyWeight();
//        testProxy();
//        testComposite();
//        testAdapter();
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
}
