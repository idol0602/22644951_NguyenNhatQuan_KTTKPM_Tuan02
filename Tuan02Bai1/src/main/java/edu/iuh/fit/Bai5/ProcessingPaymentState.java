package edu.iuh.fit.Bai5;

// Trạng thái: Đang xử lý thanh toán
public class ProcessingPaymentState implements PaymentState {
    @Override
    public void handle(PaymentContext context) {
        Payment p = context.getPayment();
        System.out.println("[Đang xử lý] Xử lý thanh toán cho đơn hàng: " + p.getOrderId());

        // Sử dụng Strategy Pattern để thanh toán
        p.getPaymentStrategy().pay(p.getPaymentComponent().getCost());

        System.out.println("  -> Thanh toán thành công!");
        context.setState(new CompletedPaymentState());
    }

    @Override
    public String getStateName() {
        return "Đang xử lý";
    }
}

