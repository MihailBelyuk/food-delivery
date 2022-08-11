package com.solvd.belyuk.fooddelivery.entity.vehicle;

public interface IDoService<P extends SparePart> {

    void replace(P sparePart);

}
