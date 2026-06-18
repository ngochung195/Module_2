package Bai4.SmartLogis.src;

public class NhanVien implements IDonViVanChuyen {
    private String hoTen;
    private String maSoBHXH;

    public NhanVien(String hoTen, String maSoBHXH) {
        this.hoTen = hoTen;
        this.maSoBHXH = maSoBHXH;
    }

    @Override
    public void diChuyenHang() {
        System.out.println("Nhan vien " + hoTen + " dang be hang bang tay...");
    }
}
