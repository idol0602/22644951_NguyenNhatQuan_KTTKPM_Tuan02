package edu.iuh.fit.Bai4;

// Chiến lược: Thuế tiêu thụ (10%)
public class ConsumptionTaxStrategy implements TaxStrategy {
    private static final double TAX_RATE = 0.10;

    @Override
    public double calculateTax(double price) {
        return price * TAX_RATE;
    }

    @Override
    public String getTaxName() {
        return "Thuế tiêu thụ (10%)";
    }
}

