package designPattern.abstractFactory;

public abstract class Computer {
    public abstract String getRam();
    public abstract String getHdd();

    @Override
    public String toString() {
        return "RAM: " + this.getRam() + " HDD: " + this.getHdd();
    }

}
