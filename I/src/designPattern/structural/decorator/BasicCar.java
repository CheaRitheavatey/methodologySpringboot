package designPattern.structural.decorator;

public class BasicCar implements Car{

    @Override
    public void assemble() {
        System.out.println("Assembling Car");
    }

    // additonal feature
}
