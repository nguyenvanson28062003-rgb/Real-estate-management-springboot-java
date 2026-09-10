package com.javaweb.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "district")
public class DistricEntity {

    @Id
    @Column(name = "ma_quan", length = 10)
    private String maQuan;               // VD: Q001 - tự sinh mã ở tầng Service, KHÔNG dùng @GeneratedValue

    @Column(name = "ten_quan", nullable = false, length = 100)
    private String tenQuan;

    @Column(name = "tinh_thanhpho", nullable = false, length = 100)
    private String tinhThanhPho;

    @Column(name = "ma_buuchinh", length = 10)
    private String maBuuChinh;

    @Column(name = "mo_ta", length = 255)
    private String moTa;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai", nullable = false)
    private TrangThaiDanhMuc trangThai;   // 'Hoat dong' / 'Ngung hoat dong'

    @Column(name = "ngay_tao", insertable = false, updatable = false)
    private LocalDateTime ngayTao;

    @Column(name = "ngay_capnhat", insertable = false, updatable = false)
    private LocalDateTime ngayCapNhat;

    // 1 quận có nhiều tòa nhà - quan hệ ngược, không bắt buộc dùng
    @OneToMany(mappedBy = "district")
    private List<BuildingEntity> buildings;

    // getter/setter

    public String getMaQuan() {
        return maQuan;
    }
    public void setMaQuan(String maQuan) {
        this.maQuan = maQuan;
    }
    public String getTenQuan() {
        return tenQuan;
    }
    public void setTenQuan(String tenQuan) {
        this.tenQuan = tenQuan;
    }
    public String getTinhThanhPho() {
        return tinhThanhPho;
    }
    public void setTinhThanhPho(String tinhThanhPho) {
        this.tinhThanhPho = tinhThanhPho;
    }
    public String getMaBuuChinh() {
        return maBuuChinh;
    }
    public void setMaBuuChinh(String maBuuChinh) {
        this.maBuuChinh = maBuuChinh;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    public TrangThaiDanhMuc getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(TrangThaiDanhMuc trangThai) {
        this.trangThai = trangThai;
    }
    public LocalDateTime getNgayTao() {
        return ngayTao;
    }
    public LocalDateTime getNgayCapNhat() {
        return ngayCapNhat;
    }
    public List<BuildingEntity> getBuildings() {
        return buildings;
    }
    public void setBuildings(List<BuildingEntity> buildings) {
        this.buildings = buildings;
    }
}