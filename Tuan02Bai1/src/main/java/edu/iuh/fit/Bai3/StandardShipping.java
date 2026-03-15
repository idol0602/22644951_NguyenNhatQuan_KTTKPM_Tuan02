package edu.iuh.fit.Bai3;

// Chiến lược: Vận chuyển tiêu chuẩn
public class StandardShipping implements ShippingStrategy {
    @Override
    public void ship(Order order) {
        System.out.println("     Vận chuyển TIÊU CHUẨN (3-5 ngày) cho đơn hàng #" + order.getOrderId());
        System.out.println("     Phí vận chuyển: 30,000 VND");
    }

    @Override
    public String getStrategyName() {
        return "Vận chuyển tiêu chuẩn";
    }
}

