package edu.iuh.fit.Bai5;

// Concrete Decorator - Mã giảm giá (Discount Code)
public class DiscountDecorator extends PaymentDecorator {
    private String discountCode;
    private double discountPercentage; // Giảm giá tính theo %

    public DiscountDecorator(PaymentComponent wrappedPayment, String discountCode, double discountPercentage) {
        super(wrappedPayment);
        this.discountCode = discountCode;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String getDescription() {
        return wrappedPayment.getDescription() + " + Mã giảm giá [" + discountCode + "] (-" + (discountPercentage * 100) + "%)";
    }

    @Override
    public double getCost() {
        double baseCost = wrappedPayment.getCost();
        return baseCost - (baseCost * discountPercentage);
    }
}

