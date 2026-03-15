package edu.iuh.fit.Bai4;

import java.io.FileWriter;
import java.io.IOException;

/**
 * BÀI 4: Hệ thống tính toán thuế cho sản phẩm
 * Sử dụng Design Pattern: State, Strategy, Decorator
 *
 * - State Pattern: Quản lý trạng thái quy trình tính thuế (Chờ -> Đang tính -> Hoàn tất)
 * - Strategy Pattern: Chọn loại thuế (Tiêu thụ / VAT / Xa xỉ)
 * - Decorator Pattern: Thêm dịch vụ bổ sung (Bao bì cao cấp / Bảo hành mở rộng)
 */
public class TaxMain {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║   BÀI 4: HỆ THỐNG TÍNH TOÁN THUẾ SẢN PHẨM        ║");
        System.out.println("║   Design Pattern: State + Strategy + Decorator      ║");
        System.out.println("╚═══════════════════════════════════════════��══════════╝\n");

        // ==================== SẢN PHẨM 1: Thuế tiêu thụ ====================
        System.out.println("========== SẢN PHẨM 1: Gạo (Thuế tiêu thụ 10%) ==========\n");

        ProductComponent comp1 = new BasicProduct("Gạo ST25 - 5kg", 150000);
        comp1 = new PremiumPackagingDecorator(comp1); // Thêm bao bì cao cấp

        Product product1 = new Product("Gạo ST25", 150000, new ConsumptionTaxStrategy(), comp1);
        product1.displayInfo();

        TaxContext ctx1 = new TaxContext(product1);
        System.out.println("\n--- Quy trình tính thuế ---");
        ctx1.process(); // Chờ tính thuế
        System.out.println();
        ctx1.process(); // Đang tính thuế
        System.out.println();
        ctx1.process(); // Hoàn tất

        // ==================== SẢN PHẨM 2: Thuế VAT ====================
        System.out.println("\n\n========== SẢN PHẨM 2: Laptop (Thuế VAT 8%) ==========\n");

        ProductComponent comp2 = new BasicProduct("Laptop Dell Inspiron 15", 18000000);
        comp2 = new WarrantyDecorator(comp2);          // Thêm bảo hành
        comp2 = new PremiumPackagingDecorator(comp2);   // Thêm bao bì

        Product product2 = new Product("Laptop Dell", 18000000, new VATStrategy(), comp2);
        product2.displayInfo();

        TaxContext ctx2 = new TaxContext(product2);
        System.out.println("\n--- Quy trình tính thuế ---");
        ctx2.process();
        System.out.println();
        ctx2.process();
        System.out.println();
        ctx2.process();

        // ==================== SẢN PHẨM 3: Thuế xa xỉ ====================
        System.out.println("\n\n========== SẢN PHẨM 3: Túi xách Gucci (Thuế xa xỉ 20%) ==========\n");

        ProductComponent comp3 = new BasicProduct("Túi xách Gucci Dionysus", 50000000);
        comp3 = new PremiumPackagingDecorator(comp3);
        comp3 = new WarrantyDecorator(comp3);

        Product product3 = new Product("Túi Gucci", 50000000, new LuxuryTaxStrategy(), comp3);
        product3.displayInfo();

        TaxContext ctx3 = new TaxContext(product3);
        System.out.println("\n--- Quy trình tính thuế ---");
        ctx3.process();
        System.out.println();
        ctx3.process();
        System.out.println();
        ctx3.process();

        // ==================== SẢN PHẨM 4: Thay đổi Strategy tại runtime ====================
        System.out.println("\n\n========== SẢN PHẨM 4: Rượu vang (Đổi thuế tại runtime) ==========\n");

        ProductComponent comp4 = new BasicProduct("Rượu vang Pháp Bordeaux", 3000000);

        Product product4 = new Product("Rượu vang Pháp", 3000000, new VATStrategy(), comp4);
        System.out.println("--- Ban đầu: Áp dụng thuế VAT ---");
        product4.displayInfo();
        double taxVAT = product4.getTaxStrategy().calculateTax(comp4.getCost());
        System.out.println("  Thuế: " + String.format("%,.0f", taxVAT) + " VND");

        System.out.println("\n--- Thay đổi: Áp dụng thuế xa xỉ (rượu là hàng xa xỉ) ---");
        product4.setTaxStrategy(new LuxuryTaxStrategy());
        product4.displayInfo();
        // ==================== GHI KẾT LUẬN VÀO FILE ====================
        writeConclusion();
    }

    private static void writeConclusion() {
        try {
            FileWriter writer = new FileWriter("src/main/resources/Bai4_Ket_Luan.txt");
            writer.write("╔══════════════════════════════════════════════════════════════════╗\n");
            writer.write("║                    BÀI 4: KẾT LUẬN                               ║\n");
            writer.write("║         HỆ THỐNG TÍNH TOÁN THUẾ SẢN PHẨM                        ║\n");
            writer.write("║            Design Pattern: State + Strategy + Decorator         ║\n");
            writer.write("╚══════════════════════════════════════════════════════════════════╝\n\n");

            writer.write("1. STATE PATTERN:\n");
            writer.write("   ✓ Quản lý quy trình tính thuế qua các trạng thái rõ ràng\n");
            writer.write("   ✓ Các trạng thái: Chờ tính thuế → Đang tính → Hoàn tất\n");
            writer.write("   ✓ Mỗi trạng thái có logic xử lý riêng biệt\n");
            writer.write("   ✓ Dễ bảo trì: Mỗi trạng thái là một lớp riêng\n");
            writer.write("   ✓ Dễ thêm trạng thái mới (Lỗi, Từ chối, Chờ phê duyệt,...)\n\n");

            writer.write("2. STRATEGY PATTERN:\n");
            writer.write("   ✓ Linh hoạt lựa chọn loại thuế cho sản phẩm\n");
            writer.write("   ✓ Hỗ trợ 3 chiến lược:\n");
            writer.write("     - Thuế tiêu thụ (10%) - cho hàng hóa thông thường\n");
            writer.write("     - Thuế VAT (8%) - cho sản phẩm điện tử\n");
            writer.write("     - Thuế xa xỉ (20%) - cho hàng cao cấp\n");
            writer.write("   ✓ Có thể thay đổi chiến lược thuế tại runtime\n");
            writer.write("   ✓ Dễ dàng thêm loại thuế mới (Thuế khí thải, Thuế bảo vệ môi trường,...)\n");
            writer.write("   ✓ Tính toán thuế một cách chính xác và rõ ràng\n\n");

            writer.write("3. DECORATOR PATTERN:\n");
            writer.write("   ✓ Thêm dịch vụ bổ sung mà không thay đổi lớp sản phẩm gốc\n");
            writer.write("   ✓ Hỗ trợ các dịch vụ:\n");
            writer.write("     - Bao bì cao cấp (tăng giá)\n");
            writer.write("     - Bảo hành mở rộng (tăng giá)\n");
            writer.write("   ✓ Có thể kết hợp nhiều decorator cùng lúc\n");
            writer.write("   ✓ Chi phí dịch vụ được cộng dồn vào giá cuối cùng\n");
            writer.write("   ✓ Dễ thêm dịch vụ mới (Gửi hàng, Bảo bì sinh thái,...)\n\n");

            writer.write("KẾT LUẬN CHUNG:\n");
            writer.write("──────────────\n");
            writer.write("Hệ thống tính thuế sản phẩm đạt được:\n");
            writer.write("• Tính chính xác cao: Các thuế được tính đúng theo chiến lược\n");
            writer.write("• Linh hoạt: Có thể thay đổi loại thuế tùy theo sản phẩm\n");
            writer.write("• Dễ mở rộng: Có thể thêm loại thuế mới một cách dễ dàng\n");
            writer.write("• Tính rõ ràng: Logic tính thuế được tách biệt khỏi logic khác\n");
            writer.write("• Tuân thủ OCP: Mở rộng nhưng không sửa đổi code cũ\n\n");

            writer.write("Công thức tính giá cuối:\n");
            writer.write("Giá cuối = (Giá gốc + Chi phí dịch vụ) + Thuế\n\n");

            writer.write("Ứng dụng thực tế:\n");
            writer.write("• Hệ thống tính hóa đơn (Hóa đơn điện tử, Cơ quan thuế,...)\n");
            writer.write("• Nền tảng bán hàng trực tuyến\n");
            writer.write("• Phần mềm kế toán doanh nghiệp\n");
            writer.write("• Hệ thống quản lý thuế\n");
            writer.write("• Công cụ tính toán giá sản phẩm\n");

            writer.close();
            System.out.println("\n✓ Kết luận đã được ghi vào file: src/main/resources/Bai4_Ket_Luan.txt");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
        System.out.println("║      mà không thay đổi lớp sản phẩm gốc.                       ║");
        System.out.println("║    - Chi phí dịch vụ được cộng dồn vào giá sản phẩm.            ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }
}

