package com.solvd.belyuk.fooddelivery.entity.delivery.order;

import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.Restaurant;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.Dish;
import com.solvd.belyuk.fooddelivery.entity.person.Client;
import com.solvd.belyuk.fooddelivery.entity.person.Courier;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public abstract class Order {

    private static long orderNumber;

    private Restaurant restaurant;
    private Courier courier;
    private Client client;
    private Payment payment;
    private Dish[] dishes;
    private LocalDateTime creationTime;
    private int deliveryDistance;
    private int discount;

    public Order(Courier courier,
                 Client client,
                 int deliveryDistance) {
        this.courier = courier;
        this.client = client;
        this.deliveryDistance = deliveryDistance;
        this.creationTime = LocalDateTime.now();

        orderNumber++;
    }

    public Dish[] getDishes() {
        return dishes;
    }

    public void setDishes(Dish[] dishes) {
        this.dishes = dishes;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public abstract BigDecimal countOrderPriceWithDiscount(Dish[] dishes);

    public static long getOrderNumber() {
        return orderNumber;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getDeliveryDistance() {
        return deliveryDistance;
    }

    public void setDeliveryDistance(int deliveryDistance) {
        this.deliveryDistance = deliveryDistance;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (deliveryDistance != order.deliveryDistance) return false;
        if (discount != order.discount) return false;
        if (restaurant != null ? !restaurant.equals(order.restaurant) : order.restaurant != null) return false;
        if (courier != null ? !courier.equals(order.courier) : order.courier != null) return false;
        if (client != null ? !client.equals(order.client) : order.client != null) return false;
        if (payment != null ? !payment.equals(order.payment) : order.payment != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(dishes, order.dishes)) return false;
        return creationTime != null ? creationTime.equals(order.creationTime) : order.creationTime == null;
    }

    @Override
    public int hashCode() {
        int result = restaurant != null ? restaurant.hashCode() : 0;
        result = 31 * result + (courier != null ? courier.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(dishes);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + deliveryDistance;
        result = 31 * result + discount;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("restaurant=").append(restaurant);
        sb.append(", courier=").append(courier);
        sb.append(", client=").append(client);
        sb.append(", payment=").append(payment);
        sb.append(", dishes=").append(Arrays.toString(dishes));
        sb.append(", creationTime=").append(creationTime);
        sb.append(", deliveryDistance=").append(deliveryDistance);
        sb.append(", discount=").append(discount);
        sb.append('}');
        return sb.toString();
    }
}

