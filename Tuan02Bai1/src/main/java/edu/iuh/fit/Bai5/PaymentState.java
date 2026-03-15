package edu.iuh.fit.Bai5;

// ==================== STATE PATTERN ====================
// Interface trạng thái thanh toán
public interface PaymentState {
    void handle(PaymentContext context);
    String getStateName();
}

