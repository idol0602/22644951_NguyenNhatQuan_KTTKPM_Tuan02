package edu.iuh.fit.Bai4;

// ==================== STATE PATTERN ====================
// Interface trạng thái xử lý thuế
public interface TaxState {
    void handle(TaxContext context);
    String getStateName();
}

