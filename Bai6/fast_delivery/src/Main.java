import java.util.ArrayList;
import java.util.List;

/**
 * HỆ THỐNG TÍNH CƯỚC FASTDELIVERY (LEGACY CODE)
 */

abstract class Order {
    protected String id;
    protected List<String> vouchers = new ArrayList<>();
    protected double baseDiscount = 0.0;

    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void addVoucher(String code) {
        this.vouchers.add(code);
        System.out.println("-> [" + id + "] Đã áp dụng mã: " + code);
    }

    public void addVoucher(String code, double extraDiscount) {
        this.vouchers.add(code);
        this.baseDiscount += extraDiscount;
        System.out.println("-> [" + id + "] Đã áp dụng mã đặc biệt: " + code + " (Giảm thêm: " + extraDiscount + "đ)");
    }

    public abstract double caculateFee();
}

class StandardOrder extends Order {
    public StandardOrder(String id) {
        super(id);
    }

    @Override
    public double caculateFee() {
        double fee = 15000 - baseDiscount;
        return Math.max(fee, 0);
    }
}

class ExpressOrder extends Order {
    public ExpressOrder(String id) {
        super(id);
    }

    @Override
    public double caculateFee() {
        double fee = 30000 - baseDiscount;
        return Math.max(fee, 0);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== KHỞI TẠO VÀ ÁP DỤNG VOUCHER (OVERLOADING) ===");

        Order o1 = new StandardOrder("STD_01");
        o1.addVoucher("FREESHIP");

        Order o2 = new ExpressOrder("EXP_02");
        o2.addVoucher("VIPHOATOC", 5000);

        Order o3 = new ExpressOrder("EXP_03");

        System.out.println("\n=== KIỂM TRA ĐA HÌNH VỚI MẢNG (OVERRIDING - DYNAMIC BINDING) ===");

        Order[] orders = { o1, o2, o3 };

        for (Order order : orders) {
            System.out.printf("Đơn hàng: %-8s | Cước phí cuối cùng: %,.0f đ%n",
                    order.getId(), order.caculateFee());
        }
    }
}