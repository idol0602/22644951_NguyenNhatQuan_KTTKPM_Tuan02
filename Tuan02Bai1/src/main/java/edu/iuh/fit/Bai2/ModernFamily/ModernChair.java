package edu.iuh.fit.Bai2.ModernFamily;

import edu.iuh.fit.Bai2.AbstractProduct.Chair;

public class ModernChair implements Chair {

    @Override
    public void sitOn() {
        System.out.println("Sit on modern chair");
    }

    @Override
    public boolean hasLegs() {
        return true;
    }
}
