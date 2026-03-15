package edu.iuh.fit.Bai3;

// Trạng thái: Hủy - Hủy đơn hàng và hoàn tiền
public class CancelledState implements OrderState {
    @Override
    public void handleOrder(Order order) {
        System.out.println("[Hủy] Đơn hàng #" + order.getOrderId() + " đã bị hủy!");
        System.out.println("  -> Hoàn tiền " + String.format("%,.0f", order.getTotalAmount()) + " VND cho khách hàng " + order.getCustomerName() + ".");
        System.out.println("  -> Quá trình hoàn tiền đã hoàn tất.");
    }

    @Override
    public String getStateName() {
        return "Đã hủy";
    }
}

