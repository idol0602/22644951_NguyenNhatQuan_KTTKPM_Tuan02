package edu.iuh.fit.Bai4;

// Abstract Decorator
public abstract class ProductDecorator implements ProductComponent {
    protected ProductComponent wrappedProduct;

    public ProductDecorator(ProductComponent wrappedProduct) {
        this.wrappedProduct = wrappedProduct;
    }

    @Override
    public String getDescription() {
        return wrappedProduct.getDescription();
    }

    @Override
    public double getCost() {
        return wrappedProduct.getCost();
    }
}

