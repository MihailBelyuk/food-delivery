package com.solvd.belyuk.fooddelivery.entity.vehicle;

import com.solvd.belyuk.fooddelivery.exception.TooBigValueException;

public interface IDoCarService extends IDoService{

    boolean checkIfEngineOilChangeNeeded() throws TooBigValueException;

    boolean checkIfAirFilterReplacementNeeded();

}
