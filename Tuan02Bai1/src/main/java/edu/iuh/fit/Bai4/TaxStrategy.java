package edu.iuh.fit.Bai4;

// ==================== STRATEGY PATTERN ====================
// Interface chiến lược tính thuế
public interface TaxStrategy {
    double calculateTax(double price);
    String getTaxName();
}

