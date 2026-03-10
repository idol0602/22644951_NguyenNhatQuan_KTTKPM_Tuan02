package edu.iuh.fit.Bai2.ModernFamily;

import edu.iuh.fit.Bai2.AbstractFactory.FurnitureFactory;
import edu.iuh.fit.Bai2.AbstractProduct.Chair;
import edu.iuh.fit.Bai2.AbstractProduct.CoffeeTable;
import edu.iuh.fit.Bai2.AbstractProduct.Sofa;

public class ModernFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
}
