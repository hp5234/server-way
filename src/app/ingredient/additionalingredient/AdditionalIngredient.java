package app.ingredient.additionalingredient;

import app.ingredient.Ingredient;

public class AdditionalIngredient extends Ingredient {

    // 추가 재료 개당 금액
    private static final int ADDITIONAL_PRICE = 1500;

    public AdditionalIngredient(String name, int kcal) {
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

    public static int getAdditionalPrice() {
        return ADDITIONAL_PRICE;
    }

}
