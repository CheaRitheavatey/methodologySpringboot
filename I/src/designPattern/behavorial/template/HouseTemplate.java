package designPattern.behavorial.template;

public abstract class HouseTemplate {
    // template method, define the order fr serveral step
    public final void buildHouse() {
        // build house step by step
        buildFoundation();
        buildPillar();
        buildWall();
        buildWindow();

        System.out.println("House is built");
    }

    private void buildWindow() {
        System.out.println("Building glass window");
    }
    private void buildFoundation() {
        System.out.println("Building foundation with cement and iron rods");
    }

    // need to be implemented by subclass or need customization
    protected abstract void buildPillar();
    protected abstract void buildWall();
}
