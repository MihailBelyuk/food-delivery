package com.solvd.belyuk.fooddelivery.service;

import com.solvd.belyuk.fooddelivery.entity.delivery.order.Payment;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.FastFoodRestaurant;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.Restaurant;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.Dish;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.FriedChicken;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.Hamburger;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.Pizza;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.ingredient.ChickenMeat;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.ingredient.ChickenWings;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.ingredient.ChilliPepper;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.ingredient.Ingredient;
import com.solvd.belyuk.fooddelivery.entity.person.Courier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.time.Month.*;

public class Creator {

    public static Restaurant[] createFastFoodRestaurants() {
        Ingredient chickenWings = new ChickenWings("Chicken wings");
        Ingredient chilliPepper = new ChilliPepper("Chilli pepper");
        Ingredient chickenMeat = new ChickenMeat("Chicken meat");
        Ingredient[] hotWingsIngredients = {chickenWings, chilliPepper};
        Ingredient[] nuggetsIngredients = {chickenMeat};
        Ingredient[] stripsIngredients = {chickenMeat};

        Dish pepperoni = new Pizza("Pepperoni", 15);
        pepperoni.setPrice(new BigDecimal(10));
        Dish italiano = new Pizza("Italiano", 16);
        italiano.setPrice(new BigDecimal(12));
        Dish bbqPizza = new Pizza("BBQ Pizza", 20);
        bbqPizza.setPrice(new BigDecimal(9));
        Dish[] pizzaHutDishes = {pepperoni, italiano, bbqPizza};
        Restaurant pizzaHut = new FastFoodRestaurant("Pizza Hut", pizzaHutDishes);

        Dish hotWings = new FriedChicken("Hot wings", 4, hotWingsIngredients);
        hotWings.setPrice(new BigDecimal(7));
        Dish nuggets = new FriedChicken("Nuggets", 8, nuggetsIngredients);
        nuggets.setPrice(new BigDecimal(9));
        Dish strips = new FriedChicken("Strips", 7, stripsIngredients);
        strips.setPrice(new BigDecimal(9));
        Dish[] kfcDishes = {hotWings, nuggets, strips};
        Restaurant kfc = new FastFoodRestaurant("KFC", kfcDishes);

        Dish whopper = new Hamburger("Whopper", 12);
        whopper.setPrice(new BigDecimal(10));
        Dish bigKing = new Hamburger("Big King", 11);
        bigKing.setPrice(new BigDecimal(9));
        Dish hamburger = new Hamburger("Hamburger", 7);
        hamburger.setPrice(new BigDecimal(7));
        Dish[] burgerKingDishes = new Hamburger[3];
        Restaurant burgerKing = new FastFoodRestaurant("Burger King", burgerKingDishes);
        return new Restaurant[]{pizzaHut, kfc, burgerKing};
    }

    public static Courier[] createCouriers() {
        Courier andrey = new Courier("Andrey", LocalDate.of(1990, JANUARY, 2));
        andrey.setCourierType("car");
        Courier vasia = new Courier("Vasia", LocalDate.of(1991, MARCH, 3));
        vasia.setCourierType("walk");
        Courier petya = new Courier("Petya", LocalDate.of(1992, APRIL, 4));
        petya.setCourierType("bike");
        return new Courier[]{andrey, vasia, petya};
    }

    public static Payment[] createPaymentTypes() {
        Payment cash = new Payment();
        cash.setPaymentType("cash");
        Payment creditCard = new Payment();
        creditCard.setPaymentType("credit card");
        return new Payment[]{cash, creditCard};
    }
}
