package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.Province;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.address.ProvinceDTO;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION+"/province")
public class ProvinceController extends BaseAPI {
    @PostMapping("/create")
    public ObjectResponseWrapper createProvince(@RequestBody ProvinceDTO provinceDTO) {
        try {
            Province provinceCreate = provinceService.createProvince(provinceDTO.toEntity());
            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Tạo dữ liệu thành công.")
                    .data(provinceCreate)
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
    public ObjectResponseWrapper updateProvinceInfoById(@RequestBody Province province, @PathVariable Long provinceId) {
        try {
            Province check = provinceService.findById(provinceId);
            if (check == null) {
                throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
            }
            check.setName(province.getName());

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
    public ObjectResponseWrapper getAllProvinces() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(provinceService.findAll()).build();

    }

    @GetMapping("/listByOrderNameAsc")
    public ObjectResponseWrapper getAllByOrderNameAsc() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(provinceService.findAllByOrderByNameAsc()).build();

    }
    @GetMapping("/get/{id}")
    public ObjectResponseWrapper getProvinceById(@PathVariable Long provinceId) {
        Province check = provinceService.findById(provinceId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check).build();
    }

    @DeleteMapping("/delete/{id}")
    public ObjectResponseWrapper deleteProvince(@PathVariable Long provinceId) {
        Province check = provinceService.findById(provinceId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        provinceService.deleteById(provinceId);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Xoá dữ liệu thành công.").build();
    }
}
