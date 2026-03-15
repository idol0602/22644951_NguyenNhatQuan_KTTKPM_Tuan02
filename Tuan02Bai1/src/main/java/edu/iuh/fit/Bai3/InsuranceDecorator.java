package edu.iuh.fit.Bai3;

// Concrete Decorator - Bảo hiểm đơn hàng
public class InsuranceDecorator extends OrderDecorator {
    private static final double INSURANCE_COST = 50000; // 50,000 VND

    public InsuranceDecorator(OrderComponent wrappedOrder) {
        super(wrappedOrder);
    }

    @Override
    public String getDescription() {
        return wrappedOrder.getDescription() + " + Bảo hiểm hàng hóa";
    }

    @Override
    public double getCost() {
        return wrappedOrder.getCost() + INSURANCE_COST;
    }
}

