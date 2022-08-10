package com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dish;

import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dish.ingredient.Ingredient;
import com.solvd.belyuk.fooddelivery.exception.NegativeQuantityException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class Dish implements ICook {

    private static final Logger LOGGER = LogManager.getLogger(Dish.class);

    private List<Ingredient> ingredients;
    private String name;
    private Integer prepareTimeMinutes;
    private BigDecimal price;
    private int dishQuantity;
    private boolean spicy;

    public Dish(String name, Integer prepareTimeMinutes) {
        this.name = name;
        this.prepareTimeMinutes = prepareTimeMinutes;
    }

    @Override
    public void cook() {
        List<Ingredient> ingredients = getIngredients();
        if (!ingredients.iterator().next().isPresent()) {
            LOGGER.info("There is/are no " + ingredients.iterator().next().getName() + " to prepare the " + getName());
        } else {
            LOGGER.info(getDishQuantity() + " " + getName() + " is/are prepared.");
        }
    }


    public int getDishQuantity() {
        return dishQuantity;
    }

    public void setDishQuantity(int dishQuantity) {
        if (dishQuantity < 0) {
            LOGGER.error("Negative dish quantity value.");
            throw new NegativeQuantityException("Negative dish quantity value.");
        }
        this.dishQuantity = dishQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPrepareTimeMinutes() {
        return prepareTimeMinutes;
    }

    public void setPrepareTimeMinutes(Integer prepareTimeMinutes) {
        this.prepareTimeMinutes = prepareTimeMinutes;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (dishQuantity != dish.dishQuantity) return false;
        if (spicy != dish.spicy) return false;
        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        if (price != null ? !price.equals(dish.price) : dish.price != null) return false;
        if (prepareTimeMinutes != null ? !prepareTimeMinutes.equals(dish.prepareTimeMinutes) : dish.prepareTimeMinutes != null)
            return false;
        return ingredients != null ? ingredients.equals(dish.ingredients) : dish.ingredients == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (prepareTimeMinutes != null ? prepareTimeMinutes.hashCode() : 0);
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        result = 31 * result + dishQuantity;
        result = 31 * result + (spicy ? 1 : 0);
        return result;
    }

    @Override
    public String
    toString() {
        final StringBuilder sb = new StringBuilder("Dish{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", prepareTimeMinutes=").append(prepareTimeMinutes);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", dishQuantity=").append(dishQuantity);
        sb.append(", spicy=").append(spicy);
        sb.append('}');
        return sb.toString();
    }
}
