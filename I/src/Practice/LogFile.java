package Practice;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogFile {
    private static Logger logger = Logger.getLogger("Logging");
    public static void main(String[] args) {
        logger.setLevel(Level.ALL);
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("PracticeLogFile.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileHandler.setFormatter(new SimpleFormatter());

        logger.addHandler(fileHandler);

        try {
            for (int i = 1; i < 21; i++) {
                logger.config("You are logging: " + i);

            }

            logger.info("Loop finished successfully");
        } catch (RuntimeException e) {
            logger.log(Level.ALL, "something went wrong", e);
        }

    }
}
