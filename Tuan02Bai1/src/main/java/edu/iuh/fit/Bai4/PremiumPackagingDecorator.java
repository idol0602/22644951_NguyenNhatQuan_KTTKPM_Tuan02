package edu.iuh.fit.Bai4;

// Concrete Decorator - Bao bì cao cấp
public class PremiumPackagingDecorator extends ProductDecorator {
    private static final double PACKAGING_COST = 50000; // 50,000 VND

    public PremiumPackagingDecorator(ProductComponent wrappedProduct) {
        super(wrappedProduct);
    }

    @Override
    public String getDescription() {
        return wrappedProduct.getDescription() + " + Bao bì cao cấp";
    }

    @Override
    public double getCost() {
        return wrappedProduct.getCost() + PACKAGING_COST;
    }
}

