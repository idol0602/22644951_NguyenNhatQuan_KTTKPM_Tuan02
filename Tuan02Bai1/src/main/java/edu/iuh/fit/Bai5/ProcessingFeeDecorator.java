package edu.iuh.fit.Bai5;

// Concrete Decorator - Phí xử lý (Processing Fee)
public class ProcessingFeeDecorator extends PaymentDecorator {
    private double feePercentage; // Phí xử lý tính theo %

    public ProcessingFeeDecorator(PaymentComponent wrappedPayment, double feePercentage) {
        super(wrappedPayment);
        this.feePercentage = feePercentage;
    }

    @Override
    public String getDescription() {
        return wrappedPayment.getDescription() + " + Phí xử lý (" + (feePercentage * 100) + "%)";
    }

    @Override
    public double getCost() {
        double baseCost = wrappedPayment.getCost();
        return baseCost + (baseCost * feePercentage);
    }
}

