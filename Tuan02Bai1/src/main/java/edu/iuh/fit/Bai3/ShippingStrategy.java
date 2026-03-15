package edu.iuh.fit.Bai3;

// ==================== STRATEGY PATTERN ====================
// Interface chiến lược vận chuyển
public interface ShippingStrategy {
    void ship(Order order);
    String getStrategyName();
}

