package edu.iuh.fit.Bai3;

// Abstract Decorator
public abstract class OrderDecorator implements OrderComponent {
    protected OrderComponent wrappedOrder;

    public OrderDecorator(OrderComponent wrappedOrder) {
        this.wrappedOrder = wrappedOrder;
    }

    @Override
    public String getDescription() {
        return wrappedOrder.getDescription();
    }

    @Override
    public double getCost() {
        return wrappedOrder.getCost();
    }
}

