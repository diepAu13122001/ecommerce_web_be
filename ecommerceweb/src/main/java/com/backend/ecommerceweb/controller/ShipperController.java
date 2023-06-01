package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.Shipper;
import com.backend.ecommerceweb.entities.User;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.entities.UserRole;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.order.ShipperDTO;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.services.impl.ShipperService;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION + "/shipper")
public class ShipperController extends BaseAPI {
    @PostMapping("/create")
    public ObjectResponseWrapper createShipper(@RequestBody ShipperDTO shipperDTO) {
        try {
            Shipper check = shipperService.findByPhone(shipperDTO.getPhone());
            if (check != null) {
                throw new VeggyServiceException("Dữ liệu đã tồn tại");
            }
            Shipper shipperCreate = mapper.map(shipperDTO, Shipper.class);
            shipperCreate.setUrl_avt("https://i.pinimg.com/736x/97/d0/f9/97d0f95b9060ba41c4ea6bd1ae47267f.jpg");
            //tạo user
            shipperCreate = shipperService.createShipper(shipperCreate);

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
    public ObjectResponseWrapper updateShipperInfoById(@RequestBody Shipper shipper, @PathVariable Long shipperId) {
        try {
            Shipper check = shipperService.findById(shipperId);
            if (check == null) {
                throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
            }
            check.setDistricts(shipper.getDistricts());
            check.setPhone(shipper.getPhone());
            check.setAddress(shipper.getAddress());
            check.setUrl_avt(shipper.getUrl_avt());
            check.setGender(shipper.getGender());

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
    public ObjectResponseWrapper getAllShippers() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(shipperService.findAll()).build();

    }

    @GetMapping("/get/{id}")
    public ObjectResponseWrapper getShipperById(@PathVariable Long shipperId) {
        Shipper check = shipperService.findById(shipperId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check).build();
    }

    @DeleteMapping("/delete/{id}")
    public ObjectResponseWrapper deleteShipper(@PathVariable Long shipperId) {
        Shipper check = shipperService.findById(shipperId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        shipperService.deleteById(shipperId);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Xoá dữ liệu thành công.").build();
    }
}
