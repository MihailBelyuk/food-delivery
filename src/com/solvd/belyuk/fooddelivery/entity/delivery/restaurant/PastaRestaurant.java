package com.solvd.belyuk.fooddelivery.entity.delivery.restaurant;

import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dish.Dish;

import java.util.List;

public class PastaRestaurant extends Restaurant {

    public PastaRestaurant(String restaurantName, List<Dish> dishes) {
        super(restaurantName, dishes);
    }
}
