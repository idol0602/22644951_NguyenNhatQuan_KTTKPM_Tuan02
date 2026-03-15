package edu.iuh.fit.Bai3;

import java.io.FileWriter;
import java.io.IOException;

/**
 * BÀI 3: Hệ thống quản lý đơn hàng
 * Sử dụng Design Pattern: State, Strategy, Decorator
 *
 * - State Pattern: Quản lý trạng thái đơn hàng (Mới tạo -> Đang xử lý -> Đã giao / Hủy)
 * - Strategy Pattern: Chọn phương thức vận chuyển (Tiêu chuẩn / Nhanh)
 * - Decorator Pattern: Thêm dịch vụ bổ sung (Gói quà, Bảo hiểm)
 */
public class OrderMain {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║   BÀI 3: HỆ THỐNG QUẢN LÝ ĐƠN HÀNG               ║");
        System.out.println("║   Design Pattern: State + Strategy + Decorator      ║");
        System.out.println("╚══════════════════════════════════════════════════════╝\n");

        // ==================== ĐƠN HÀNG 1 ====================
        System.out.println("========== ĐƠN HÀNG 1: Vận chuyển nhanh + Gói quà + Bảo hiểm ==========\n");

        // Decorator Pattern: Tạo đơn hàng cơ bản rồi thêm dịch vụ
        OrderComponent orderComponent1 = new BasicOrder("Laptop Dell XPS 15", 25000000);
        orderComponent1 = new GiftWrapDecorator(orderComponent1);    // Thêm gói quà
        orderComponent1 = new InsuranceDecorator(orderComponent1);   // Thêm bảo hiểm

        Order order1 = new Order("DH001", "Nguyễn Văn A", orderComponent1);

        // Strategy Pattern: Chọn vận chuyển nhanh
        order1.setShippingStrategy(new ExpressShipping());

        // Hiển thị chi tiết đơn hàng
        order1.displayOrderDetails();

        // State Pattern: Xử lý qua các trạng thái
        System.out.println("\n--- Bước 1: Xử lý trạng thái 'Mới tạo' ---");
        order1.processOrder(); // Mới tạo -> Đang xử lý

        System.out.println("\n--- Bước 2: Xử lý trạng thái 'Đang xử lý' ---");
        order1.processOrder(); // Đang xử lý -> Đã giao

        System.out.println("\n--- Bước 3: Xử lý trạng thái 'Đã giao' ---");
        order1.processOrder(); // Đã giao -> Thông báo giao thành công

        // ==================== ĐƠN HÀNG 2 ====================
        System.out.println("\n\n========== ĐƠN HÀNG 2: Vận chuyển tiêu chuẩn + Bị hủy ==========\n");

        // Decorator Pattern: Đơn hàng cơ bản không thêm dịch vụ
        OrderComponent orderComponent2 = new BasicOrder("Điện thoại iPhone 15 Pro", 30000000);

        Order order2 = new Order("DH002", "Trần Thị B", orderComponent2);
        // Mặc định: vận chuyển tiêu chuẩn

        order2.displayOrderDetails();

        System.out.println("\n--- Bước 1: Xử lý trạng thái 'Mới tạo' ---");
        order2.processOrder(); // Mới tạo -> Đang xử lý

        // Hủy đơn hàng
        order2.cancelOrder(); // -> Hủy và hoàn tiền

        // ==================== ĐƠN HÀNG 3 ====================
        System.out.println("\n\n========== ĐƠN HÀNG 3: Nhiều dịch vụ bổ sung ==========\n");

        // Decorator Pattern: Thêm cả gói quà
        OrderComponent orderComponent3 = new BasicOrder("Tai nghe Sony WH-1000XM5", 8000000);
        orderComponent3 = new GiftWrapDecorator(orderComponent3);

        Order order3 = new Order("DH003", "Lê Văn C", orderComponent3);
        order3.setShippingStrategy(new ExpressShipping());

        order3.displayOrderDetails();

        System.out.println("\n--- Xử lý toàn bộ quy trình ---");
        order3.processOrder(); // Mới tạo -> Đang xử lý
        System.out.println();
        order3.processOrder(); // Đang xử lý -> Đã giao
        // ==================== GHI KẾT LUẬN VÀO FILE ====================
        writeConclusion();
    }

    private static void writeConclusion() {
        try {
            FileWriter writer = new FileWriter("src/main/resources/Bai3_Ket_Luan.txt");
            writer.write("╔══════════════════════════════════════════════════════════════════╗\n");
            writer.write("║                    BÀI 3: KẾT LUẬN                               ║\n");
            writer.write("║              HỆ THỐNG QUẢN LÝ ĐƠN HÀNG                          ║\n");
            writer.write("║            Design Pattern: State + Strategy + Decorator         ║\n");
            writer.write("╚══════════════════════════════════════════════════════════════════╝\n\n");

            writer.write("1. STATE PATTERN:\n");
            writer.write("   ✓ Quản lý trạng thái đơn hàng một cách linh hoạt\n");
            writer.write("   ✓ Các trạng thái: Mới tạo → Đang xử lý → Đã giao / Hủy\n");
            writer.write("   ✓ Mỗi trạng thái có hành vi riêng biệt, không dùng if-else\n");
            writer.write("   ✓ Dễ mở rộng thêm trạng thái mới mà không ảnh hưởng code cũ\n");
            writer.write("   ✓ Giúp phân tách logic xử lý theo trạng thái rõ ràng\n\n");

            writer.write("2. STRATEGY PATTERN:\n");
            writer.write("   ✓ Cho phép thay đổi phương thức vận chuyển linh hoạt\n");
            writer.write("   ✓ Hỗ trợ 2 chiến lược: Vận chuyển tiêu chuẩn, Vận chuyển nhanh\n");
            writer.write("   ✓ Có thể thay đổi chiến lược tại runtime\n");
            writer.write("   ✓ Dễ dàng thêm phương thức vận chuyển mới (Nước ngoài, Drone,...)\n");
            writer.write("   ✓ Giảm chi phí bảo trì so với việc sử dụng if-else\n\n");

            writer.write("3. DECORATOR PATTERN:\n");
            writer.write("   ✓ Thêm dịch vụ bổ sung linh hoạt mà không thay đổi lớp gốc\n");
            writer.write("   ✓ Hỗ trợ các dịch vụ: Gói quà, Bảo hiểm\n");
            writer.write("   ✓ Có thể kết hợp nhiều decorator cùng lúc\n");
            writer.write("   ✓ Tính toán chi phí dịch vụ một cách rõ ràng\n");
            writer.write("   ✓ Dễ dàng thêm dịch vụ mới (Ưu tiên giao, Theo dõi vị trí,...)\n\n");

            writer.write("KẾT LUẬN CHUNG:\n");
            writer.write("──────────────\n");
            writer.write("Kết hợp 3 Design Pattern tạo ra một hệ thống:\n");
            writer.write("• Linh hoạt: Có thể thay đổi trạng thái, chiến lược, và dịch vụ dễ dàng\n");
            writer.write("• Dễ bảo trì: Logic xử lý được tách biệt rõ ràng\n");
            writer.write("• Dễ mở rộng: Có thể thêm tính năng mới mà không làm hỏng code cũ\n");
            writer.write("• Có tính dùng lại cao: Các lớp có thể được sử dụng lại trong các ngữ cảnh khác\n");
            writer.write("• Tuân thủ nguyên tắc SOLID: Đặc biệt là Single Responsibility và Open/Closed\n\n");

            writer.write("Ứng dụng thực tế:\n");
            writer.write("• Hệ thống e-commerce (Tiki, Shopee, Lazada,...)\n");
            writer.write("• Ứng dụng giao hàng (Grab, Be,...)\n");
            writer.write("• Nền tảng bán lẻ trực tuyến\n");
            writer.write("• Hệ thống quản lý logistics\n");

            writer.close();
            System.out.println("\n✓ Kết luận đã được ghi vào file: src/main/resources/Bai3_Ket_Luan.txt");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
        System.out.println("║      thay đổi lớp đơn hàng gốc.                                 ║");
        System.out.println("║    - Có thể kết hợp nhiều decorator linh hoạt.                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }
}


