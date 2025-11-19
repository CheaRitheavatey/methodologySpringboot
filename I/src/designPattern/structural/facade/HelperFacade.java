package designPattern.structural.facade;

import java.sql.Connection;
import java.sql.DriverManager;

public class HelperFacade {
    public static void generateReport(DBType dbType, ReportType reportType, String tableName ) {
        Connection connection = null;

        switch (dbType) {
            case MYSQL:
                connection = MySqlHelper.getMySqlConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();

                switch (reportType) {
                    case HTML:
                        mySqlHelper.generateMySqlHTMLReport(tableName,connection);
                        break;
                    case PDF:
                        mySqlHelper.generateMySqlPDFReport(tableName,connection);
                }
                break;

            case ORACLE:
                connection = OracleHelper.getOracleConnection();
                OracleHelper oracleHelper = new OracleHelper();

                switch (reportType) {
                    case HTML:
                        oracleHelper.generateOracleHTMLReport(tableName,connection);
                        break;
                    case PDF:
                        oracleHelper.generateOraclePDFReport(tableName,connection);
                        break;
                }

                break;
        }



    }

    public static enum DBType {
        MYSQL,
        ORACLE

    }

    public static  enum ReportType {
        HTML,
        PDF

    }

}

