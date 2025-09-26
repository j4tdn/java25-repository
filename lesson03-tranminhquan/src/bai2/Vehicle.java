package bai2;

import java.util.Scanner;

public class Vehicle {
    private String tenChuXe;
    private String loaiXe;
    private double triGia;
    private int dungTich;

    public Vehicle(String tenChuXe, String loaiXe, double triGia, int dungTich) {
        this.tenChuXe = tenChuXe;
        this.loaiXe = loaiXe;
        this.triGia = triGia;
        this.dungTich = dungTich;
    }

    public String getTenChuXe() {
        return tenChuXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public double getTriGia() {
        return triGia;
    }

    public int getDungTich() {
        return dungTich;
    }

    public double tinhThue() {
        if (dungTich < 100) {
            return triGia * 0.01;
        } else if (dungTich <= 200) {
            return triGia * 0.03;
        } else {
            return triGia * 0.05;
        }
    }

    public void xuatThongTin() {
        System.out.printf("%-20s %-15s %-12f %-10d %-12f\n",
                tenChuXe, loaiXe, triGia, dungTich, tinhThue());
    }
}
