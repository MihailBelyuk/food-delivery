package com.solvd.belyuk.fooddelivery.service;

public class CourierService {

    public static int adjustCourierSpeed(String courierType) {
        int speed = 0;
        switch (courierType) {
            case "bike":
                speed = 15;
                break;
            case "car":
                speed = 60;
                break;
            case "walk":
                speed = 5;
                break;
            default:
                break;
        }
        return speed;
    }

    public int adjustCourierSpeed(String courierType, String courierName) {
        int speed = 0;
        if ("Dima".equals(courierName) && "car".equals(courierType)) {
            speed = 50;
        }
        return speed;
    }
}
