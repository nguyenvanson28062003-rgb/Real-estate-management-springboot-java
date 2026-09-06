package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	
	@Autowired
	private BuildingRepository builR;
	
	@Override
	public List<BuildingDTO> findAll(String name, Float dien_tich) {
		List<BuildingEntity> be = builR.findAll(name, dien_tich);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : be) {
			BuildingDTO buil = new BuildingDTO();
				buil.setName(item.getName());
				buil.setNumberOfBasement(item.getNumberOfBasement());
				buil.setWard(item.getWard());
				result.add(buil);
		}
		return result;
		}
	
}
