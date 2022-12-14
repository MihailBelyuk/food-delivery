package com.solvd.belyuk.fooddelivery.service;

import com.solvd.belyuk.fooddelivery.entity.delivery.Delivery;
import com.solvd.belyuk.fooddelivery.entity.delivery.ICountQuantity;
import com.solvd.belyuk.fooddelivery.entity.delivery.order.Order;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.Dish;
import com.solvd.belyuk.fooddelivery.entity.person.Client;
import com.solvd.belyuk.fooddelivery.entity.person.Courier;
import com.solvd.belyuk.fooddelivery.entity.person.Human;
import com.solvd.belyuk.fooddelivery.exception.NegativeQuantityException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DeliveryService {

    private static final Logger LOGGER = LogManager.getLogger(DeliveryService.class);

    private static final int MINUTES_IN_HOUR = 60;

    public static double countDeliveryTime(Delivery delivery) {
        Order[] orders = delivery.getOrders();
        Order order = orders[0];
        Courier courier = order.getCourier();
        Client client = order.getClient();
        int courierSpeed = CourierService.adjustCourierSpeed(courier.getCourierType());
        double clientDistance = OrderService.showDeliveryDistance(client.getAddress());
        int orderPrepareTime = 0;
        for (Dish dish : order.getDishes()) {
            int dishSetPrepareTime = dish.getDishQuantity() * dish.getPrepareTimeMinutes();
            orderPrepareTime = orderPrepareTime + dishSetPrepareTime;
        }
        return clientDistance / courierSpeed * MINUTES_IN_HOUR + orderPrepareTime;
    }

    public static BigDecimal countOrderPrice(Delivery delivery) {
        Order[] orders = delivery.getOrders();
        Order order = orders[0];
        BigDecimal orderPrice = new BigDecimal(0);
        for (Dish dish : order.getDishes()) {
            BigDecimal dishSetPrice = dish.getPrice().multiply(new BigDecimal(dish.getDishQuantity()));
            orderPrice = orderPrice.add(dishSetPrice);
        }
        return orderPrice.setScale(2, RoundingMode.CEILING);
    }

    public static void showPersonInfo(Human human) {
        LOGGER.info(human.getName() + " " + human.getDateOfBirth().toString());
    }

    public static int countCourierQuantity(ICountQuantity iCountQuantity) throws NegativeQuantityException {
        if (iCountQuantity.countQuantity() < 0) {
            LOGGER.error("Negative quantity value caught.");
            throw new NegativeQuantityException("Negative quantity value caught.");
        }
        return iCountQuantity.countQuantity();
    }
}
