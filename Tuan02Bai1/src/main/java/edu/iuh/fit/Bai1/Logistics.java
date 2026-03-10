package edu.iuh.fit.Bai1;

public abstract class Logistics {

    // Factory Method
    public abstract Transport createTransport();

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}
