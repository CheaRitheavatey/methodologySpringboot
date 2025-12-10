import java.io.IOException;
import java.util.logging.*;

//import java.util.logging.*;
public class Logging {

    // default level: info
    // the getLogger("name of the class")
    private static Logger logger = Logger.getLogger("logging");

    public static void main(String[] args) throws IOException {
//        logger.setLevel(Level.ALL);
//
//        // appender mean console handler and file handler
//        // default formatter of consolehandler is simpleFormatter
//        ConsoleHandler consoleHandler = new ConsoleHandler();
//        consoleHandler.setFormatter(new XMLFormatter());
//
//        // default format for fileHandler is xmlFormatter
//        FileHandler fileHandler = new FileHandler("logFile.txt");
//        fileHandler.setFormatter(new SimpleFormatter());
//
//        logger.addHandler(fileHandler);
//
//        try {
//            logger.finest("Starting logging");
//            System.out.println(10/2);
//            logger.finer("Starting logging");
//        } catch (ArithmeticException e) {
//            // by using log() we can pass exception cause e ot log event
//            logger.log(Level.INFO, "Arithmetic Exception, cannot divided by 0",e);
//
//            // another way
//            logger.info("Arithmetic Exception, cannot divided by 0");
//        }

        // exercise 1
        logger.setLevel(Level.ALL);
        FileHandler fileHandler = new FileHandler("ageFile.txt");
        fileHandler.setFormatter(new SimpleFormatter());

        logger.addHandler(fileHandler);

        try {
            logger.finer("checking age...");
            checkAge(19);
            logger.fine("the age check successfully!");
        } catch (IOException ex) {
            logger.log(Level.INFO,"something went wrong", ex);
        }


    }

    // exercise 1
    // create a method to check an age and throw an exception if the age is < 18 else print you can vote
    // create a log file in a simple text format explain the process
    // it should look like
    // "checking the age"
    // the age check successfully
    // something went wrong if its not check successfully + exception info
    // log all of this to log file
    public static void checkAge(int age) throws IOException{
        if (age < 18)
            throw new IOException("Age less than 18");
        System.out.println("You can vote");
    }
}
