package app.product.sandwich;

import app.ingredient.additionalingredient.AdditionalIngredient;
import app.ingredient.bread.Bread;
import app.ingredient.cheese.Cheese;
import app.ingredient.sauce.Sauce;
import app.ingredient.vegetable.Vegetable;
import app.product.products.SandwichProduct;

public class VegetarianSandwich extends Sandwich{

    public VegetarianSandwich(Bread bread, Cheese[] cheeses,
                                Vegetable[] vegetables, Sauce[] sauces, AdditionalIngredient[] additionalIngredients) {

        super(SandwichProduct.VEGETARIAN.getId(), SandwichProduct.VEGETARIAN.getName(), SandwichProduct.VEGETARIAN.getDefaultPrice(), new Corn(),
                bread, cheeses, vegetables, sauces, additionalIngredients);
    }

    static class Corn extends MainIngredient {
        public Corn() {
            super("옥수수", 90);
        }
    }
}
