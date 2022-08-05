package com.solvd.belyuk.fooddelivery.entity.delivery;

import com.solvd.belyuk.fooddelivery.entity.Address;
import com.solvd.belyuk.fooddelivery.entity.delivery.order.Order;
import com.solvd.belyuk.fooddelivery.entity.delivery.order.Payment;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.Restaurant;
import com.solvd.belyuk.fooddelivery.entity.person.Courier;
import com.solvd.belyuk.fooddelivery.entity.person.Director;

import java.util.Arrays;

public class Delivery implements ICountQuantity {

    private Restaurant[] restaurants;
    private Courier[] couriers;
    private Payment[] payments;
    private Order[] orders;
    private Address address;
    private Director director;

    @Override
    public int countQuantity() {
        return couriers.length;
    }

    public Restaurant[] getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurant[] restaurants) {
        this.restaurants = restaurants;
    }

    public Courier[] getCouriers() {
        return couriers;
    }

    public void setCouriers(Courier[] couriers) {
        this.couriers = couriers;
    }

    public Payment[] getPayments() {
        return payments;
    }

    public void setPayments(Payment[] payments) {
        this.payments = payments;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Delivery delivery = (Delivery) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(restaurants, delivery.restaurants)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(couriers, delivery.couriers)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(payments, delivery.payments)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(orders, delivery.orders)) return false;
        if (address != null ? !address.equals(delivery.address) : delivery.address != null) return false;
        return director != null ? director.equals(delivery.director) : delivery.director == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(restaurants);
        result = 31 * result + Arrays.hashCode(couriers);
        result = 31 * result + Arrays.hashCode(payments);
        result = 31 * result + Arrays.hashCode(orders);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Delivery{");
        sb.append("restaurants=").append(Arrays.toString(restaurants));
        sb.append(", couriers=").append(Arrays.toString(couriers));
        sb.append(", payments=").append(Arrays.toString(payments));
        sb.append(", orders=").append(Arrays.toString(orders));
        sb.append(", address=").append(address);
        sb.append(", director=").append(director);
        sb.append('}');
        return sb.toString();
    }
}
