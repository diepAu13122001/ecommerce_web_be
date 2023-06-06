package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.ProductImage;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.product.ProductImageDTO;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION+"/productImage")
public class ProductImageController extends BaseAPI {

    @GetMapping("/list")
    public ObjectResponseWrapper getAllProductImages() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(productImageService.findAll())
                .build();
    }

    @GetMapping("/get/{productImageId}")
    public ObjectResponseWrapper findById(@PathVariable Long productImageId) {
        ProductImage check = productImageService.findById(productImageId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @PostMapping("/create")
    public ObjectResponseWrapper createProductImage(@RequestBody ProductImageDTO productImageDTO) {
        try {
            ProductImage productImageCreate = productImageDTO.toEntity();
            productImageCreate = productImageService.createProductImage(productImageCreate);

            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Tạo dữ liệu thành công.")
                    .data(productImageCreate)
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
    public ObjectResponseWrapper updateProductImageInfoById(@RequestBody ProductImageDTO productImageDTO, @PathVariable Long productImageId) {
        try {
            ProductImage check = productImageService.findById(productImageId);
            if (check == null) {
                throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
            }
            check.setProduct(productService.findById(productImageDTO.getProductId()));
            check.setImgUrl(productImageDTO.getImgUrl());
            check.setImgAlt(productImageDTO.getImgAlt());

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

    @DeleteMapping("/delete/{id}")
    public ObjectResponseWrapper deleteProductImage(@PathVariable Long productImageId) {
        ProductImage check = productImageService.findById(productImageId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        productImageService.delete(productImageId);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Xoá dữ liệu thành công.")
                .build();
    }
}
