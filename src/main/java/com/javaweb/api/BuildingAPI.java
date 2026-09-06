package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {

    private static final String Long = null;
	@Autowired
    private BuildingService builSe;

    @GetMapping(value = "/api/building")
    public List<BuildingDTO> getB(@RequestParam(value = "name", required = false) String name,
    							  @RequestParam(value = "s", required = false) Float dien_tich) {
        List<BuildingDTO> result = builSe.findAll(name, dien_tich);   // gọi service, gán vào biến LOCAL bên trong method
        return result;
    }
}

	

	
	
//    @RequestMapping(value = "/api/building", method = RequestMethod.GET)
//    public Object getBuilding(@RequestParam(value = "name", required = false) String name,
//                               @RequestParam(value = "numberOfBasement") Integer numberOfBasement,
//                               @RequestParam(value = "ward") String ward) {
//
//        BuildingDTO res = new BuildingDTO();
//        res.setName(name);
//        res.setNumberOfBasement(numberOfBasement);f
//        res.setWard(ward);
//            valiDate(res); // gọi hàm validate, truyền DTO vừa tạo vào
//            return res;
//    }
//
//    // valiDate phải nằm NGANG HÀNG với getBuilding(), không lồng bên trong
//    public void valiDate(BuildingDTO buil){
//        if (buil.getNumberOfBasement() < 0) {
//            throw new InvalidBasementException("so tang ham khong hop le !");
//        }
//    }
//
//    @PostMapping(value = "/api/building")
//    public Object postBuilding(@RequestBody BuildingDTO buil) throws FieldRequiredException {
//    		valiDate(buil);
//    		return buil;
//    }