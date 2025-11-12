package designPattern.creatioinal;

public class PC extends Computer{
    private String ram;
    private String hdd;

    protected PC(String ram, String hdd) {
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public String getRam() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }
}
