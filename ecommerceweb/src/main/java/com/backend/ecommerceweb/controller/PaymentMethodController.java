package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.PaymentMethod;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.order.PaymentMethodDTO;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION+"/paymentMethod")
public class PaymentMethodController extends BaseAPI {
    @PostMapping("/create")
    public ObjectResponseWrapper createPaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO) {
        try {
            PaymentMethod paymentMethodCreate = mapper.map(paymentMethodDTO, PaymentMethod.class);
            paymentMethodCreate = paymentMethodService.createPaymentMethod(paymentMethodCreate);

            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Tạo dữ liệu thành công.")
                    .data(paymentMethodCreate)
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
    public ObjectResponseWrapper updatePaymentMethodInfoById(@RequestBody PaymentMethodDTO paymentMethodDTO, @PathVariable Long paymentMethodId) {
        try {
            PaymentMethod check = paymentMethodService.findById(paymentMethodId);
            if (check == null) {
                throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
            }
            check.setName(paymentMethodDTO.getName());
            check.setImgUrl(paymentMethodDTO.getImgUrl());
            check.setMaxTransfer(paymentMethodDTO.getMaxTransfer());
            check.setMinTransfer(paymentMethodDTO.getMinTransfer());

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
    public ObjectResponseWrapper getAllPaymentMethods() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(paymentMethodService.findAll())
                .build();
    }

    @GetMapping("/get/{paymentMethodId}")
    public ObjectResponseWrapper findById(@PathVariable Long paymentMethodId) {
        PaymentMethod check = paymentMethodService.findById(paymentMethodId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public ObjectResponseWrapper deletePaymentMethod(@PathVariable Long paymentMethodId) {
        PaymentMethod check = paymentMethodService.findById(paymentMethodId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        paymentMethodService.delete(paymentMethodId);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Xoá dữ liệu thành công.")
                .build();
    }
    @GetMapping("/getByImgUrl/{imgUrl}")
    public ObjectResponseWrapper findByImgUrlContaining(@PathVariable String imgUrl) {
       List<PaymentMethod> check = paymentMethodService.findByImgUrlContaining(imgUrl);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }
    @GetMapping("/getByMinTransfer/{minTransfer}")
    public ObjectResponseWrapper findByMinTransfer(@PathVariable Double minTransfer) {
        List<PaymentMethod> check = paymentMethodService.findByMinTransfer(minTransfer);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getByMinTransferLessThanEqual/{minTransfer}")
    public ObjectResponseWrapper findByMinTransferLessThanEqual(@PathVariable Double minTransfer) {
        List<PaymentMethod> check = paymentMethodService.findByMinTransferLessThanEqual(minTransfer);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getByMinTransferGreaterThanEqual/{minTransfer}")
    public ObjectResponseWrapper findByMinTransferGreaterThanEqual(@PathVariable Double minTransfer) {
        List<PaymentMethod> check = paymentMethodService.findByMinTransferGreaterThanEqual(minTransfer);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }
    @GetMapping("/getByMaxTransfer/{maxTransfer}")
    public ObjectResponseWrapper findByMaxTransfer(@PathVariable Double maxTransfer) {
        List<PaymentMethod> check = paymentMethodService.findByMaxTransfer(maxTransfer);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }
    @GetMapping("/getByMaxTransferLessThanEqual/{maxTransfer}")
    public ObjectResponseWrapper findByMaxTransferLessThanEqual(@PathVariable Double maxTransfer) {
        List<PaymentMethod> check = paymentMethodService.findByMaxTransferLessThanEqual(maxTransfer);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getByMaxTransferGreaterThanEqual/{maxTransfer}")
    public ObjectResponseWrapper findByMaxTransferGreaterThanEqual(@PathVariable Double maxTransfer) {
        List<PaymentMethod> check = paymentMethodService.findByMaxTransferGreaterThanEqual(maxTransfer);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }


}
