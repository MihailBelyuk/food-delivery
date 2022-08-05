package com.solvd.belyuk.fooddelivery.service;

import com.solvd.belyuk.fooddelivery.entity.person.Client;
import com.solvd.belyuk.fooddelivery.entity.person.ICountTimePeriod;

public class ClientService {

    public static int countAge(ICountTimePeriod iCountTimePeriod) {
        Client client = (Client) iCountTimePeriod;
        return client.countYears();
    }
}
