package edu.iuh.fit.Bai4;

// Lớp ngữ cảnh quản lý trạng thái tính thuế
public class TaxContext {
    private TaxState currentState;
    private Product product;

    public TaxContext(Product product) {
        this.product = product;
        this.currentState = new PendingTaxState(); // Mặc định: Chờ tính thuế
    }

    public void setState(TaxState state) {
        this.currentState = state;
    }

    public TaxState getState() {
        return currentState;
    }

    public Product getProduct() {
        return product;
    }

    public void process() {
        currentState.handle(this);
    }
}

