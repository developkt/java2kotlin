package com.example.java2kotlin.service;

import com.example.java2kotlin.db.Order;
import com.example.java2kotlin.db.OrderItem;
import com.example.java2kotlin.db.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findOrdersForCustomer(String customerId) {
        List<Order> orders = orderRepository.findAllByCustomerId(customerId);

        orders.forEach(this::printOderStatus);

        return orders;
    }

    public BigDecimal getSumOfOrderItems(String customerId, String orderId) {
        BigDecimal sum = orderRepository.findByCustomerIdAndOrderId(customerId, orderId)
                .map(order -> order.getOrderItems().stream()
                        .map(OrderItem::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .orElse(BigDecimal.ZERO);

        if (BigDecimal.ZERO.equals(sum)) {
            logger.warn("Sum of items for orderId={} is zero", orderId);
        }

        return sum;
    }

    private void printOderStatus(Order order) {
        switch (order.getOrderType()) {
            case FULFILLED:
                logger.info("Order with id={} is already fulfilled.", order.getOrderId());
                break;
            case OPEN:
                logger.info("Order with id={} is still open.", order.getOrderId());
                break;
            case CANCELED_BY_CUSTOMER:
                logger.info("Customer with id={} cancelled order with id={}.", order.getCustomerId(), order.getOrderId());
                break;
        }
    }


}
