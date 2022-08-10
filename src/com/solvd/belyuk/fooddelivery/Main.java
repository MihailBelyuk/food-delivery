package com.solvd.belyuk.fooddelivery;

import com.solvd.belyuk.fooddelivery.entity.Address;
import com.solvd.belyuk.fooddelivery.entity.delivery.Delivery;
import com.solvd.belyuk.fooddelivery.entity.delivery.order.GeneralOrder;
import com.solvd.belyuk.fooddelivery.entity.delivery.order.Order;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.Restaurant;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.food.Dish;
import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.food.ingredient.Ingredient;
import com.solvd.belyuk.fooddelivery.entity.person.Client;
import com.solvd.belyuk.fooddelivery.entity.person.Courier;
import com.solvd.belyuk.fooddelivery.entity.person.Employee;
import com.solvd.belyuk.fooddelivery.entity.vehicle.Car;
import com.solvd.belyuk.fooddelivery.entity.vehicle.WvGolf;
import com.solvd.belyuk.fooddelivery.exception.TooBigValueException;
import com.solvd.belyuk.fooddelivery.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Delivery delivery = new Delivery();

        Map<String, List<Ingredient>> ingredients = Creator.createIngredients();
        for (Map.Entry<String, List<Ingredient>> entry : ingredients.entrySet()) {
            List<Ingredient> ingredientsList = entry.getValue();
            for (Ingredient ingredient : ingredientsList) {
                ingredient.setPresent(true);
            }
        }

        Map<String, List<Dish>> dishes = Creator.createDishes(ingredients);
        delivery.setRestaurants(Creator.createFastFoodRestaurants(dishes));
        delivery.setCouriers(Creator.createCouriers());

        Map<String, Restaurant> restaurantMap = delivery.getRestaurants();
        LOGGER.info("Show entry set: " + restaurantMap.entrySet());
        LOGGER.info("Show map keys: " + restaurantMap.keySet());

        Car lancer = new Car("Mitsubishi Lancer EVO X", 15_000);
        VehicleService.replaceWheel(lancer);

        Client client = new Client("Hugh Laurie", LocalDate.of(1959, 6, 11));
        client.setId(5);
        client.setVehicle(lancer);
        LOGGER.info("Show client vehicle: " + client.getVehicle().getBrand());

        Address address = new Address();
        address.setCity("Minsk");
        address.setDistrict("Central");
        address.setStreet("Prospekt nezavisimosti");
        address.setHouseNumber("56");
        client.setAddress(address);

        Restaurant restaurant = delivery.getRestaurants().get("burger king");

        List<Dish> orderDishes = new ArrayList<>();
        Dish dish1 = restaurant.getDishes().get(1);
        dish1.setDishQuantity(2);
        Dish dish2 = restaurant.getDishes().get(0);
        dish2.setDishQuantity(5);
        orderDishes.add(dish1);
        orderDishes.add(dish2);

        Courier courier = delivery.getCouriers().get(1);
        courier.setCar(new WvGolf("WV Golf", 30_000));
        Car car = courier.getCar();
        car.setOdometerCurrent(1000_000_000);
        car.setNextAirFilterService(45_000);

        try {
            VehicleService.changeOil(car);
        } catch (TooBigValueException e) {
            LOGGER.error("Caught 'TooBigValueException'. ", e);
        } finally {
            LOGGER.info("Set default value for the odometer in finally block.");
            int odometerDefault = 100_000;
            car.setOdometerCurrent(odometerDefault);
        }

        VehicleService.checkAirFilter(car);
        VehicleService.checkIfRepairIsNeeded(car);

        int deliveryDistance = OrderService.showDeliveryDistance(client.getAddress());

        List<Order> orders = new ArrayList<>();
        GeneralOrder order = new GeneralOrder(courier, client, deliveryDistance);
        order.setDiscount(30);
        order.setRestaurant(restaurant);
        order.setDishes(orderDishes);
        orders.add(order);

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

        List<Dish> dishes1 = order.getDishes();
        for (Dish meal : dishes1) {
            RestaurantService.prepareDish(meal);
        }

        if (dishes.containsKey("burger king dishes")) {
            dishes.get("burger king dishes").remove(0);
            LOGGER.info("Dishes keySet after removal: " + dishes.keySet());
        }

        restaurantMap.remove("kfc");
        LOGGER.info("Restaurants left after removal: " + restaurantMap.values());

        Car wrx = new Car("Subaru WRX STI", 20_000);
        Car skyline = new Car("Nissan Skyline", 10_000);
    }
}




