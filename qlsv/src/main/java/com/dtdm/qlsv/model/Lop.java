package com.dtdm.qlsv.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LOP")
public class Lop {
    public int getMa_Lop() {
        return ma_Lop;
    }

    public void setMa_Lop(int ma_Lop) {
        this.ma_Lop = ma_Lop;
    }

    public String getTen_Lop() {
        return ten_Lop;
    }

    public void setTen_Lop(String ten_Lop) {
        this.ten_Lop = ten_Lop;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public List<SinhVien> getSinhVienList() {
        return sinhVienList;
    }

    public void setSinhVienList(List<SinhVien> sinhVienList) {
        this.sinhVienList = sinhVienList;
    }

    public Lop(int ma_Lop, String ten_Lop, Khoa khoa) {
        this.ma_Lop = ma_Lop;
        this.ten_Lop = ten_Lop;
        this.khoa = khoa;
    }

    public Lop() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma_Lop;

    @Column(name = "ten_Lop")
    private String ten_Lop;

    @ManyToOne
    @JoinColumn(name = "ma_Khoa")
    private Khoa khoa;

    @OneToMany(mappedBy = "lop",fetch = FetchType.LAZY)
    private List<SinhVien> sinhVienList;


}
