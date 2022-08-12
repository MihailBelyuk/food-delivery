package com.solvd.belyuk.fooddelivery.entity.vehicle;

public interface IRepair extends IReplace<SparePart>{

    void checkIfNeedsRepair();

}
