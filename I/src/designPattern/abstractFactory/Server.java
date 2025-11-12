package designPattern.abstractFactory;

public class Server extends Computer{
    private String ram;
    private String hdd;

    protected Server(String ram, String hdd) {
        this.ram = ram;
        this.hdd = hdd;
    }
    @Override
    public String getRam() {
        return this.ram;
    }

    @Override
    public String getHdd() {
        return this.hdd;
    }
}
