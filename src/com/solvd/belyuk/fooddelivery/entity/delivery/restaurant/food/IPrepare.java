package com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.food;

public interface IPrepare<F extends Food> {

    void prepare(F food);

}
