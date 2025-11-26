package designPattern.behavorial.template;

public class WoodenHouse extends HouseTemplate{
    @Override
    public void buildPillar() {
        System.out.println("Building wooden pillar");
    }

    @Override
    public void buildWall() {
        System.out.println("Building wooden wall");
    }
}
