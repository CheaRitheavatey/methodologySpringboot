package designPattern.abstractFactory;

public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory computerAbstractFactory) {
        return computerAbstractFactory.createComputer();
    }


}
