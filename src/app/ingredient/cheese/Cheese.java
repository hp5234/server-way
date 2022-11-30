package app.ingredient.cheese;

import app.ingredient.Ingredient;

public class Cheese extends Ingredient {

    private static final int ADDITIONAL_PRICE = 1100;

    public Cheese(String name, int kcal) {
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

    public static int getAdditionalPrice(){
        return ADDITIONAL_PRICE;
    }
}
