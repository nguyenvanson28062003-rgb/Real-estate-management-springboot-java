package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingSearchDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositorylmpl implements BuildingRepository {

    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "nhanvien1";
    static final String PASS = "12345";

    @Override
    public List<BuildingEntity> findAll() {
        return search(new BuildingSearchDTO());
    }

    @Override
    public List<BuildingEntity> search(BuildingSearchDTO searchDTO) {

        StringBuilder sql = new StringBuilder("select * from building where 1 = 1 ");
        List<Object> params = new ArrayList<>();

        if (searchDTO.getTenToaNha() != null && !searchDTO.getTenToaNha().isEmpty()) {
            sql.append("and ten_toanha like ? ");
            params.add("%" + searchDTO.getTenToaNha() + "%");
        }

        if (searchDTO.getMaQuan() != null && !searchDTO.getMaQuan().isEmpty()) {
            sql.append("and ma_quan = ? ");
            params.add(searchDTO.getMaQuan());
        }

        if (searchDTO.getMaKhuVuc() != null && !searchDTO.getMaKhuVuc().isEmpty()) {
            sql.append("and ma_khuvuc = ? ");
            params.add(searchDTO.getMaKhuVuc());
        }

        if (searchDTO.getSoTang() != null) {
            sql.append("and so_tang = ? ");
            params.add(searchDTO.getSoTang());
        }

        if (searchDTO.getGiaTu() != null) {
            sql.append("and gia >= ? ");
            params.add(searchDTO.getGiaTu());
        }

        if (searchDTO.getGiaDen() != null) {
            sql.append("and gia <= ? ");
            params.add(searchDTO.getGiaDen());
        }

        if (searchDTO.getDienTichTu() != null) {
            sql.append("and dien_tich >= ? ");
            params.add(searchDTO.getDienTichTu());
        }

        if (searchDTO.getDienTichDen() != null) {
            sql.append("and dien_tich <= ? ");
            params.add(searchDTO.getDienTichDen());
        }

        List<BuildingEntity> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    BuildingEntity building = new BuildingEntity();
                    building.setMaToaNha(rs.getString("ma_toanha"));
                    building.setTenToaNha(rs.getString("ten_toanha"));
                    building.setDiaChi(rs.getString("dia_chi"));
                    building.setMaKhuVuc(rs.getString("ma_khuvuc"));
                    building.setSoTang(rs.getInt("so_tang"));
                    building.setGia(rs.getBigDecimal("gia"));
                    building.setDienTich(rs.getBigDecimal("dien_tich"));
                    result.add(building);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ket noi that bai...");
        }

        return result;
    }
}