package edu.iuh.fit.Bai3;

// ==================== STATE PATTERN ====================
// Interface trạng thái đơn hàng
public interface OrderState {
    void handleOrder(Order order);
    String getStateName();
}

