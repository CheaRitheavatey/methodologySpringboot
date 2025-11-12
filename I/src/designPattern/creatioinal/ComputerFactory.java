package designPattern.creatioinal;

public class ComputerFactory {
    public static Computer getComputer(String ram, String hdd, String type) {
        // check type if its pc or server
        if ("PC".equalsIgnoreCase(type)) {
            return new PC(ram, hdd);
        } else if ("Server".equalsIgnoreCase(type)) {
            return new Server(ram, hdd);
        }
        return null;
    }
}
