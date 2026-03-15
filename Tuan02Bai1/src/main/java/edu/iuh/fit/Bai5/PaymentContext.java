package edu.iuh.fit.Bai5;

// Lớp ngữ cảnh quản lý trạng thái thanh toán
public class PaymentContext {
    private PaymentState currentState;
    private Payment payment;

    public PaymentContext(Payment payment) {
        this.payment = payment;
        this.currentState = new PendingPaymentState();
    }

    public void setState(PaymentState state) {
        this.currentState = state;
    }

    public PaymentState getState() {
        return currentState;
    }

    public Payment getPayment() {
        return payment;
    }

    public void process() {
        currentState.handle(this);
    }
}

