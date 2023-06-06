package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.UserCart;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.order.UserCartDTO;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.API_VERSION+"/cart")
public class UserCartController extends BaseAPI {

    @GetMapping("/list")
    public ObjectResponseWrapper getAllUserCarts() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(userCartService.findAll())
                .build();
    }

    @GetMapping("/get/{userCartId}")
    public ObjectResponseWrapper findById(@PathVariable Long userCartId) {
        UserCart check = userCartService.findById(userCartId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/findByUser/{userId}")
    public ObjectResponseWrapper findByUserId(@PathVariable Long userId) {
        UserCart check = userCartService.findByUserId(userId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @PostMapping("/create")
    public ObjectResponseWrapper createUserCart(@RequestBody UserCartDTO userCartDTO) {
        try {
            UserCart userCartCreate = userCartDTO.toEntity();
            userCartCreate = userCartService.createUserCart(userCartCreate);

            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Tạo dữ liệu thành công.")
                    .data(userCartCreate)
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

    @PutMapping("/addProduct/{id}/{productId}")
    public ObjectResponseWrapper addProduct(@PathVariable Long id, @PathVariable Long productId) {
        try {
            UserCart check = userCartService.findById(id);
            if (check == null) {
                throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
            }
            check.getProducts().add(productService.findById(productId));

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

    @GetMapping("/deleteProduct/{id}/{productId}")
    public ObjectResponseWrapper deleteUserCart(@PathVariable Long id, @PathVariable Long productId) {
        UserCart check = userCartService.findById(id);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        check.getProducts().remove(productService.findById(productId));
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Xoá dữ liệu thành công.")
                .data(check)
                .build();
    }

}
