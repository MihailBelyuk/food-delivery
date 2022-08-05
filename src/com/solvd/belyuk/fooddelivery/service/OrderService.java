package com.solvd.belyuk.fooddelivery.service;

import com.solvd.belyuk.fooddelivery.entity.Address;

public class OrderService {

    public static int showDeliveryDistance(Address address) {
        String clientDistrict = address.getDistrict();
        int distanceKm = 0;
        switch (clientDistrict) {
            case "Central":
                distanceKm = 10;
                break;
            case "Pervomayskiy":
                distanceKm = 15;
                break;
            case "Frunzenskiy":
                distanceKm = 5;
                break;
            default:
                break;
        }
        return distanceKm;
    }

}
