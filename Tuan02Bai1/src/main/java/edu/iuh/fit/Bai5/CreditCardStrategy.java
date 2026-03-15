package edu.iuh.fit.Bai5;

// Chiến lược: Thanh toán bằng thẻ tín dụng
public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CreditCardStrategy(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        String maskedCard = "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("  -> Thanh toán bằng THẺ TÍN DỤNG");
        System.out.println("     Chủ thẻ: " + cardHolder);
        System.out.println("     Số thẻ: " + maskedCard);
        System.out.println("     Số tiền: " + String.format("%,.0f", amount) + " VND");
    }

    @Override
    public String getMethodName() {
        return "Thẻ tín dụng";
    }
}

