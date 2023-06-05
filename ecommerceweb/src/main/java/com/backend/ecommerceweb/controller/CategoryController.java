package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.Category;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.product.CategoryDTO;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION + "/category")
public class CategoryController extends BaseAPI {
    @GetMapping("/getByName/{name}")
    public ObjectResponseWrapper findByName(@PathVariable String name) {
        List<Category> check = categoryService.findByName(name);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check).build();
    }

    @GetMapping("/getById/{id}")
    public ObjectResponseWrapper findById(@PathVariable Long id) {
        Category check = categoryService.findById(id);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check).build();
    }

    @GetMapping("/getByNameContaining/{name}")
    public ObjectResponseWrapper findByNameContaining(@PathVariable String name) {
        List<Category> check = categoryService.findByNameContaining(name);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check).build();
    }

    @GetMapping("/getByDes/{des}")
    public ObjectResponseWrapper findByDescriptionContaining(@PathVariable String description) {
        List<Category> check = categoryService.findByDescriptionContaining(description);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check).build();
    }

    @GetMapping("/getAll")
    public ObjectResponseWrapper findAll() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(categoryService.findAll()).build();
    }

    @GetMapping("/getAllByOrderByNameAsc")
    public ObjectResponseWrapper findAllByOrderByNameAsc() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(categoryService.findAllByOrderByNameAsc()).build();
    }

    @GetMapping("/getAllByOrderByIdAsc")
    public ObjectResponseWrapper findAllByOrderByIdAsc() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(categoryService.findAllByOrderByIdAsc()).build();
    }

    @PostMapping("/create")
    public ObjectResponseWrapper createCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            Category create = mapper.map(categoryDTO, Category.class);
            create = categoryService.createCategory(create);

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
    public ObjectResponseWrapper updateById(@RequestBody CategoryDTO categoryDTO, @PathVariable Long id) {
        Category check = categoryService.findById(id);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        check.setName(categoryDTO.getName());
        check.setDescription(categoryDTO.getDescription());
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Cập nhật dữ liệu thành công.")
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public ObjectResponseWrapper deleteById(@PathVariable Long id) {
        Category check = categoryService.findById(id);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        categoryService.deleteById(id);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Xoá dữ liệu thành công.").
                build();
    }
}
