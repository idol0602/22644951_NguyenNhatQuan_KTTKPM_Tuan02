package edu.iuh.fit.Bai5;

// Abstract Decorator
public abstract class PaymentDecorator implements PaymentComponent {
    protected PaymentComponent wrappedPayment;

    public PaymentDecorator(PaymentComponent wrappedPayment) {
        this.wrappedPayment = wrappedPayment;
    }

    @Override
    public String getDescription() {
        return wrappedPayment.getDescription();
    }

    @Override
    public double getCost() {
        return wrappedPayment.getCost();
    }
}

