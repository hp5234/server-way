package app.product.sandwich;

import app.ingredient.Ingredient;
import app.ingredient.additionalingredient.AdditionalIngredient;
import app.ingredient.bread.Bread;
import app.ingredient.cheese.Cheese;
import app.ingredient.sauce.Sauce;
import app.ingredient.vegetable.Vegetable;
import app.product.Product;

public class Sandwich extends Product {

    private MainIngredient mainIngredient;
    private Bread bread;
    private Cheese[] cheeses;
    private Vegetable[] vegetables;
    private Sauce[] sauces;
    private AdditionalIngredient[] additionalIngredients;

    public Sandwich(int id, String name, int defaultPrice,
                    MainIngredient mainIngredient, Bread bread, Cheese[] cheeses,
                    Vegetable[] vegetables, Sauce[] sauces, AdditionalIngredient[] additionalIngredients) {
        super(id, mainIngredient.getKcal() + bread.getKcal() +
                Ingredient.getIngredientsKcal(cheeses) + Ingredient.getIngredientsKcal(vegetables) +
                Ingredient.getIngredientsKcal(sauces) +Ingredient.getIngredientsKcal(additionalIngredients), name,
                getPriceByBreadLength(bread, defaultPrice) + getPriceByOtherIngre(cheeses, additionalIngredients)
        );
        this.mainIngredient = mainIngredient;
        this.bread = bread;
        this.cheeses = cheeses;
        this.vegetables = vegetables;
        this.sauces = sauces;
        this.additionalIngredients = additionalIngredients;
    }

    // 빵길이에 따른 요금 계산
    private static int getPriceByBreadLength(Bread bread, int defaultPrice){
        if (bread.getLength() == 30){
            return (defaultPrice * 2) - 1000;
        } else {
            return defaultPrice;
        }
    }

    // 추가 금액 계산
    private static int getPriceByOtherIngre(Cheese[] cheeses, AdditionalIngredient[] additionalIngredients) {
        int cheesePrice = 0;
        int otherPrice = 0;
        if (cheeses != null && cheeses.length == 2 ){
            cheesePrice = Cheese.getAdditionalPrice();
        }
        if (additionalIngredients != null && additionalIngredients.length != 0 ){
            otherPrice = AdditionalIngredient.getAdditionalPrice() * additionalIngredients.length;
        }
        return cheesePrice + otherPrice;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public int getKcal() {
        return super.getKcal();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    public MainIngredient getMainIngredient() {
        return mainIngredient;
    }

    public Bread getBread() {
        return bread;
    }

    public Cheese[] getCheeses() {
        return cheeses;
    }

    public Vegetable[] getVegetables() {
        return vegetables;
    }

    public Sauce[] getSauces() {
        return sauces;
    }

    public AdditionalIngredient[] getAdditionalIngredients() {
        return additionalIngredients;
    }
}
