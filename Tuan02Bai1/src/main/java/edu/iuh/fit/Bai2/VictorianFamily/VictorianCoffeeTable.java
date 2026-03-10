package edu.iuh.fit.Bai2.VictorianFamily;

import edu.iuh.fit.Bai2.AbstractProduct.CoffeeTable;

public class VictorianCoffeeTable implements CoffeeTable {

    @Override
    public void putCoffee() {
        System.out.println("Put coffee on victorian coffee table");
    }

    @Override
    public String getSize() {
        return "Large";
    }
}
