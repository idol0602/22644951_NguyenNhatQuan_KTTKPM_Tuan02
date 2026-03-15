package edu.iuh.fit.Bai3;

// Chiến lược: Vận chuyển nhanh
public class ExpressShipping implements ShippingStrategy {
    @Override
    public void ship(Order order) {
        System.out.println("     Vận chuyển NHANH (1-2 ngày) cho đơn hàng #" + order.getOrderId());
        System.out.println("     Phí vận chuyển: 60,000 VND");
    }

    @Override
    public String getStrategyName() {
        return "Vận chuyển nhanh";
    }
}

