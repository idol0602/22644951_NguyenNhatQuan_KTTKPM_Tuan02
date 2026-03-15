package edu.iuh.fit.Bai3;

// Trạng thái: Đã giao - Cập nhật trạng thái đã giao
public class DeliveredState implements OrderState {
    @Override
    public void handleOrder(Order order) {
        System.out.println("[Đã giao] Đơn hàng #" + order.getOrderId() + " đã được giao thành công!");
        System.out.println("  -> Cập nhật trạng thái đơn hàng: ĐÃ GIAO.");
        System.out.println("  -> Cảm ơn khách hàng " + order.getCustomerName() + " đã mua hàng!");
    }

    @Override
    public String getStateName() {
        return "Đã giao";
    }
}

