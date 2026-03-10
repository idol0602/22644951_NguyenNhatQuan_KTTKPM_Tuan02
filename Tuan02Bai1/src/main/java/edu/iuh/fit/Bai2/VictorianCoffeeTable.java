package edu.iuh.fit.Bai2;

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
