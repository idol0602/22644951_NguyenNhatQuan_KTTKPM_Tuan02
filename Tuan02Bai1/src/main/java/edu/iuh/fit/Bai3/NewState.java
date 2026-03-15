package edu.iuh.fit.Bai3;

// Trạng thái: Mới tạo - Kiểm tra thông tin đơn hàng
public class NewState implements OrderState {
    @Override
    public void handleOrder(Order order) {
        System.out.println("[Mới tạo] Đang kiểm tra thông tin đơn hàng #" + order.getOrderId() + "...");
        System.out.println("  -> Tên khách hàng: " + order.getCustomerName());
        System.out.println("  -> Tổng tiền: " + String.format("%,.0f", order.getTotalAmount()) + " VND");
        System.out.println("  -> Thông tin hợp lệ. Chuyển sang trạng thái 'Đang xử lý'.");
        order.setState(new ProcessingState());
    }

    @Override
    public String getStateName() {
        return "Mới tạo";
    }
}

