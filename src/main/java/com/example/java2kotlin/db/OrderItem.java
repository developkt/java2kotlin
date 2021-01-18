package com.example.java2kotlin.db;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderItem {

    private String productId;

    private Integer quantity;

    private BigDecimal price;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(productId, orderItem.productId) &&
                Objects.equals(quantity, orderItem.quantity) &&
                Objects.equals(price, orderItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, quantity, price);
    }
}
