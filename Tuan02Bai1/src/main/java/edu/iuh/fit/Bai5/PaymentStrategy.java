package edu.iuh.fit.Bai5;

// ==================== STRATEGY PATTERN ====================
// Interface chiến lược thanh toán
public interface PaymentStrategy {
    void pay(double amount);
    String getMethodName();
}

