package app.product.sandwich;

import app.ingredient.Ingredient;

public class MainIngredient extends Ingredient {

    public MainIngredient(String name, int kcal) {
        super(name, kcal);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getKcal() {
        return super.getKcal();
    }
}
