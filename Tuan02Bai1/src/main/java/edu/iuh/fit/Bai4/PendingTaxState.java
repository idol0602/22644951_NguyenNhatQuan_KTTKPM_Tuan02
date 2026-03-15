package edu.iuh.fit.Bai4;

// Trạng thái: Chờ tính thuế
public class PendingTaxState implements TaxState {
    @Override
    public void handle(TaxContext context) {
        Product p = context.getProduct();
        System.out.println("[Chờ tính thuế] Sản phẩm: " + p.getName());
        System.out.println("  -> Giá gốc: " + String.format("%,.0f", p.getBasePrice()) + " VND");
        System.out.println("  -> Bắt đầu tính thuế...");
        context.setState(new CalculatingTaxState());
    }

    @Override
    public String getStateName() {
        return "Chờ tính thuế";
    }
}

