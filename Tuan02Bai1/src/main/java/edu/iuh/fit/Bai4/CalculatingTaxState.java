package edu.iuh.fit.Bai4;

// Trạng thái: Đang tính thuế
public class CalculatingTaxState implements TaxState {
    @Override
    public void handle(TaxContext context) {
        Product p = context.getProduct();
        System.out.println("[Đang tính thuế] Áp dụng chiến lược thuế cho sản phẩm: " + p.getName());

        // Sử dụng Strategy Pattern để tính thuế
        double tax = p.getTaxStrategy().calculateTax(p.getProductComponent().getCost());
        System.out.println("  -> Thuế phải nộp: " + String.format("%,.0f", tax) + " VND");
        System.out.println("  -> Tổng giá sau thuế: " + String.format("%,.0f", p.getProductComponent().getCost() + tax) + " VND");
        System.out.println("  -> Tính thuế hoàn tất.");
        context.setState(new CompletedTaxState());
    }

    @Override
    public String getStateName() {
        return "Đang tính thuế";
    }
}

