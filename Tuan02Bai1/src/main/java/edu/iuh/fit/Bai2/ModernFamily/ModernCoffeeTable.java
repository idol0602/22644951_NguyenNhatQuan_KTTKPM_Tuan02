package edu.iuh.fit.Bai2.ModernFamily;

import edu.iuh.fit.Bai2.AbstractProduct.CoffeeTable;

public class ModernCoffeeTable implements CoffeeTable {

    @Override
    public void putCoffee() {
        System.out.println("Put coffee on modern coffee table");
    }

    @Override
    public String getSize() {
        return "Medium";
    }
}
