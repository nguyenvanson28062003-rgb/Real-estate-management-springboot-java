package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingSearchDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {

	@Autowired
    private BuildingService builSe;

    @GetMapping(value = "/api/building")
//    public List<BuildingDTO> getB(@RequestParam(value = "ma_toanha", required = false) String ma_toanha,
//    							  @RequestParam(value = "name", required = false) String ten_toanha,
//    							  @RequestParam(value = "dia_chi", required = false) String dia_chi,
//    							  @RequestParam(value = "ma_khuvuc", required = false) String ma_khuvuc,
//    							  @RequestParam(value = "so_tang", required = false) Integer so_tang,
//    							  @RequestParam(value = "gia", required = false) Double gia,
//    							  @RequestParam(value = "dien_tich", required = false) Double dien_tich) {
//    	  BuildingSearchDTO searchDTO = new BuildingSearchDTO();
//          searchDTO.setTenToaNha(ten_toanha);
//          searchDTO.setMaKhuVuc(ma_khuvuc);
//          searchDTO.setSoTang(so_tang);
//          searchDTO.setGiaTu(gia);        
//          searchDTO.setDienTichTu(dien_tich);
//       
//        return builSe.search(searchDTO);
//    }
    public List<BuildingDTO> getBuilding(BuildingSearchDTO searchDTO) {
        return builSe.search(searchDTO);
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