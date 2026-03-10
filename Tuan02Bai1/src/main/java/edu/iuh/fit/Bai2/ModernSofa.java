package edu.iuh.fit.Bai2;

public class ModernSofa implements Sofa {

    @Override
    public void lieOn() {
        System.out.println("Lie on modern sofa");
    }

    @Override
    public boolean isComfortable() {
        return true;
    }
}
