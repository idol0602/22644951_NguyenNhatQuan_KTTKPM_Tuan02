package edu.iuh.fit.Bai2;

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
