package edu.iuh.fit.Bai4;

// Lớp Product kết hợp cả 3 pattern
public class Product {
    private String name;
    private double basePrice;
    private TaxStrategy taxStrategy;
    private ProductComponent productComponent;

    public Product(String name, double basePrice, TaxStrategy taxStrategy, ProductComponent productComponent) {
        this.name = name;
        this.basePrice = basePrice;
        this.taxStrategy = taxStrategy;
        this.productComponent = productComponent;
    }

    public String getName() { return name; }
    public double getBasePrice() { return basePrice; }
    public TaxStrategy getTaxStrategy() { return taxStrategy; }
    public ProductComponent getProductComponent() { return productComponent; }

    public void setTaxStrategy(TaxStrategy taxStrategy) { this.taxStrategy = taxStrategy; }

    public void displayInfo() {
        System.out.println("  Sản phẩm: " + name);
        System.out.println("  Mô tả: " + productComponent.getDescription());
        System.out.println("  Giá (gồm dịch vụ bổ sung): " + String.format("%,.0f", productComponent.getCost()) + " VND");
        System.out.println("  Loại thuế: " + taxStrategy.getTaxName());
    }
}

