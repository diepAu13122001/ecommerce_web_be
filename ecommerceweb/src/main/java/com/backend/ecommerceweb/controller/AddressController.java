package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.entities.User;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.address.AddressDTO;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION+"/address")
public class AddressController extends BaseAPI {
    @PostMapping("/create")
    public ObjectResponseWrapper createAddress(@RequestBody AddressDTO addressDTO) {
        try {
            Address addressCreate = mapper.map(addressDTO, Address.class);
            addressCreate = addressService.createAddress(addressCreate);
            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Tạo dữ liệu thành công.")
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
    public ObjectResponseWrapper updateAddressInfoById(@RequestBody Address address, @PathVariable Long addressId) {
        try {
            Address check = addressService.findById(addressId);
            if (check == null) {
                throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
            }
            check.setAddress(address.getAddress());
            check.setWard(address.getWard());

            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Cập nhật dữ liệu thành công.")
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
    public ObjectResponseWrapper getAllAddresses() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(addressService.findAll()).build();

    }

    @PutMapping("/a")
//    @Operation(summary = "Danh sách khách hàng")
//    @RequiredHeaderToken
    public ObjectResponseWrapper getUsers() {
        List<User> userList = userRepository.findAll();
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(userList)
                .build();
    }


    @GetMapping("/get/{id}")
    public ObjectResponseWrapper getAddressById(@PathVariable Long addressId) {
        Address check = addressService.findById(addressId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check).build();
    }

    @DeleteMapping("/delete/{id}")
    public ObjectResponseWrapper deleteAddress(@PathVariable Long addressId) {
        Address check = addressService.findById(addressId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Xoá dữ liệu thành công.").build();
    }
}
