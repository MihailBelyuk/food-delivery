package com.solvd.belyuk.fooddelivery.entity.delivery.order;

import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.Dish;
import com.solvd.belyuk.fooddelivery.entity.person.Client;
import com.solvd.belyuk.fooddelivery.entity.person.Courier;
import com.solvd.belyuk.fooddelivery.exception.NegativePriceValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GeneralOrder extends Order {

    private static final Logger LOGGER = LogManager.getLogger(GeneralOrder.class);

    public GeneralOrder(Courier courier, Client client, int deliveryDistance) {
        super(courier, client, deliveryDistance);
    }

    @Override
    public BigDecimal countOrderPriceWithDiscount(Dish[] dishes) {
        BigDecimal orderPrice = new BigDecimal(0);
        for (Dish dish : dishes) {
            BigDecimal dishPrice = dish.getPrice().multiply(new BigDecimal(dish.getDishQuantity()));
            if (dishPrice.compareTo(new BigDecimal(0)) < 0) {
                LOGGER.error("Price value is negative.");
                throw new NegativePriceValueException("Price value is negative.");
            }
            orderPrice = orderPrice.add(dishPrice);
        }
        BigDecimal discount = new BigDecimal(getDiscount()).divide(new BigDecimal(100));
        return orderPrice.subtract(orderPrice.multiply(discount)).setScale(2, RoundingMode.CEILING);
    }
}
