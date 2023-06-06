package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.Order;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.order.OrderCreateDTO;
import com.backend.ecommerceweb.model.dtos.order.OrderUpdateDTO;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION + "/order")
public class OrderController extends BaseAPI {
    @PostMapping("/create")
    public ObjectResponseWrapper createOrder(@RequestBody OrderCreateDTO orderCreateDTO) {
        try {
            Order orderCreate = mapper.map(orderCreateDTO, Order.class);
            orderCreate = orderService.createOrder(orderCreate);

            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Tạo dữ liệu thành công.")
                    .data(orderCreate)
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
    public ObjectResponseWrapper updateOrderInfoById(@RequestBody OrderUpdateDTO orderUpdateDTO, @PathVariable Long orderId) {
        try {
            Order check = orderService.findById(orderId);
            if (check == null) {
                throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
            }
            check.setUpdatedDate(orderUpdateDTO.getUpdatedDate());
            check.setDeliveredDate(orderUpdateDTO.getDeliveredDate());
            check.setOrderStatus(orderUpdateDTO.getOrderStatus());
            check.setUpdatedUser(userService.findById(orderUpdateDTO.getUpdateUserId()));
            check.setIsDelivered(orderUpdateDTO.getIsDelivered());
            check.setShipper(shipperService.findById(orderUpdateDTO.getShipperId()));

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
    public ObjectResponseWrapper getAllOrders() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(orderService.findAll())
                .build();
    }

    @GetMapping("getAllByOrderDateDesc")
    public ObjectResponseWrapper findAllByOrderByOrderedDateDesc() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(orderService.findAllByOrderByOrderedDateDesc())
                .build();
    }

    @GetMapping("getAllByDeliveredDateDesc")
    public ObjectResponseWrapper findAllByOrderByDeliveredDateDesc() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(orderService.findAllByOrderByDeliveredDateDesc())
                .build();
    }

    @GetMapping("/getById/{id}")
    public ObjectResponseWrapper getOrderById(@PathVariable Long orderId) {
        Order check = orderService.findById(orderId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check).build();
    }

    @DeleteMapping("/delete/{id}")
    public ObjectResponseWrapper deleteOrder(@PathVariable Long orderId) {
        Order check = orderService.findById(orderId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        orderService.deleteById(orderId);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Xoá dữ liệu thành công.").build();
    }

    @GetMapping("getByOrderedDate/{date}-{month}-{year}")
    public ObjectResponseWrapper findByOrderedDate(@PathVariable int date, @PathVariable int month, @PathVariable int year) {
        Date d = new Date(year, month, date);
        List<Order> check = orderService.findByOrderedDate(d);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByOrderedDateAfter/{date}-{month}-{year}")
    public ObjectResponseWrapper findByOrderedDateGreaterThanEqual(@PathVariable int date, @PathVariable int month, @PathVariable int year) {
        Date d = new Date(year, month, date);
        List<Order> check = orderService.findByOrderedDateGreaterThanEqual(d);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByOrderedDateBefore/{date}-{month}-{year}")
    public ObjectResponseWrapper findByOrderedDateLessThanEqual(@PathVariable int date, @PathVariable int month, @PathVariable int year) {
        Date d = new Date(year, month, date);
        List<Order> check = orderService.findByOrderedDateLessThanEqual(d);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByOrderedDateBetween/{sDate}-{sMonth}-{sYear}/{eDate}-{eMonth}-{eYear}")
    public ObjectResponseWrapper findByOrderedDateBetween(@PathVariable int sDate, @PathVariable int sMonth, @PathVariable int sYear, @PathVariable int eDate, @PathVariable int eMonth, @PathVariable int eYear) {
        Date started = new Date(sYear, sMonth, sDate);
        Date ended = new Date(eYear, eMonth, eDate);
        List<Order> check = orderService.findByOrderedDateBetween(started, ended);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByDeliveredDate/{date}-{month}-{year}")
    public ObjectResponseWrapper findByDeliveredDate(@PathVariable int date, @PathVariable int month, @PathVariable int year) {
        Date d = new Date(year, month, date);
        List<Order> check = orderService.findByDeliveredDate(d);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByDeliveredDateAfter/{date}-{month}-{year}")
    public ObjectResponseWrapper findByDeliveredDateGreaterThanEqual(@PathVariable int date, @PathVariable int month, @PathVariable int year) {
        Date d = new Date(year, month, date);
        List<Order> check = orderService.findByDeliveredDateGreaterThanEqual(d);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByDeliveredDateBefore/{date}-{month}-{year}")
    public ObjectResponseWrapper findByDeliveredDateLessThanEqual(@PathVariable int date, @PathVariable int month, @PathVariable int year) {
        Date d = new Date(year, month, date);
        List<Order> check = orderService.findByDeliveredDateLessThanEqual(d);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByDeliveredDateBetween/{sDate}-{sMonth}-{sYear}/{eDate}-{eMonth}-{eYear}")
    public ObjectResponseWrapper findByDeliveredDateBetween(@PathVariable int sDate, @PathVariable int sMonth, @PathVariable int sYear, @PathVariable int eDate, @PathVariable int eMonth, @PathVariable int eYear) {
        Date started = new Date(sYear, sMonth, sDate);
        Date ended = new Date(eYear, eMonth, eDate);
        List<Order> check = orderService.findByDeliveredDateBetween(started, ended);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByUpdatedDate/{date}-{month}-{year}")
    public ObjectResponseWrapper findByUpdatedDate(@PathVariable int date, @PathVariable int month, @PathVariable int year) {
        Date d = new Date(year, month, date);
        List<Order> check = orderService.findByUpdatedDate(d);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByUpdatedDateAfter/{date}-{month}-{year}")
    public ObjectResponseWrapper findByUpdatedDateGreaterThanEqual(@PathVariable int date, @PathVariable int month, @PathVariable int year) {
        Date d = new Date(year, month, date);
        List<Order> check = orderService.findByUpdatedDateGreaterThanEqual(d);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByUpdatedDateBefore/{date}-{month}-{year}")
    public ObjectResponseWrapper findByUpdatedDateLessThanEqual(@PathVariable int date, @PathVariable int month, @PathVariable int year) {
        Date d = new Date(year, month, date);
        List<Order> check = orderService.findByUpdatedDateLessThanEqual(d);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("/getByUpdatedDateBetween/{sDate}-{sMonth}-{sYear}/{eDate}-{eMonth}-{eYear}")

    public ObjectResponseWrapper findByUpdatedDateBetween(@PathVariable int sDate, @PathVariable int sMonth, @PathVariable int sYear, @PathVariable int eDate, @PathVariable int eMonth, @PathVariable int eYear) {
        Date started = new Date(sYear, sMonth, sDate);
        Date ended = new Date(eYear, eMonth, eDate);
        List<Order> check = orderService.findByUpdatedDateBetween(started, ended);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByOrderStatus/{status}")
    public ObjectResponseWrapper findByOrderStatus(@PathVariable String status) {
        List<Order> check = orderService.findByOrderStatus(status);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByPaymentMethod/{methodId}")
    public ObjectResponseWrapper findByPaymentMethod(@PathVariable Long methodId) {
        List<Order> check = orderService.findByPaymentMethod(methodId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByCreatedUser/{userId}")
    public ObjectResponseWrapper findByCreatedUser(@PathVariable Long userId) {
        List<Order> check = orderService.findByCreatedUserId(userId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByUpdatedUser/{userId}")
    public ObjectResponseWrapper findByUpdatedUser(@PathVariable Long userId) {
        List<Order> check = orderService.findByUpdatedUserId(userId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("getByAddress/{addressId}")
    public ObjectResponseWrapper findByAddress(@PathVariable Long addressId) {
        List<Order> check = orderService.findByAddressId(addressId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("findByIsDelivered/{isDelivered}")
    public ObjectResponseWrapper findByIsDelivered(@PathVariable boolean isDelivered) {
        List<Order> check = orderService.findByIsDelivered(isDelivered);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }

    @GetMapping("findByShipper/{shipperId}")
    public ObjectResponseWrapper findByShipper(@PathVariable Long shipperId) {
        List<Order> check = orderService.findByShipper(shipperId);
        if (check == null) {
            throw new VeggyServiceException("Không tìm thấy dữ liệu theo yêu cầu.");
        }
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(check)
                .build();
    }
}
