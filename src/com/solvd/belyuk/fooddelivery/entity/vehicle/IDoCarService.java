package com.solvd.belyuk.fooddelivery.entity.vehicle;

import com.solvd.belyuk.fooddelivery.exception.TooBigValueException;

public interface IDoCarService extends IDoService<SparePart> {

    void changeOil() throws TooBigValueException;

    void checkIfAirFilterChangeNeeded();

}
