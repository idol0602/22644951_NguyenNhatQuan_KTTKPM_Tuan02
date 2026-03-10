package edu.iuh.fit.Bai2;

import edu.iuh.fit.Bai2.AbstractFactory.FurnitureFactory;
import edu.iuh.fit.Bai2.AbstractProduct.Chair;
import edu.iuh.fit.Bai2.AbstractProduct.CoffeeTable;
import edu.iuh.fit.Bai2.AbstractProduct.Sofa;

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
