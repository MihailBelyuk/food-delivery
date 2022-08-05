package com.solvd.belyuk.fooddelivery.entity.delivery.restaurant;

import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.Dish;

public class FastFoodRestaurant extends Restaurant {

    public FastFoodRestaurant(String restaurantName, Dish[] dishes) {
        super(restaurantName, dishes);
    }
}