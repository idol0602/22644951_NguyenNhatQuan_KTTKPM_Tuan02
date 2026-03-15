package edu.iuh.fit.Bai5;

// Lớp Payment kết hợp cả 3 pattern
public class Payment {
    private String orderId;
    private PaymentStrategy paymentStrategy;
    private PaymentComponent paymentComponent;

    public Payment(String orderId, PaymentStrategy paymentStrategy, PaymentComponent paymentComponent) {
        this.orderId = orderId;
        this.paymentStrategy = paymentStrategy;
        this.paymentComponent = paymentComponent;
    }

    public String getOrderId() { return orderId; }
    public PaymentStrategy getPaymentStrategy() { return paymentStrategy; }
    public PaymentComponent getPaymentComponent() { return paymentComponent; }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentComponent(PaymentComponent paymentComponent) {
        this.paymentComponent = paymentComponent;
    }

    public void displayInfo() {
        System.out.println("  Đơn hàng: " + orderId);
        System.out.println("  Mô tả: " + paymentComponent.getDescription());
        System.out.println("  Tổng tiền: " + String.format("%,.0f", paymentComponent.getCost()) + " VND");
        System.out.println("  Phương thức thanh toán: " + paymentStrategy.getMethodName());
    }
}

