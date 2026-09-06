package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositorylmpl implements BuildingRepository {

    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "nhanvien1";
    static final String PASS = "12345";

    @Override
    public List<BuildingEntity> findAll(String name, Float dien_tich) {
        StringBuilder sql = new StringBuilder("select * from building where 1 = 1 ");
        List<Object> params = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            sql.append("AND ten_toanha like ? ");
            params.add("%" + name + "%");
        }
        if (dien_tich != null) {
            sql.append("AND dien_tich = ? ");
            params.add(dien_tich);
        }

        List<BuildingEntity> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    BuildingEntity buil = new BuildingEntity();
                    buil.setName(rs.getString("ten_toanha"));
                    buil.setNumberOfBasement(rs.getInt("so_tang"));
                    buil.setWard(rs.getString("ma_khuvuc"));
                    result.add(buil);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ket noi that bai...");
        }
        return result;
    }
}