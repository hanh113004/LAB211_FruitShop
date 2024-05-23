package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private String customerName;
    private HashMap<Integer,Fruit> order;

    public Order() {
        order = new HashMap<>();
    }

    public Order(String customerName, HashMap<Integer,Fruit> order) {
        this.customerName = customerName;
        this.order = order;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<Integer, Fruit> getOrder() {
        return order;
    }

    public void setOrder(HashMap<Integer, Fruit> order) {
        this.order = order;
    }
}
