package edu.iuh.fit.Bai4;

// Chiến lược: Thuế đặc biệt cho sản phẩm xa xỉ (20%)
public class LuxuryTaxStrategy implements TaxStrategy {
    private static final double TAX_RATE = 0.20;

    @Override
    public double calculateTax(double price) {
        return price * TAX_RATE;
    }

    @Override
    public String getTaxName() {
        return "Thuế xa xỉ (20%)";
    }
}

