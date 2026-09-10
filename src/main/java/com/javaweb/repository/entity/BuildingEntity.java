package com.javaweb.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "building")
public class BuildingEntity {

    @Id
    @Column(name = "ma_toanha", length = 10)
    private String maToaNha;             // VD: TN001 - tự sinh mã ở tầng Service

    @Column(name = "ten_toanha", nullable = false, length = 150)
    private String tenToaNha;

    @Column(name = "dia_chi", nullable = false)
    private String diaChi;

    @ManyToOne
    @JoinColumn(name = "ma_quan", nullable = false)
    private DistricEntity district;

    @Column(name = "ma_khuvuc")
    private String ma_khuvuc;     // nếu chưa có entity này thì tạm để String maKhuVuc, xem ghi chú bên dưới

    @Column(name = "vi_do", precision = 10, scale = 7)
    private BigDecimal viDo;

    @Column(name = "kinh_do", precision = 10, scale = 7)
    private BigDecimal kinhDo;

    @Column(name = "dien_tich", nullable = false, precision = 10, scale = 2)
    private BigDecimal dienTich;

    @Column(name = "chieu_dai", precision = 6, scale = 2)
    private BigDecimal chieuDai;

    @Column(name = "chieu_rong", precision = 6, scale = 2)
    private BigDecimal chieuRong;

    @Column(name = "so_tang")
    private Integer soTang;

    @Column(name = "so_phongngu")
    private Integer soPhongNgu;

    @Column(name = "so_phongtam")
    private Integer soPhongTam;

    @Enumerated(EnumType.STRING)
    @Column(name = "huong_nha")
    private HuongNha huongNha;

    @Enumerated(EnumType.STRING)
    @Column(name = "noi_that")
    private NoiThat noiThat;

    @Enumerated(EnumType.STRING)
    @Column(name = "phap_ly")
    private PhapLy phapLy;

    @Column(name = "gia", nullable = false, precision = 15, scale = 2)
    private BigDecimal gia;

    @Enumerated(EnumType.STRING)
    @Column(name = "don_vi_gia", nullable = false)
    private DonViGia donViGia;

    @Enumerated(EnumType.STRING)
    @Column(name = "don_vi_thoigian")
    private DonViThoiGian donViThoiGian;

    @Column(name = "gia_thuongluong", nullable = false)
    private Boolean giaThuongLuong;

    @Column(name = "co_thangmay", nullable = false)
    private Boolean coThangMay;

    @Column(name = "co_chodauxe", nullable = false)
    private Boolean coChoDauXe;

    @Column(name = "ten_chusohuu", length = 100)
    private String tenChuSoHuu;

    @Column(name = "sdt_chusohuu", length = 15)
    private String sdtChuSoHuu;

    @Column(name = "email_chusohuu", length = 100)
    private String emailChuSoHuu;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "anh_daidien")
    private String anhDaiDien;

    @Column(name = "luot_xem", nullable = false)
    private Integer luotXem;

    @Column(name = "noi_bat", nullable = false)
    private Boolean noiBat;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai", nullable = false)
    private TrangThaiBuilding trangThai;

    @Column(name = "ngay_dang")
    private LocalDateTime ngayDang;

    @Column(name = "ngay_hethan")
    private LocalDate ngayHetHan;

    @Column(name = "ngay_tao", insertable = false, updatable = false)
    private LocalDateTime ngayTao;

    @Column(name = "ngay_capnhat", insertable = false, updatable = false)
    private LocalDateTime ngayCapNhat;

    public String getMaToaNha() {
        return maToaNha;
    }
    public void setMaToaNha(String maToaNha) {
        this.maToaNha = maToaNha;
    }
    public String getTenToaNha() {
        return tenToaNha;
    }
    public void setTenToaNha(String tenToaNha) {
        this.tenToaNha = tenToaNha;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public DistricEntity getDistrict() {
        return district;
    }
    public void setDistrict(DistricEntity district) {
        this.district = district;
    }
    public String getMaKhuVuc() {
        return ma_khuvuc;
    }
    public void setMaKhuVuc(String maKhuVuc) {
        this.ma_khuvuc = maKhuVuc;
    }
    public BigDecimal getViDo() {
        return viDo;
    }
    public void setViDo(BigDecimal viDo) {
        this.viDo = viDo;
    }
    public BigDecimal getKinhDo() {
        return kinhDo;
    }
    public void setKinhDo(BigDecimal kinhDo) {
        this.kinhDo = kinhDo;
    }
    public BigDecimal getDienTich() {
        return dienTich;
    }
    public void setDienTich(BigDecimal dienTich) {
        this.dienTich = dienTich;
    }
    public BigDecimal getChieuDai() {
        return chieuDai;
    }
    public void setChieuDai(BigDecimal chieuDai) {
        this.chieuDai = chieuDai;
    }
    public BigDecimal getChieuRong() {
        return chieuRong;
    }
    public void setChieuRong(BigDecimal chieuRong) {
        this.chieuRong = chieuRong;
    }
    public Integer getSoTang() {
        return soTang;
    }
    public void setSoTang(Integer soTang) {
        this.soTang = soTang;
    }
    public Integer getSoPhongNgu() {
        return soPhongNgu;
    }
    public void setSoPhongNgu(Integer soPhongNgu) {
        this.soPhongNgu = soPhongNgu;
    }
    public Integer getSoPhongTam() {
        return soPhongTam;
    }
    public void setSoPhongTam(Integer soPhongTam) {
        this.soPhongTam = soPhongTam;
    }
    public HuongNha getHuongNha() {
        return huongNha;
    }
    public void setHuongNha(HuongNha huongNha) {
        this.huongNha = huongNha;
    }
    public NoiThat getNoiThat() {
        return noiThat;
    }
    public void setNoiThat(NoiThat noiThat) {
        this.noiThat = noiThat;
    }
    public PhapLy getPhapLy() {
        return phapLy;
    }
    public void setPhapLy(PhapLy phapLy) {
        this.phapLy = phapLy;
    }
    public BigDecimal getGia() {
        return gia;
    }
    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }
    public DonViGia getDonViGia() {
        return donViGia;
    }
    public void setDonViGia(DonViGia donViGia) {
        this.donViGia = donViGia;
    }
    public DonViThoiGian getDonViThoiGian() {
        return donViThoiGian;
    }
    public void setDonViThoiGian(DonViThoiGian donViThoiGian) {
        this.donViThoiGian = donViThoiGian;
    }
    public Boolean getGiaThuongLuong() {
        return giaThuongLuong;
    }
    public void setGiaThuongLuong(Boolean giaThuongLuong) {
        this.giaThuongLuong = giaThuongLuong;
    }
    public Boolean getCoThangMay() {
        return coThangMay;
    }
    public void setCoThangMay(Boolean coThangMay) {
        this.coThangMay = coThangMay;
    }
    public Boolean getCoChoDauXe() {
        return coChoDauXe;
    }
    public void setCoChoDauXe(Boolean coChoDauXe) {
        this.coChoDauXe = coChoDauXe;
    }
    public String getTenChuSoHuu() {
        return tenChuSoHuu;
    }
    public void setTenChuSoHuu(String tenChuSoHuu) {
        this.tenChuSoHuu = tenChuSoHuu;
    }
    public String getSdtChuSoHuu() {
        return sdtChuSoHuu;
    }
    public void setSdtChuSoHuu(String sdtChuSoHuu) {
        this.sdtChuSoHuu = sdtChuSoHuu;
    }
    public String getEmailChuSoHuu() {
        return emailChuSoHuu;
    }
    public void setEmailChuSoHuu(String emailChuSoHuu) {
        this.emailChuSoHuu = emailChuSoHuu;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    public String getAnhDaiDien() {
        return anhDaiDien;
    }
    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }
    public Integer getLuotXem() {
        return luotXem;
    }
    public void setLuotXem(Integer luotXem) {
        this.luotXem = luotXem;
    }
    public Boolean getNoiBat() {
        return noiBat;
    }
    public void setNoiBat(Boolean noiBat) {
        this.noiBat = noiBat;
    }
    public TrangThaiBuilding getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(TrangThaiBuilding trangThai) {
        this.trangThai = trangThai;
    }
    public LocalDateTime getNgayDang() {
        return ngayDang;
    }
    public void setNgayDang(LocalDateTime ngayDang) {
        this.ngayDang = ngayDang;
    }
    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }
    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
    public LocalDateTime getNgayTao() {
        return ngayTao;
    }
    public LocalDateTime getNgayCapNhat() {
        return ngayCapNhat;
    }
}