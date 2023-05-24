package com.example.locationsharing.model;

import androidx.annotation.Keep;

@Keep
public class Order {
    private final Jewellery jewellery;
    private final int quantity;
    private final Long OrderDate;
//    private String address;
//    private String phone;

    public Order(Jewellery jewellery) {
        this.jewellery = jewellery;
        this.quantity = 1;
        OrderDate = System.currentTimeMillis();
    }

    public Order(Jewellery jewellery, int quantity) {
        this.jewellery = jewellery;
        this.quantity = quantity;
        OrderDate = System.currentTimeMillis();
    }

    public Order(Jewellery jewellery, int quantity, Long orderDate) {
        this.jewellery = jewellery;
        this.quantity = quantity;
        OrderDate = orderDate;
    }

    public Jewellery getJewellery() {
        return jewellery;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getOrderDate() {
        return OrderDate;
    }
}
