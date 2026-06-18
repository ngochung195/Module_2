package Bai4.SmartLogis.src;

public class RoBotXepDo implements IDonViVanChuyen {
    private int dungLuongPin;

    public RoBotXepDo(int dungLuongPin) {
        this.dungLuongPin = dungLuongPin;
    }

    @Override
    public void diChuyenHang() {
        System.out.println("Robot dang nang hang bang cang cua Pin(" + this.dungLuongPin + "%)...");
    }
}
