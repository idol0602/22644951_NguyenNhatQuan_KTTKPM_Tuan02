package edu.iuh.fit.Bai5;

// Trạng thái: Thanh toán thất bại
public class FailedPaymentState implements PaymentState {
    @Override
    public void handle(PaymentContext context) {
        Payment p = context.getPayment();
        System.out.println("[Thất bại] Thanh toán đơn hàng " + p.getOrderId() + " thất bại!");
        System.out.println("  -> Vui lòng kiểm tra lại thông tin thanh toán.");
        System.out.println("  -> Trạng thái: THẤT BẠI.");
    }

    @Override
    public String getStateName() {
        return "Thất bại";
    }
}

