package Bai4.SmartLogis.src;

import java.util.ArrayList;
import java.util.List;

public class KhoHang {
    private String tenKho;

    private List<DonHang> danhSachDonHang;

    public KhoHang(String tenKho) {
        this.tenKho = tenKho;
        this.danhSachDonHang = new ArrayList<>();
    }

    public void addDonHang(DonHang donHang) {
        if (donHang != null) {
            this.danhSachDonHang.add(donHang);
            System.out.println("Da tiep nhan don hang " + donHang.getMaDon() + " vao " + tenKho);
        }
    }

    public void hienThiDonHang() {
        System.out.println("--- Danh sach don tai " + tenKho + " ---");
        for (DonHang dh : danhSachDonHang) {
            System.out.println("- Ma don: " + dh.getMaDon());
        }
    }

}
