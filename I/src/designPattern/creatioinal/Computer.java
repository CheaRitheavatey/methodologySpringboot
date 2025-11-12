package designPattern.creatioinal;

public abstract class Computer {
    public abstract String getRam();
    public abstract String getHDD();
    
    @Override
    public String toString() {
        return "RAM: "  + this.getRam() + " HDD: " + this.getHDD();
    }
}
