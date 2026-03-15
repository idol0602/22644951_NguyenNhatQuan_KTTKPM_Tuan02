package edu.iuh.fit.Bai4;

// Concrete Decorator - Bảo hành mở rộng
public class WarrantyDecorator extends ProductDecorator {
    private static final double WARRANTY_COST = 200000; // 200,000 VND

    public WarrantyDecorator(ProductComponent wrappedProduct) {
        super(wrappedProduct);
    }

    @Override
    public String getDescription() {
        return wrappedProduct.getDescription() + " + Bảo hành mở rộng 2 năm";
    }

    @Override
    public double getCost() {
        return wrappedProduct.getCost() + WARRANTY_COST;
    }
}

