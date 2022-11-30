package app.product.sandwich;

import app.ingredient.additionalingredient.AdditionalIngredient;
import app.ingredient.bread.Bread;
import app.ingredient.cheese.Cheese;
import app.ingredient.sauce.Sauce;
import app.ingredient.vegetable.Vegetable;
import app.product.products.SandwichProduct;

public class RoastChickenSandwich extends Sandwich{

    public RoastChickenSandwich(Bread bread, Cheese[] cheeses,
                              Vegetable[] vegetables, Sauce[] sauces, AdditionalIngredient[] additionalIngredients) {

        super(SandwichProduct.ROAST_CHICKEN.getId(), SandwichProduct.ROAST_CHICKEN.getName(), SandwichProduct.ROAST_CHICKEN.getDefaultPrice(), new RoastChicken(),
                bread, cheeses, vegetables, sauces, additionalIngredients);
    }

    static class RoastChicken extends MainIngredient {
        public RoastChicken() {
            super("로스트치킨", 140);
        }
    }
}
