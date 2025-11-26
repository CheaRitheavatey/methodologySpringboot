package designPattern.behavorial.template;

public class GlassHouse extends HouseTemplate {
    @Override
    public void buildPillar() {
        System.out.println("Building glass pillar");
    }

    @Override
    public void buildWall() {
        System.out.println("Building glass wall");
    }
}
