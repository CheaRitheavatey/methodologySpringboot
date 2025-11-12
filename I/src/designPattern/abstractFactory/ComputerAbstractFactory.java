package designPattern.abstractFactory;

public interface ComputerAbstractFactory {
    // include all the method we want the subclasses/factories to implement
    public Computer createComputer();
}
