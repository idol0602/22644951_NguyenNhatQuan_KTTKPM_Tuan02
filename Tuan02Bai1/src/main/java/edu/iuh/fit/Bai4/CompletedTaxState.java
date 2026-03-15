package edu.iuh.fit.Bai4;

// Trạng thái: Tính thuế hoàn tất
public class CompletedTaxState implements TaxState {
    @Override
    public void handle(TaxContext context) {
        Product p = context.getProduct();
        double tax = p.getTaxStrategy().calculateTax(p.getProductComponent().getCost());
        double total = p.getProductComponent().getCost() + tax;
        System.out.println("[Hoàn tất] Sản phẩm: " + p.getName());
        System.out.println("  -> Giá cuối cùng (gồm thuế): " + String.format("%,.0f", total) + " VND");
        System.out.println("  -> Trạng thái: ĐÃ TÍNH THUẾ XONG.");
    }

    @Override
    public String getStateName() {
        return "Hoàn tất";
    }
}

