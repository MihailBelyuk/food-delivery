package com.solvd.belyuk.fooddelivery.service;

import com.solvd.belyuk.fooddelivery.entity.vehicle.IDoService;
import com.solvd.belyuk.fooddelivery.entity.vehicle.IRepair;
import com.solvd.belyuk.fooddelivery.exception.TooBigValueException;
import com.solvd.belyuk.fooddelivery.entity.vehicle.Vehicle;

public class VehicleService {

    public static void changeOil(IDoService iDoService) throws TooBigValueException {
        iDoService.changeOil();
    }

    public static void changeAirFilter(IDoService iDoService){
        iDoService.changeAirFilter();
    }
    public static void checkIfRepairIsNeeded(IRepair iRepair){
        Vehicle vehicle = (Vehicle) iRepair;
        vehicle.checkIfNeedsRepair();
    }
}
