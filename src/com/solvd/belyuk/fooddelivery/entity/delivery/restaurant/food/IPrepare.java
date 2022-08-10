package com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.food;

public interface IPrepare<T extends Food> {

    void prepare(T food);

}
