package com.javaweb.service;

import java.util.List;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingSearchDTO;

public interface BuildingService {
    List<BuildingDTO> search(BuildingSearchDTO searchDTO);
}