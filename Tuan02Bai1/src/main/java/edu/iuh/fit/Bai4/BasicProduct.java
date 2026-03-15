package edu.iuh.fit.Bai4;

// Concrete Component - Sản phẩm cơ bản
public class BasicProduct implements ProductComponent {
    private String description;
    private double cost;

    public BasicProduct(String description, double cost) {
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

