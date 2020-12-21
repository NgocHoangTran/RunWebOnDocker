package com.dtdm.qlsv.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SINHVIEN")
public class SinhVien {
    public int getMa_SV() {
        return ma_SV;
    }

    public void setMa_SV(int ma_SV) {
        this.ma_SV = ma_SV;
    }

    public String getTen_SV() {
        return ten_SV;
    }

    public void setTen_SV(String ten_SV) {
        this.ten_SV = ten_SV;
    }

    public Date getNgay_Sinh() {
        return ngay_Sinh;
    }

    public void setNgay_Sinh(Date ngay_Sinh) {
        this.ngay_Sinh = ngay_Sinh;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public SinhVien(int ma_SV, String ten_SV, Date ngay_Sinh, Khoa khoa, Lop lop) {
        this.ma_SV = ma_SV;
        this.ten_SV = ten_SV;
        this.ngay_Sinh = ngay_Sinh;
        this.khoa = khoa;
        this.lop = lop;
    }

    public SinhVien() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma_SV;

    @Column(name = "ten_SV")
    private String ten_SV;

    @Column(name="ngay_Sinh")
    private Date ngay_Sinh;

    @ManyToOne
    @JoinColumn(name = "ma_Khoa")
    private Khoa khoa;

    @ManyToOne
    @JoinColumn(name = "ma_Lop")
    private Lop lop;

}
