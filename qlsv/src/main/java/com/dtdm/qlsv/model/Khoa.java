package com.dtdm.qlsv.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "KHOA")
public class Khoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma_Khoa;

    @Column(name = "ten_Khoa")
    private String ten_Khoa;


    @OneToMany(mappedBy = "khoa",fetch = FetchType.LAZY)
    private List<Lop> lopList;

    public int getMa_Khoa() {
        return ma_Khoa;
    }

    public void setMa_Khoa(int ma_Khoa) {
        this.ma_Khoa = ma_Khoa;
    }

    public String getTen_Khoa() {
        return ten_Khoa;
    }

    public void setTen_Khoa(String ten_Khoa) {
        this.ten_Khoa = ten_Khoa;
    }

    public List<Lop> getLopList() {
        return lopList;
    }

    public void setLopList(List<Lop> lopList) {
        this.lopList = lopList;
    }

    public List<SinhVien> getSinhVienList() {
        return sinhVienList;
    }

    public void setSinhVienList(List<SinhVien> sinhVienList) {
        this.sinhVienList = sinhVienList;
    }

    public Khoa(int ma_Khoa, String ten_Khoa) {
        this.ma_Khoa = ma_Khoa;
        this.ten_Khoa = ten_Khoa;
    }

    public Khoa() {
    }

    @OneToMany(mappedBy = "khoa",fetch = FetchType.LAZY)
    private List<SinhVien> sinhVienList;

}
