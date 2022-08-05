package com.solvd.belyuk.fooddelivery.entity.delivery.restaurant;

import com.solvd.belyuk.fooddelivery.entity.delivery.ICountQuantity;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.Dish;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Restaurant implements ICountQuantity {

    private static final Logger LOGGER = LogManager.getLogger(Restaurant.class);

    private String restaurantName;
    private Dish[] dishes;

    public Restaurant(String restaurantName, Dish[] dishes) {
        this.restaurantName = restaurantName;
        this.dishes = dishes;
    }

    @Override
    public int countQuantity() {
        LOGGER.info("Amount of dishes: " + this.dishes.length);
        return this.dishes.length;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Dish[] getDishes() {
        return dishes;
    }

    public void setDishes(Dish[] dishes) {
        this.dishes = dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (restaurantName != null ? !restaurantName.equals(that.restaurantName) : that.restaurantName != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(dishes, that.dishes);
    }

    @Override
    public int hashCode() {
        int result = restaurantName != null ? restaurantName.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(dishes);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Restaurant{");
        sb.append("restaurantName='").append(restaurantName).append('\'');
        sb.append(", dishes=").append(Arrays.toString(dishes));
        sb.append('}');
        return sb.toString();
    }
}
