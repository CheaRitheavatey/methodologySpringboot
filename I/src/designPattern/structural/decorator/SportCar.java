package designPattern.structural.decorator;

public class SportCar extends CarDecorator{
    public SportCar(Car car) {
        super(car);
    }

    public void assemble() {
        super.assemble();
        System.out.println("adding feature of a sport car");
    }
}
