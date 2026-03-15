package edu.iuh.fit.Bai3;

// Lớp Order - Đơn hàng chính, kết hợp State + Strategy + Decorator
public class Order {
    private String orderId;
    private String customerName;
    private double totalAmount;
    private OrderState state;
    private ShippingStrategy shippingStrategy;
    private OrderComponent orderComponent;

    public Order(String orderId, String customerName, OrderComponent orderComponent) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderComponent = orderComponent;
        this.totalAmount = orderComponent.getCost();
        this.state = new NewState(); // Trạng thái ban đầu: Mới tạo
        this.shippingStrategy = new StandardShipping(); // Mặc định: vận chuyển tiêu chuẩn
    }

    // Xử lý đơn hàng theo trạng thái hiện tại (State Pattern)
    public void processOrder() {
        state.handleOrder(this);
    }

    // Hủy đơn hàng
    public void cancelOrder() {
        System.out.println("\n--- YÊU CẦU HỦY ĐƠN HÀNG ---");
        this.state = new CancelledState();
        state.handleOrder(this);
    }

    // Hiển thị thông tin đơn hàng (Decorator Pattern)
    public void displayOrderDetails() {
        System.out.println("=== CHI TIẾT ĐƠN HÀNG #" + orderId + " ===");
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Mô tả: " + orderComponent.getDescription());
        System.out.println("Tổng chi phí: " + String.format("%,.0f", orderComponent.getCost()) + " VND");
        System.out.println("Trạng thái: " + state.getStateName());
        System.out.println("Phương thức vận chuyển: " + shippingStrategy.getStrategyName());
        System.out.println("================================");
    }

    // Getters & Setters
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalAmount() { return totalAmount; }
    public OrderState getState() { return state; }
    public ShippingStrategy getShippingStrategy() { return shippingStrategy; }
    public OrderComponent getOrderComponent() { return orderComponent; }

    public void setState(OrderState state) { this.state = state; }
    public void setShippingStrategy(ShippingStrategy shippingStrategy) { this.shippingStrategy = shippingStrategy; }
}

