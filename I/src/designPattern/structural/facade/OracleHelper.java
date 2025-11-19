package designPattern.structural.facade;

import java.sql.Connection;
import java.sql.SQLException;

public class OracleHelper {

    public static Connection getOracleConnection() {
        // get mysql db connection using connection parameter
        return null;
    }

    // generate report as pdf
    public void generateOraclePDFReport(String tableName, Connection connection)  {
        System.out.println("generate a pdf from oracle");

    }
    // generate report as html
    public void generateOracleHTMLReport(String tableName, Connection connection) {
        System.out.println("generate a HTML from oracle");
    }


}
