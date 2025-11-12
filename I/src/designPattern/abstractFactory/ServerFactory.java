package designPattern.abstractFactory;

public class ServerFactory implements ComputerAbstractFactory{
    private String ram;
    private String hdd;

    public ServerFactory(String ram, String hdd) {
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram, hdd);
    }
}
