package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingSearchDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public List<BuildingDTO> search(BuildingSearchDTO searchDTO) {

        // 1. Gọi Repository lấy dữ liệu thô (Entity) theo điều kiện search
        List<BuildingEntity> entities = buildingRepository.search(searchDTO);

        // 2. Convert từng Entity -> DTO
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity entity : entities) {
            result.add(convertToDTO(entity));
        }

        // 3. Trả về danh sách DTO
        return result;
    }

    private BuildingDTO convertToDTO(BuildingEntity entity) {
        BuildingDTO dto = new BuildingDTO();
        dto.setTen_toanha(entity.getTenToaNha());
        dto.setDia_chi(entity.getDiaChi());
        dto.setMa_khuvuc(entity.getMaKhuVuc());
        dto.setSo_tang(entity.getSoTang());
        dto.setGia(entity.getGia() != null ? entity.getGia().doubleValue() : null);
        dto.setDien_tich(entity.getDienTich() != null ? entity.getDienTich().doubleValue() : null);
        return dto;
    }
}