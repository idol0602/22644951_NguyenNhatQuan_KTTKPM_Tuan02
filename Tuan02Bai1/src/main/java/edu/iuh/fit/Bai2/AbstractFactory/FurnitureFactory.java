package edu.iuh.fit.Bai2.AbstractFactory;

import edu.iuh.fit.Bai2.AbstractProduct.Chair;
import edu.iuh.fit.Bai2.AbstractProduct.CoffeeTable;
import edu.iuh.fit.Bai2.AbstractProduct.Sofa;

public interface FurnitureFactory {

    Chair createChair();

    Sofa createSofa();

    CoffeeTable createCoffeeTable();
}
