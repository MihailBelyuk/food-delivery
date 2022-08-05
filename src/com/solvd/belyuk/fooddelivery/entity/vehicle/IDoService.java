package com.solvd.belyuk.fooddelivery.entity.vehicle;

import com.solvd.belyuk.fooddelivery.exception.TooBigValueException;

public interface IDoService {

    void changeOil() throws TooBigValueException;

    void changeAirFilter();

}
