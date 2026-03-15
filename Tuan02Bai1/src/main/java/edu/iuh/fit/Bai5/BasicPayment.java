package edu.iuh.fit.Bai5;

// Concrete Component - Thanh toán cơ bản
public class BasicPayment implements PaymentComponent {
    private String description;
    private double cost;

    public BasicPayment(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}

