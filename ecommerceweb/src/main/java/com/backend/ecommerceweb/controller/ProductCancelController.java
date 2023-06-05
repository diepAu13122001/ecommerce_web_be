package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.Order;
import com.backend.ecommerceweb.entities.ProductCancel;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.product.ProductCancelDTO;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION + "/productCancel")
public class ProductCancelController extends BaseAPI {

    @GetMapping("/getByQuantity/{quantity}")
    public ObjectResponseWrapper findByQuantity(@PathVariable Integer quantity) {
        List<ProductCancel> check = productCancelService.findByQuantity(quantity);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getByQuantityLessThanEqual/{quantity}")
    public ObjectResponseWrapper findByQuantityLessThanEqual(@PathVariable Integer quantity) {
        List<ProductCancel> check = productCancelService.findByQuantityLessThanEqual(quantity);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }
    @GetMapping("/getByQuantityGreaterThanEqual/{quantity}")
    public ObjectResponseWrapper findByQuantityGreaterThanEqual(@PathVariable Integer quantity) {
        List<ProductCancel> check = productCancelService.findByQuantityGreaterThanEqual(quantity);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getByUnitPrice/{unitPrice}")
    public ObjectResponseWrapper findByUnitPrice(@PathVariable Double unitPrice) {
        List<ProductCancel> check = productCancelService.findByUnitPrice(unitPrice);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getByUnitPriceBetween/{minUnitPrice}-{maxUnitPrice}")
    public ObjectResponseWrapper findByUnitPriceBetween(@PathVariable Double minUnitPrice, @PathVariable Double maxUnitPrice) {
        List<ProductCancel> check = productCancelService.findByUnitPriceBetween(minUnitPrice, maxUnitPrice);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getByUnitPriceLessThanEqual/{unitPrice}")
    public ObjectResponseWrapper findByUnitPriceLessThanEqual(@PathVariable Double unitPrice) {
        List<ProductCancel> check = productCancelService.findByUnitPriceLessThanEqual(unitPrice);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getByUnitPriceGreaterThanEqual/{unitPrice}")
    public ObjectResponseWrapper findByUnitPriceGreaterThanEqual(@PathVariable Double unitPrice) {
        List<ProductCancel> check = productCancelService.findByUnitPriceGreaterThanEqual(unitPrice);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getByCreatedAt/{date}-{month}-{year}")
    public ObjectResponseWrapper findByCreatedAt(@PathVariable int date, @PathVariable int month, @PathVariable int year) {
        Date createdDate = new Date(year, month, date);
        List<ProductCancel> check = productCancelService.findByCreatedAt(createdDate);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByCreatedAtBetween/{sDate}-{sMonth}-{sYear}/{eDate}-{eMonth}-{eYear}")
    public ObjectResponseWrapper findByCreatedAtBetween(@PathVariable int sDate, @PathVariable int sMonth, @PathVariable int sYear, @PathVariable int eDate, @PathVariable int eMonth, @PathVariable int eYear) {
        Date started = new Date(sYear, sMonth, sDate);
        Date ended = new Date(eYear, eMonth, eDate);
        List<ProductCancel> check = productCancelService.findByCreatedAtBetween(started, ended);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getByProduct/{productId}")
    public ObjectResponseWrapper findByProduct(@PathVariable Long productId) {
        List<ProductCancel> check = productCancelService.findByProduct(productId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }
    @GetMapping("/list")
    public ObjectResponseWrapper getAllProductCancels() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(productCancelService.findAll())
                .build();
    }

    @GetMapping("/get/{productCancelId}")
    public ObjectResponseWrapper findById(@PathVariable Long productCancelId) {
        ProductCancel check = productCancelService.findById(productCancelId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getAllByOrderByUnitPriceAsc")
    public ObjectResponseWrapper findAllByOrderByUnitPriceAsc() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(productCancelService.findAllByOrderByUnitPriceAsc())
                .build();
    }

    @GetMapping("/getAllByOrderByUnitPriceDesc")
    public ObjectResponseWrapper findAllByOrderByUnitPriceDesc() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(productCancelService.findAllByOrderByUnitPriceDesc())
                .build();
    }

    @GetMapping("/getAllByOrderByCreatedAtDesc")
    public ObjectResponseWrapper findAllByOrderByCreatedAtDesc() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(productCancelService.findAllByOrderByCreatedAtDesc())
                .build();
    }

    @GetMapping("/getAllByOrderByQuantityAsc")
    public ObjectResponseWrapper findAllByOrderByQuantityAsc() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(productCancelService.findAllByOrderByQuantityAsc())
                .build();
    }

    @GetMapping("/getAllByOrderByQuantityDesc")
    public ObjectResponseWrapper findAllByOrderByQuantityDesc() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(productCancelService.findAllByOrderByQuantityDesc())
                .build();
    }

    @PostMapping("/create")
    public ObjectResponseWrapper createProductCancel(@RequestBody ProductCancelDTO productCancelDTO) {
        try {
            ProductCancel productCancelCreate = productCancelDTO.toEntity();
            productCancelCreate = productCancelService.createProductCancel(productCancelCreate);
            productCancelCreate.setCreatedAt(new Date());

            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Tạo dữ liệu thành công.")
                    .data(productCancelCreate)
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
    public ObjectResponseWrapper updateProductCancelInfoById(@RequestBody ProductCancelDTO productCancelDTO, @PathVariable Long productCancelId) {
        try {
            ProductCancel check = productCancelService.findById(productCancelId);
            if (check == null) {
                throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
            }
            check.setQuantity(productCancelDTO.getQuantity());
            check.setUnitPrice(productCancelDTO.getUnitPrice());
            check.setProduct(productService.findById(productCancelDTO.getProductId()));
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
    public ObjectResponseWrapper deleteProductCancel(@PathVariable Long productCancelId) {
        ProductCancel check = productCancelService.findById(productCancelId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        productCancelService.delete(productCancelId);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Xoá dữ liệu thành công.")
                .build();
    }
}
