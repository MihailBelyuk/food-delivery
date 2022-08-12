package com.solvd.belyuk.fooddelivery.entity.vehicle;

public interface IReplace<P extends SparePart> {

    void replace(P sparePart);

}
