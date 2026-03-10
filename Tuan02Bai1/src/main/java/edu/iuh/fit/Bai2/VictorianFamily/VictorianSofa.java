package edu.iuh.fit.Bai2.VictorianFamily;

import edu.iuh.fit.Bai2.AbstractProduct.Sofa;

public class VictorianSofa implements Sofa {

    @Override
    public void lieOn() {
        System.out.println("Lie on victorian sofa");
    }

    @Override
    public boolean isComfortable() {
        return true;
    }
}
