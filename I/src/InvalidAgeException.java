import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// for custom exception if we extend from runtimeexception it will NOT check meaning whatever exception
// you make you can use it without using throws or try -catch

// but if you extend from exception it WILL check . meaning u need to put the custom exception in try catch
// or throws
public class InvalidAgeException extends Exception {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = 0;

        try {
            System.out.print("Guess number: ");
            a = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        System.out.println("a: " + a);

        checkAge(20);

        // filepath
        String filePath = "\"C:\\Users\\ACER-PC\\Desktop\\system engineering.md\"";
        File f = new File(filePath);

        try {
            Scanner scanner = new Scanner(f);
            if (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            } else if (f.length() == 0) {
                throw new IllegalArgumentException("file empty");
            } else {
                throw new IllegalArgumentException("file type not supported");
            }

        } catch (FileNotFoundException e) {
            if (!f.isFile())
                throw new IncorrectFilePath("incorrect file path");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void divide(int a, int b) {
        if (b == 0) {
            ArithmeticException ae = new ArithmeticException("Top layer exception");
            ae.initCause(new IOException("cause by 0 input"));

            // we can continue the chain
            throw ae;
        } else {
            System.out.println(a/b);
        }
    }

    public InvalidAgeException() {}
    public InvalidAgeException(String message) {
        super(message);
    }

    public static void checkAge(int age) {
        try {
            if (age < 18) {
                throw new InvalidAgeException("underage");
            } else {
                System.out.println("eligible");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}

class IncorrectFilePath extends Exception {
    IncorrectFilePath(String message) {
        super(message);
    }

    IncorrectFilePath(String message, Throwable err) {
        super(message, err);
    }
}
