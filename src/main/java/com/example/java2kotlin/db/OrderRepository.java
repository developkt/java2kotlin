package com.example.java2kotlin.db;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class OrderRepository {

    private final Map<String, List<Order>> orders = new HashMap<>();

    public OrderRepository() {
        List<Order> ordersForCustomer1 = Arrays.asList(
                generateDummyOrder("1", 1, OrderStatus.OPEN),
                generateDummyOrder("1", 2, OrderStatus.OPEN),
                generateDummyOrder("1", 3, OrderStatus.CANCELED_BY_CUSTOMER),
                generateDummyOrder("1", 4, OrderStatus.FULFILLED)
        );

        List<Order> ordersForCustomer2 = Arrays.asList(
                generateDummyOrder("2", 1, OrderStatus.CANCELED_BY_CUSTOMER),
                generateDummyOrder("2", 2, OrderStatus.FULFILLED),
                generateDummyOrder("2", 3, OrderStatus.FULFILLED),
                generateDummyOrder("2", 4, OrderStatus.FULFILLED)
        );

        orders.put("1", ordersForCustomer1);
        orders.put("2", ordersForCustomer2);
    }

    public List<Order> findAllByCustomerId(String customerId) {
        return orders.getOrDefault(customerId, Collections.emptyList());
    }

    public Optional<Order> findByCustomerIdAndOrderId(String customerId, String orderId) {
        List<Order> orderForCustomer = orders.get(customerId);
        List<Order> orderById = orderForCustomer.stream()
                .filter( order -> orderId.equals(order.getOrderId())).collect(Collectors.toList());

        if (orderById.size() == 1) {
            return Optional.of(orderById.get(0));
        } else {
            return Optional.empty();
        }
    }

    private Order generateDummyOrder(String customerId, Integer daysInPast, OrderStatus type) {
        Order order = new Order();

        order.setOrderId(UUID.randomUUID().toString());
        order.setCustomerId(customerId);
        order.setOrderDate(OffsetDateTime.now().minusDays(daysInPast));
        order.setOrderType(type);
        order.setOrderItems(Arrays.asList(
                generateRandomItem(),
                generateRandomItem(),
                generateRandomItem(),
                generateRandomItem()
        ));

        return order;
    }

    private OrderItem generateRandomItem() {
        OrderItem item = new OrderItem();

        item.setProductId(UUID.randomUUID().toString());
        item.setQuantity(ThreadLocalRandom.current().nextInt(1, 10));
        item.setPrice(BigDecimal.valueOf(Math.random() * 10).setScale(2, RoundingMode.DOWN));

        return item;
    }

}
