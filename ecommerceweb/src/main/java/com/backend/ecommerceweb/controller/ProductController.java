package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.Product;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.product.ProductDTO;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION+"/product")
public class ProductController extends BaseAPI {
    @GetMapping("/getAllByCategory/{categoryId}")
    public ObjectResponseWrapper findAllByCategory(@PathVariable Long categoryId) {
        List<Product> check = productService.findAllByCategory(categoryId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/findByCost/{cost}")
    public ObjectResponseWrapper findByCost(@PathVariable Double cost) {
        List<Product> check = productService.findByCost(cost);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }
    @GetMapping("/findBySupplier/{supplierId}")
    public ObjectResponseWrapper findBySupplier(@PathVariable Long supplierId) {
        List<Product> check = productService.findBySupplier(supplierId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/findByPrice/{price}")
    public ObjectResponseWrapper findByPrice(@PathVariable Double price) {
        List<Product> check = productService.findByPrice(price);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getAllByPriceBetween/{minPrice}-{maxPrice}")
    public ObjectResponseWrapper findAllByPriceBetween(@PathVariable Double minPrice, @PathVariable Double maxPrice) {
        List<Product> check = productService.findAllByPriceBetween(minPrice, maxPrice);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/findByCostBetween/{minCost}-{maxCost}")
    public ObjectResponseWrapper findByCostBetween(@PathVariable Double minCost, @PathVariable Double maxCost) {
        List<Product> check = productService.findByCostBetween(minCost, maxCost);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }


    @GetMapping("/findByPriceLessThan/{minPrice}")
    public ObjectResponseWrapper findByPriceLessThan(@PathVariable Double minPrice) {
        List<Product> check = productService.findByPriceLessThan(minPrice);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/findByCostLessThan/{cost}")
    public ObjectResponseWrapper findByCostLessThan(@PathVariable Double cost) {
        List<Product> check = productService.findByCostLessThan(cost);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }
    @GetMapping("/findByPriceGreaterThan/{maxPrice}")
    public ObjectResponseWrapper findByPriceGreaterThan(@PathVariable Double maxPrice) {
        List<Product> check = productService.findByPriceGreaterThan(maxPrice);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/findByCostGreaterThan/{cost}")
    public ObjectResponseWrapper findByCostGreaterThan(@PathVariable Double cost) {
        List<Product> check = productService.findByCostGreaterThan(cost);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/list")
    public ObjectResponseWrapper getAllProducts() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(productService.findAll())
                .build();
    }

    @GetMapping("/get/{productId}")
    public ObjectResponseWrapper findById(@PathVariable Long productId) {
        Product check = productService.findById(productId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @PostMapping("/create")
    public ObjectResponseWrapper createProduct(@RequestBody ProductDTO productDTO) {
        try {
            Product productCreate = productDTO.toEntity();
            productCreate = productService.createProduct(productCreate);

            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Tạo dữ liệu thành công.")
                    .data(productCreate)
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
    public ObjectResponseWrapper updateProductInfoById(@RequestBody ProductDTO productDTO, @PathVariable Long productId) {
        try {
            Product check = productService.findById(productId);
            if (check == null) {
                throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
            }
            check.setName(productDTO.getName());
            check.setCategory(categoryService.findById(productDTO.getCategoryId()));
            check.setSupplier(supplierService.findById(productDTO.getSupplierId()));
            check.setPrice(productDTO.getPrice());
            check.setCost(productDTO.getCost());

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
    public ObjectResponseWrapper deleteProduct(@PathVariable Long productId) {
        Product check = productService.findById(productId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        productService.delete(productId);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Xoá dữ liệu thành công.")
                .build();
    }


}
