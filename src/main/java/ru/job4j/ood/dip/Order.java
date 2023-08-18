package ru.job4j.ood.dip;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {

    private int id;

    private boolean isPayed;

    private Map<Integer, Product> products = new HashMap<>();

    public boolean add(Product product) {
        if (products.containsKey(product.getId())) {
            return false;
        }
        return products.put(product.getId(), product) != null;
    }

    public boolean remove(int id) {
        return products.remove(id) != null;
    }

    public void clear() {
        products.clear();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


//package ru.job4j.ood.dip;
//
//public class SimpleOrderService implements OrderService {
//
//    private OrderStore orderStore;
//
//    public SimpleOrderStore(OrderStore orderStore) {
//        this.orderStore = orderStore;
//    }
//}
//
//    private OrderService orderService;
//
//    public SimpleShopService(ShopStore shopStore, OrderService orderService) {
//        this.shopStore = shopStore;
//        this.orderService = orderService;
//    }