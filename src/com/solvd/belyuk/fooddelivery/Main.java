package com.solvd.belyuk.fooddelivery;

import com.solvd.belyuk.fooddelivery.entity.Address;
import com.solvd.belyuk.fooddelivery.entity.delivery.Delivery;
import com.solvd.belyuk.fooddelivery.entity.delivery.order.GeneralOrder;
import com.solvd.belyuk.fooddelivery.entity.delivery.order.Order;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.Restaurant;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.Dish;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.ingredient.Ingredient;
import com.solvd.belyuk.fooddelivery.entity.person.Client;
import com.solvd.belyuk.fooddelivery.entity.person.Courier;
import com.solvd.belyuk.fooddelivery.entity.person.Employee;
import com.solvd.belyuk.fooddelivery.entity.vehicle.Car;
import com.solvd.belyuk.fooddelivery.entity.vehicle.Vehicle;
import com.solvd.belyuk.fooddelivery.entity.vehicle.WvGolf;
import com.solvd.belyuk.fooddelivery.exception.TooBigValueException;
import com.solvd.belyuk.fooddelivery.exception.WrongAgeException;
import com.solvd.belyuk.fooddelivery.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Delivery delivery = new Delivery();
        delivery.setRestaurants(Creator.createFastFoodRestaurants());
        delivery.setCouriers(Creator.createCouriers());

        Client client = new Client("Hugh Laurie", LocalDate.of(1959, 6, 11));
        Address address = new Address();
        address.setCity("Minsk");
        address.setDistrict("Central");
        address.setStreet("Prospekt nezavisimosti");
        address.setHouseNumber("56");
        client.setAddress(address);

        Restaurant restaurant = delivery.getRestaurants()[1];

        Dish dish1 = restaurant.getDishes()[0];
        dish1.setDishQuantity(2);
        Ingredient[] ingredients1 = dish1.getIngredients();
        ingredients1[0].setPresent(true);
        ingredients1[1].setPresent(true);
        Dish dish2 = restaurant.getDishes()[1];
        dish2.setDishQuantity(5);
        Ingredient[] ingredients2 = dish2.getIngredients();
        ingredients2[0].setPresent(false);
        Dish[] orderDishes = new Dish[]{dish1, dish2};

        Courier courier = delivery.getCouriers()[0];
        courier.setCar(new WvGolf("WV Golf", 30_000));
        Car car = courier.getCar();
        car.setOdometerCurrent(1000_000_000);
        car.setNextAirFilterService(45000);

        try {
            VehicleService.changeOil(car);
        } catch (TooBigValueException e) {
            LOGGER.error("Caught 'TooBigValueException'. ", e);
        } finally {
            LOGGER.info("Set default value for the odometer in finally block.");
            int odometerDefault = 100_000;
            car.setOdometerCurrent(odometerDefault);
        }

        VehicleService.changeAirFilter(car);
        VehicleService.checkIfRepairIsNeeded(car);

        int deliveryDistance = OrderService.showDeliveryDistance(client.getAddress());

        GeneralOrder order = new GeneralOrder(courier, client, deliveryDistance);
        order.setDiscount(30);
        order.setRestaurant(restaurant);
        order.setDishes(orderDishes);

        Order[] orders = new Order[]{order};
        delivery.setOrders(orders);

        LOGGER.info("Order delivery time: " + DeliveryService.countDeliveryTime(delivery) + " minutes");
        LOGGER.info("Order price: " + DeliveryService.countOrderPrice(delivery));
        LOGGER.info("Client age: " + ClientService.countAge(client));
        LOGGER.info("Order price with discount: " + order.countOrderPriceWithDiscount(order.getDishes()));

        Employee employee = new Courier("Zhenya", LocalDate.of(2000, 4, 19));
        employee.setHiringDate(LocalDate.of(2020, 5, 12));
        LOGGER.info("Working period: " + employee.countWorkingPeriod());
        DeliveryService.showPersonInfo(employee);
        DeliveryService.showPersonInfo(client);

        LOGGER.info("Number of couriers working in delivery." + DeliveryService.countCourierQuantity(delivery));

        LOGGER.info("Number of dishes in restaurant menu." + RestaurantService.countDishes(restaurant));

        for (Dish meal : order.getRestaurant().getDishes()) {
            RestaurantService.prepareDish(meal);
        }

        try (TryWithResourceClass tryWithResource = new TryWithResourceClass()) {
            tryWithResource.countMyAge(LocalDate.of(2020, 1, 20));
        } catch (WrongAgeException e) {
            LOGGER.error("Wrong age result.", e);
        }

        Vehicle car2= new Car("Mitsubishi Lancer EVO X",15000);
        Vehicle car3 = new Car("Subaru WRX STI",20000);
       
    }
}




