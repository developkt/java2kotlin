package com.example.java2kotlin.web;

import com.example.java2kotlin.db.Order;
import com.example.java2kotlin.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController()
@RequestMapping("/customers")
public class CustomerOrderController {

    private final OrderService orderService;

    public CustomerOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{customerId}")
    public List<Order> getOrders(@PathVariable("customerId") String customerId) {
        return orderService.findOrdersForCustomer(customerId);
    }

    @GetMapping("/{customerId}/orders/{id}/price")
    public BigDecimal getTotalPrice(@PathVariable("customerId") String customerId, @PathVariable("id") String id) {
        return orderService.getSumOfOrderItems(customerId, id);
    }

}
