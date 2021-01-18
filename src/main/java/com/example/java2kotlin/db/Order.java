package com.example.java2kotlin.db;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

public class Order {

    private String orderId;

    private String customerId;

    private OffsetDateTime orderDate;

    private List<OrderItem> orderItems;

    private OrderStatus orderStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public OffsetDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(OffsetDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderStatus getOrderType() {
        return orderStatus;
    }

    public void setOrderType(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) &&
                Objects.equals(customerId, order.customerId) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(orderItems, order.orderItems) &&
                orderStatus == order.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, orderDate, orderItems, orderStatus);
    }
}
