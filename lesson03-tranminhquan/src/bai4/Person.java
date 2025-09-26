package bai4;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String hoTen;
    private String gioiTinh;
    private String diaChi;
    private List<String> soThich;
    private int namSinh;

    public Person(String hoTen, String gioiTinh, String diaChi, List<String> soThich, int namSinh) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh.trim().toLowerCase();
        this.diaChi = diaChi;
        this.soThich = new ArrayList<>();
        for (String st : soThich) {
            this.soThich.add(chinhSoThich(st));
        }
        this.namSinh = namSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public List<String> getSoThich() {
        return soThich;
    }

    public int getNamSinh() {
        return namSinh;
    }
    
    public int getTuoi() {
        return 2025 - namSinh;
    }

    /* chỉnh lại định dạng của sở thích: - trim(): bỏ khoảng trắng
                                         - toLowerCase(): định dạng về chữ thường
    */
    private String chinhSoThich(String st) {
        return st.trim().toLowerCase();
    }

    @Override
    public String toString() {
        return hoTen + " | " + gioiTinh + " | " + diaChi + " | " + namSinh + " | " + soThich;
    }
}
