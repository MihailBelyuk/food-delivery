package com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype;

import com.solvd.belyuk.fooddelivery.entity.delivery.restaurant.dishtype.ingredient.Ingredient;

public class FriedChicken extends Dish {

    public FriedChicken(String name, Integer prepareTimeMinutes, Ingredient[] ingredients) {
        super(name, prepareTimeMinutes);
        setIngredients(ingredients);
    }
}
