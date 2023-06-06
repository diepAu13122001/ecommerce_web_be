package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.ProductDescription;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.product.ProductDescriptionDTO;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION + "/productDescription")
public class ProductDescriptionController extends BaseAPI {
    @GetMapping("/findByProductStorageTemp/{productStorageTemp}")
    public ObjectResponseWrapper findByProductStorageTemp(@PathVariable String productStorageTemp) {
        List<ProductDescription> check = productDescriptionService.findByProductStorageTemp(productStorageTemp);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/findByProductStorageTempContaining/{productStorageTemp}")
    public ObjectResponseWrapper findByProductStorageTempContaining(@PathVariable String productStorageTemp) {
        List<ProductDescription> check = productDescriptionService.findByProductStorageTempContaining(productStorageTemp);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/list")
    public ObjectResponseWrapper getAllProductDescriptions() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(productDescriptionService.findAll())
                .build();
    }

    @GetMapping("/get/{productDescriptionId}")
    public ObjectResponseWrapper findById(@PathVariable Long productDescriptionId) {
        ProductDescription check = productDescriptionService.findById(productDescriptionId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/findByProduct/{productId}")
    public ObjectResponseWrapper findByProduct(@PathVariable Long productId) {
        ProductDescription check = productDescriptionService.findByProductId(productId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @PostMapping("/create")
    public ObjectResponseWrapper createProductDescription(@RequestBody ProductDescriptionDTO productDescriptionDTO) {
        try {
            ProductDescription productDescriptionCreate = productDescriptionDTO.toEntity();
            productDescriptionCreate = productDescriptionService.create(productDescriptionCreate);

            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Tạo dữ liệu thành công.")
                    .data(productDescriptionCreate)
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
    public ObjectResponseWrapper updateProductDescriptionInfoById(@RequestBody ProductDescriptionDTO productDescriptionDTO, @PathVariable Long productDescriptionId) {
        try {
            ProductDescription check = productDescriptionService.findById(productDescriptionId);
            if (check == null) {
                throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
            }
            check.setProductStorageTemp(productDescriptionDTO.getProductStorageTemp());
            check.setExpiryDate(productDescriptionDTO.getExpiryDate());
            check.setManufacturingDate(productDescriptionDTO.getManufacturingDate());
            check.setProductWeigh(productDescriptionDTO.getProductWeigh());
            check.setProductDes(productDescriptionDTO.getProductDes());

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
    public ObjectResponseWrapper deleteProductDescription(@PathVariable Long productDescriptionId) {
        ProductDescription check = productDescriptionService.findById(productDescriptionId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        productDescriptionService.delete(productDescriptionId);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Xoá dữ liệu thành công.")
                .build();
    }

}
