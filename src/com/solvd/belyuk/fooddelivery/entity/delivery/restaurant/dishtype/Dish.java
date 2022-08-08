package com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype;

import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.ingredient.Ingredient;
import com.solvd.belyuk.fooddelivery.exception.NegativeQuantityException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Arrays;

public class Dish implements ICook {

    private static final Logger LOGGER = LogManager.getLogger(Dish.class);

    private String name;
    private BigDecimal price;
    private Integer prepareTimeMinutes;
    private Ingredient[] ingredients;
    private int dishQuantity;
    private boolean spicy;

    public Dish(String name, Integer prepareTimeMinutes) {
        this.name = name;
        this.prepareTimeMinutes = prepareTimeMinutes;
    }

    @Override
    public void cook() {
        Ingredient[] ingredients = getIngredients();
        for (int i = 0; i < ingredients.length; ) {
            if (!ingredients[i].isPresent()) {
                LOGGER.info("There is/are no " + ingredients[i].getName() + " to prepare the " + getName());
                break;
            } else {
                LOGGER.info(getName() + " is/are prepared.");
                i++;
            }
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

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dish{");
        sb.append("spicy=").append(spicy);
        sb.append(", name='").append(name).append('\'');
        sb.append(", dishPrice=").append(price);
        sb.append(", prepareTimeMinutes=").append(prepareTimeMinutes);
        sb.append(", ingredients=").append(Arrays.toString(ingredients));
        sb.append('}');
        return sb.toString();
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
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(ingredients, dish.ingredients);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (prepareTimeMinutes != null ? prepareTimeMinutes.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(ingredients);
        result = 31 * result + dishQuantity;
        result = 31 * result + (spicy ? 1 : 0);
        return result;
    }
}
