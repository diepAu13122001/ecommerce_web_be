package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.District;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.address.DistrictDTO;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION + "/district")
public class DistrictController extends BaseAPI {
    @PostMapping("/create")
    public ObjectResponseWrapper createDistrict(@RequestBody DistrictDTO districtDTO) {
        try {
            District districtCreate = districtService.createDistrict(districtDTO.toEntity());
            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Tạo dữ liệu thành công.")
                    .data(districtCreate)
                    .build();
        } catch (VeggyServiceException e) {
            return ObjectResponseWrapper.builder()
                    .status(0)
                    .message(e.getReason())
                    .build();
        } catch (Exception e2) {
            return ObjectResponseWrapper.builder()
                    .status(0)
                    .message(e2.getMessage())
                    .build();
        }
    }

    @PutMapping("/update/{id}")
    public ObjectResponseWrapper updateDistrictInfoById(@RequestBody District district, @PathVariable Long districtId) {
        try {
            District check = districtService.findById(districtId);
            if (check == null) {
                throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
            }
            check.setName(district.getName());
            check.setProvince(district.getProvince());

            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Cập nhật dữ liệu thành công.")
                    .data(check)
                    .build();
        } catch (VeggyServiceException e) {
            return ObjectResponseWrapper.builder()
                    .status(0)
                    .message(e.getReason())
                    .build();
        } catch (Exception e2) {
            return ObjectResponseWrapper.builder()
                    .status(0)
                    .message(e2.getMessage())
                    .build();
        }
    }

    @GetMapping("/list")
    public ObjectResponseWrapper getAllDistricts() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(districtService.findAll()).build();

    }

    @GetMapping("/listByOrderNameAsc")
    public ObjectResponseWrapper getAllByOrderNameAsc() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(districtService.findAllByOrderByNameAsc()).build();

    }
    @GetMapping("/get/{id}")
    public ObjectResponseWrapper getDistrictById(@PathVariable Long districtId) {
        District check = districtService.findById(districtId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check).build();
    }

    @GetMapping("/getByProvince/{id}")
    public ObjectResponseWrapper getByProvinceId(@PathVariable Long provinceId) {
        List<District> check = districtService.findByProvince(provinceId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check).build();
    }
    @DeleteMapping("/delete/{id}")
    public ObjectResponseWrapper deleteDistrict(@PathVariable Long districtId) {
        District check = districtService.findById(districtId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        districtService.deleteById(districtId);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Xoá dữ liệu thành công.").build();
    }
}
