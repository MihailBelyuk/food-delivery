package com.solvd.belyuk.fooddelivery.entity.vehicle;

public interface IDoService<T extends SparePart> {

    void replace(T t);

}
