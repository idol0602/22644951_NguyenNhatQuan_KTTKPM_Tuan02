package edu.iuh.fit.Bai2.VictorianFamily;

import edu.iuh.fit.Bai2.AbstractProduct.Chair;

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
