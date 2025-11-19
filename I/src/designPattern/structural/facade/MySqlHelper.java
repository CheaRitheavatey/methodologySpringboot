package designPattern.structural.facade;

import java.sql.Connection;
import java.sql.SQLException;

public class MySqlHelper {
    public static Connection getMySqlConnection() {
        // get mysql db connection using connection parameter
        return null;
    }

    // generate report as pdf
    public void generateMySqlPDFReport(String tableName, Connection connection) {
        System.out.println("generate a pdf from mysql");

    }
    // generate report as html
    public void generateMySqlHTMLReport(String tableName, Connection connection) {
        System.out.println("generate a HTML from mysql");
    }

}
