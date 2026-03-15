package edu.iuh.fit.Bai5;

// Chiến lược: Thanh toán bằng PayPal
public class PayPalStrategy implements PaymentStrategy {
    private String email;

    public PayPalStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("  -> Thanh toán bằng PAYPAL");
        System.out.println("     Email: " + email);
        System.out.println("     Số tiền: " + String.format("%,.0f", amount) + " VND");
    }

    @Override
    public String getMethodName() {
        return "PayPal (" + email + ")";
    }
}

