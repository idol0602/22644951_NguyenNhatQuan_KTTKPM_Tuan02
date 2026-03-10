package edu.iuh.fit.Bai1;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by land using Truck");
    }
}