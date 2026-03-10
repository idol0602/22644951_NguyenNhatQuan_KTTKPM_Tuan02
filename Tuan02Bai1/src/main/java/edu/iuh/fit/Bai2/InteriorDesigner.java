package edu.iuh.fit.Bai2;

public class InteriorDesigner {

    private Chair chair;
    private Sofa sofa;
    private CoffeeTable table;

    public InteriorDesigner(FurnitureFactory factory) {
        chair = factory.createChair();
        sofa = factory.createSofa();
        table = factory.createCoffeeTable();
    }

    public void decorate() {
        chair.sitOn();
        sofa.lieOn();
        table.putCoffee();
    }
}
