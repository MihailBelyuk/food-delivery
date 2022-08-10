package com.solvd.belyuk.fooddelivery.entity.vehicle;

public interface IRepair extends IDoService<SparePart> {

    void checkIfNeedsRepair();

}
