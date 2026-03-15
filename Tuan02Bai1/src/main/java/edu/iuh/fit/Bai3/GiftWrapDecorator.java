package edu.iuh.fit.Bai3;

// Concrete Decorator - Gói quà tặng
public class GiftWrapDecorator extends OrderDecorator {
    private static final double GIFT_WRAP_COST = 25000; // 25,000 VND

    public GiftWrapDecorator(OrderComponent wrappedOrder) {
        super(wrappedOrder);
    }

    @Override
    public String getDescription() {
        return wrappedOrder.getDescription() + " + Gói quà tặng";
    }

    @Override
    public double getCost() {
        return wrappedOrder.getCost() + GIFT_WRAP_COST;
    }
}

