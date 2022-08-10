package com.solvd.belyuk.fooddelivery.service;

import com.solvd.belyuk.fooddelivery.entity.vehicle.IDoCarService;
import com.solvd.belyuk.fooddelivery.entity.vehicle.IRepair;
import com.solvd.belyuk.fooddelivery.entity.vehicle.Vehicle;
import com.solvd.belyuk.fooddelivery.entity.vehicle.Wheel;
import com.solvd.belyuk.fooddelivery.exception.TooBigValueException;

public class VehicleService {

    public static void changeOil(IDoCarService iDoService) throws TooBigValueException {
        iDoService.changeOil();
    }

    public static void checkAirFilter(IDoCarService iDoService) {
        iDoService.checkIfAirFilterChangeNeeded();
    }

    public static void checkIfRepairIsNeeded(IRepair iRepair) {
        Vehicle vehicle = (Vehicle) iRepair;
        vehicle.checkIfNeedsRepair();
    }

    public static void replaceWheel(IDoCarService iDoCarService) {
        Wheel wheel = new Wheel();
        wheel.setBrand("Good Year");
        iDoCarService.replace(wheel);
    }
}
