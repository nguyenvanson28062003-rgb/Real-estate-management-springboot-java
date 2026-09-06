package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {
    List<BuildingEntity> findAll(String name, Float dien_tich);
}