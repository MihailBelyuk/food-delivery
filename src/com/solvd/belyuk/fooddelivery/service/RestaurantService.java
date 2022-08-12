package com.solvd.belyuk.fooddelivery.service;

import com.solvd.belyuk.fooddelivery.entity.delivery.ICountQuantity;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.food.ICook;

public class RestaurantService {

    public static int countDishes(ICountQuantity iCountQuantity) {
        return iCountQuantity.countQuantity();
    }

    public static void prepareDish(ICook iCook) {
        iCook.cook();
    }
}
