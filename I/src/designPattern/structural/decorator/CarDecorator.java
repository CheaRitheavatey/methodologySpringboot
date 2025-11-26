package designPattern.structural.decorator;

// use as an instance to other obj aka basic car
public class CarDecorator implements Car{
    private Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }
    @Override
    public void assemble() {
        this.car.assemble();
        System.out.println("Car assembled");
    }
}
