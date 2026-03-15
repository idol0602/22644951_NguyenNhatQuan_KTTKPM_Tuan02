package edu.iuh.fit.Bai4;

// Chiến lược: Thuế giá trị gia tăng - VAT (8%)
public class VATStrategy implements TaxStrategy {
    private static final double TAX_RATE = 0.08;

    @Override
    public double calculateTax(double price) {
        return price * TAX_RATE;
    }

    @Override
    public String getTaxName() {
        return "Thuế VAT (8%)";
    }
}

