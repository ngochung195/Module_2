package Bai4.SmartLogis.src;

public class SmartLogis {
    public static void main(String[] args) {
        IDonViVanChuyen nv = new NhanVien("Nguyen Van Anh", "BHXH123456");
        IDonViVanChuyen robot = new RoBotXepDo(95);

        nv.diChuyenHang();
        robot.diChuyenHang();

        System.out.println("--------------------------------------");

        KhoHang khoTong = new KhoHang("Kho Tong Logistics");

        DonHang dh1 = new DonHang("DH_001");
        DonHang dh2 = new DonHang("DH_002");

        khoTong.addDonHang(dh1);
        khoTong.addDonHang(dh2);

        khoTong.hienThiDonHang();
    }
}