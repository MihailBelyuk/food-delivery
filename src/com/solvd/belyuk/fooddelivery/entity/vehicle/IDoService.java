package com.solvd.belyuk.fooddelivery.entity.vehicle;

import com.solvd.belyuk.fooddelivery.exception.TooBigValueException;

public interface IDoService extends IReplace<SparePart>{

    void change() throws TooBigValueException;

}
