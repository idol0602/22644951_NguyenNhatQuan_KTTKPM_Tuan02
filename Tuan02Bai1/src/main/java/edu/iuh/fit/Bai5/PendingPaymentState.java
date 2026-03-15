package edu.iuh.fit.Bai5;

// Trạng thái: Chờ thanh toán
public class PendingPaymentState implements PaymentState {
    @Override
    public void handle(PaymentContext context) {
        Payment p = context.getPayment();
        System.out.println("[Chờ thanh toán] Đơn hàng: " + p.getOrderId());
        System.out.println("  -> Số tiền cần thanh toán: " + String.format("%,.0f", p.getPaymentComponent().getCost()) + " VND");
        System.out.println("  -> Phương thức: " + p.getPaymentStrategy().getMethodName());
        System.out.println("  -> Đang khởi tạo thanh toán...");
        context.setState(new ProcessingPaymentState());
    }

    @Override
    public String getStateName() {
        return "Chờ thanh toán";
    }
}

