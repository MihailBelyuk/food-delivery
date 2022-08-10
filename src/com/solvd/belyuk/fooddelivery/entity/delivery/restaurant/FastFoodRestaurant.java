package com.solvd.belyuk.fooddelivery.entity.delivery.restaurant;

import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dish.Dish;

import java.util.List;

public class FastFoodRestaurant extends Restaurant {

    public FastFoodRestaurant(String restaurantName, List<Dish> dishes) {
        super(restaurantName, dishes);
    }
}