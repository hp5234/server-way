package app.product.sandwich;

import app.ingredient.additionalingredient.AdditionalIngredient;
import app.ingredient.bread.Bread;
import app.ingredient.cheese.Cheese;
import app.ingredient.sauce.Sauce;
import app.ingredient.vegetable.Vegetable;
import app.product.products.SandwichProduct;

public class EggMayoSandwich extends Sandwich{

    public EggMayoSandwich(Bread bread, Cheese[] cheeses,
                           Vegetable[] vegetables, Sauce[] sauces, AdditionalIngredient[] additionalIngredients) {

        super(SandwichProduct.EGG_MAYO.getId(), SandwichProduct.EGG_MAYO.getName(), SandwichProduct.EGG_MAYO.getDefaultPrice(), new EggMayo(),
                bread, cheeses, vegetables, sauces, additionalIngredients);
    }

    static class EggMayo extends MainIngredient {
        public EggMayo() {
            super("에그마요", 130);
        }
    }
}

