package edu.iuh.fit.Bai2;

public class VictorianChair implements Chair {

    @Override
    public void sitOn() {
        System.out.println("Sit on victorian chair");
    }

    @Override
    public boolean hasLegs() {
        return true;
    }
}
