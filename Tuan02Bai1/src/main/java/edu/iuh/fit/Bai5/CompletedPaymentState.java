package edu.iuh.fit.Bai5;

// Trạng thái: Thanh toán hoàn tất
public class CompletedPaymentState implements PaymentState {
    @Override
    public void handle(PaymentContext context) {
        Payment p = context.getPayment();
        System.out.println("[Hoàn tất] Đơn hàng " + p.getOrderId() + " đã thanh toán thành công!");
        System.out.println("  -> Tổng số tiền đã thanh toán: " + String.format("%,.0f", p.getPaymentComponent().getCost()) + " VND");
        System.out.println("  -> Trạng thái: HOÀN TẤT. Cảm ơn quý khách!");
    }

    @Override
    public String getStateName() {
        return "Hoàn tất";
    }
}

