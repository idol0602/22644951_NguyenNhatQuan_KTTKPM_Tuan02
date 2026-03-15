package edu.iuh.fit.Bai3;

// Concrete Component - Đơn hàng cơ bản
public class BasicOrder implements OrderComponent {
    private String description;
    private double cost;

    public BasicOrder(String description, double cost) {
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

