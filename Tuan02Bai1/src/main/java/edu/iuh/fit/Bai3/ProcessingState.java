package edu.iuh.fit.Bai3;

// Trạng thái: Đang xử lý - Đóng gói và vận chuyển
public class ProcessingState implements OrderState {
    @Override
    public void handleOrder(Order order) {
        System.out.println("[Đang xử lý] Đóng gói đơn hàng #" + order.getOrderId() + "...");
        System.out.println("  -> Sử dụng phương thức vận chuyển: ");
        order.getShippingStrategy().ship(order);
        System.out.println("  -> Đơn hàng đã được gửi đi. Chuyển sang trạng thái 'Đã giao'.");
        order.setState(new DeliveredState());
    }

    @Override
    public String getStateName() {
        return "Đang xử lý";
    }
}

