package edu.iuh.fit.Bai5;

import java.io.FileWriter;
import java.io.IOException;

/**
 * BÀI 5: Hệ thống thanh toán
 * Sử dụng Design Pattern: State, Strategy, Decorator
 *
 * - State Pattern: Quản lý trạng thái thanh toán (Chờ -> Đang xử lý -> Hoàn tất / Thất bại)
 * - Strategy Pattern: Chọn phương thức thanh toán (Thẻ tín dụng / PayPal)
 * - Decorator Pattern: Thêm tính năng bổ sung (Phí xử lý / Mã giảm giá)
 */
public class PaymentMain {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║   BÀI 5: HỆ THỐNG THANH TOÁN                       ║");
        System.out.println("║   Design Pattern: State + Strategy + Decorator      ║");
        System.out.println("╚══════════════════════════════════════════════════════╝\n");

        // ==================== THANH TOÁN 1: Thẻ tín dụng + Phí xử lý ====================
        System.out.println("========== THANH TOÁN 1: Thẻ tín dụng + Phí xử lý ==========\n");

        // Decorator: Thanh toán cơ bản + phí xử lý 2%
        PaymentComponent comp1 = new BasicPayment("Mua Laptop Dell XPS 15", 25000000);
        comp1 = new ProcessingFeeDecorator(comp1, 0.02); // Thêm phí xử lý 2%

        // Strategy: Thanh toán bằng thẻ tín dụng
        PaymentStrategy strategy1 = new CreditCardStrategy("1234567890123456", "NGUYEN VAN A");

        Payment payment1 = new Payment("DH001", strategy1, comp1);
        payment1.displayInfo();

        // State: Xử lý qua các trạng thái
        PaymentContext ctx1 = new PaymentContext(payment1);
        System.out.println("\n--- Quy trình thanh toán ---");
        ctx1.process(); // Chờ thanh toán
        System.out.println();
        ctx1.process(); // Đang xử lý
        System.out.println();
        ctx1.process(); // Hoàn tất

        // ==================== THANH TOÁN 2: PayPal + Mã giảm giá ====================
        System.out.println("\n\n========== THANH TOÁN 2: PayPal + Mã giảm giá ==========\n");

        // Decorator: Thanh toán cơ bản + mã giảm giá 15%
        PaymentComponent comp2 = new BasicPayment("Mua iPhone 15 Pro Max", 35000000);
        comp2 = new DiscountDecorator(comp2, "SALE15", 0.15); // Giảm 15%

        // Strategy: Thanh toán bằng PayPal
        PaymentStrategy strategy2 = new PayPalStrategy("tranthib@gmail.com");

        Payment payment2 = new Payment("DH002", strategy2, comp2);
        payment2.displayInfo();

        PaymentContext ctx2 = new PaymentContext(payment2);
        System.out.println("\n--- Quy trình thanh toán ---");
        ctx2.process();
        System.out.println();
        ctx2.process();
        System.out.println();
        ctx2.process();

        // ==================== THANH TOÁN 3: Thẻ tín dụng + Phí xử lý + Mã giảm giá ====================
        System.out.println("\n\n========== THANH TOÁN 3: Thẻ tín dụng + Phí xử lý + Mã giảm giá ==========\n");

        // Decorator: Thanh toán cơ bản + phí xử lý 3% + mã giảm giá 10%
        PaymentComponent comp3 = new BasicPayment("Mua Samsung Galaxy S24 Ultra", 28000000);
        comp3 = new ProcessingFeeDecorator(comp3, 0.03);          // Phí xử lý 3%
        comp3 = new DiscountDecorator(comp3, "WELCOME10", 0.10);  // Giảm 10%

        PaymentStrategy strategy3 = new CreditCardStrategy("9876543210987654", "LE VAN C");

        Payment payment3 = new Payment("DH003", strategy3, comp3);
        payment3.displayInfo();

        PaymentContext ctx3 = new PaymentContext(payment3);
        System.out.println("\n--- Quy trình thanh toán ---");
        ctx3.process();
        System.out.println();
        ctx3.process();
        System.out.println();
        ctx3.process();

        // ==================== THANH TOÁN 4: Đổi phương thức thanh toán tại runtime ====================
        System.out.println("\n\n========== THANH TOÁN 4: Thay đổi phương thức thanh toán tại runtime ==========\n");

        PaymentComponent comp4 = new BasicPayment("Mua tai nghe AirPods Pro", 6000000);
        comp4 = new ProcessingFeeDecorator(comp4, 0.02);

        Payment payment4 = new Payment("DH004", new CreditCardStrategy("1111222233334444", "PHAM VAN D"), comp4);

        System.out.println("--- Ban đầu: Thanh toán bằng thẻ tín dụng ---");
        payment4.displayInfo();

        System.out.println("\n--- Thay đổi: Chuyển sang thanh toán bằng PayPal ---");
        payment4.setPaymentStrategy(new PayPalStrategy("phamvand@gmail.com"));
        payment4.displayInfo();

        PaymentContext ctx4 = new PaymentContext(payment4);
        System.out.println("\n--- Quy trình thanh toán ---");
        ctx4.process();
        System.out.println();
        ctx4.process();
        System.out.println();
        ctx4.process();

        // ==================== GHI KẾT LUẬN VÀO FILE ====================
        writeConclusion();
    }

    private static void writeConclusion() {
        try {
            FileWriter writer = new FileWriter("src/main/resources/Bai5_Ket_Luan.txt");
            writer.write("╔══════════════════════════════════════════════════════════════════╗\n");
            writer.write("║                    BÀI 5: KẾT LUẬN                               ║\n");
            writer.write("║               HỆ THỐNG THANH TOÁN TRỰC TUYẾN                    ║\n");
            writer.write("║            Design Pattern: State + Strategy + Decorator         ║\n");
            writer.write("╚══════════════════════════════════════════════════════════════════╝\n\n");

            writer.write("1. STATE PATTERN:\n");
            writer.write("   ✓ Quản lý quy trình thanh toán qua các trạng thái rõ ràng\n");
            writer.write("   ✓ Các trạng thái: Chờ thanh toán → Đang xử lý → Hoàn tất / Thất bại\n");
            writer.write("   ✓ Mỗi trạng thái có logic xử lý riêng biệt\n");
            writer.write("   ✓ Dễ bảo trì: Mỗi trạng thái là một lớp độc lập\n");
            writer.write("   ✓ Dễ thêm trạng thái mới (Chờ phê duyệt, Bị từ chối, Hoàn tiền,...)\n");
            writer.write("   ✓ Giúp xử lý các sự cố thanh toán một cách có cấu trúc\n\n");

            writer.write("2. STRATEGY PATTERN:\n");
            writer.write("   ✓ Linh hoạt lựa chọn phương thức thanh toán\n");
            writer.write("   ✓ Hỗ trợ 2 chiến lược chính:\n");
            writer.write("     - Thẻ tín dụng (Credit Card)\n");
            writer.write("     - PayPal (Ví điện tử)\n");
            writer.write("   ✓ Có thể thay đổi phương thức thanh toán tại runtime\n");
            writer.write("   ✓ Dễ dàng mở rộng thêm phương thức (MoMo, ZaloPay, Apple Pay,...)\n");
            writer.write("   ✓ Mỗi phương thức có quy trình xác thực riêng\n");
            writer.write("   ✓ Giảm sự phụ thuộc vào một phương thức thanh toán cụ thể\n\n");

            writer.write("3. DECORATOR PATTERN:\n");
            writer.write("   ✓ Thêm tính năng bổ sung mà không thay đổi lớp thanh toán gốc\n");
            writer.write("   ✓ Hỗ trợ các tính năng:\n");
            writer.write("     - Phí xử lý (2-3%) - chi phí cho dịch vụ thanh toán\n");
            writer.write("     - Mã giảm giá (5-20%) - khuyến mại cho khách hàng\n");
            writer.write("   ✓ Có thể kết hợp nhiều decorator cùng lúc\n");
            writer.write("   ✓ Tính toán chi phí một cách rõ ràng và linh hoạt\n");
            writer.write("   ✓ Dễ thêm tính năng mới (Bảo hiểm, Hỗ trợ kỹ thuật, Thanh toán trả góp,...)\n\n");

            writer.write("KẾT LUẬN CHUNG:\n");
            writer.write("──────────────\n");
            writer.write("Hệ thống thanh toán đạt được:\n");
            writer.write("• Tính an toàn: Hỗ trợ nhiều phương thức thanh toán an toàn\n");
            writer.write("• Tính linh hoạt: Có thể thay đổi phương thức thanh toán linh hoạt\n");
            writer.write("• Tính mở rộng: Dễ thêm phương thức thanh toán và tính năng mới\n");
            writer.write("• Tính rõ ràng: Tách biệt logic thanh toán khỏi logic khác\n");
            writer.write("• Trải nghiệm người dùng tốt: Cho phép lựa chọn phương thức thanh toán yêu thích\n");
            writer.write("• Tuân thủ SOLID: Đặc biệt là Open/Closed và Liskov Substitution\n\n");

            writer.write("Công thức tính giá trị thanh toán:\n");
            writer.write("Giá thanh toán = Giá gốc + Phí xử lý - Mã giảm giá\n\n");

            writer.write("Ứng dụng thực tế:\n");
            writer.write("• Nền tảng bán hàng trực tuyến (Shopee, Lazada, Tiki,...)\n");
            writer.write("• Ứng dụng thanh toán di động\n");
            writer.write("• Nền tảng gọi xe (Grab, Be,...)\n");
            writer.write("• Dịch vụ vé máy bay, khách sạn\n");
            writer.write("• Ứng dụng quản lý chi tiêu cá nhân\n");
            writer.write("• Nền tảng mua hàng nhóm\n");
            writer.write("• Hệ thống quản lý chung cư\n");

            writer.close();
            System.out.println("\n✓ Kết luận đã được ghi vào file: src/main/resources/Bai5_Ket_Luan.txt");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}

