package edu.iuh.fit.Bai2;

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
