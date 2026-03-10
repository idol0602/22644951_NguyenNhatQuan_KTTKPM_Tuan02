package edu.iuh.fit.Bai2.VictorianFamily;

import edu.iuh.fit.Bai2.AbstractFactory.FurnitureFactory;
import edu.iuh.fit.Bai2.AbstractProduct.Chair;
import edu.iuh.fit.Bai2.AbstractProduct.CoffeeTable;
import edu.iuh.fit.Bai2.AbstractProduct.Sofa;

public class VictorianFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
}
