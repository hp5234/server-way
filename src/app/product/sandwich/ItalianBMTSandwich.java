package app.product.sandwich;

import app.ingredient.additionalingredient.AdditionalIngredient;
import app.ingredient.bread.Bread;
import app.ingredient.cheese.Cheese;
import app.ingredient.sauce.Sauce;
import app.ingredient.vegetable.Vegetable;
import app.product.products.SandwichProduct;

public class ItalianBMTSandwich extends Sandwich{

    public ItalianBMTSandwich(Bread bread, Cheese[] cheeses,
                           Vegetable[] vegetables, Sauce[] sauces, AdditionalIngredient[] additionalIngredients) {

        super(SandwichProduct.ITALIAN_BMT.getId(), SandwichProduct.ITALIAN_BMT.getName(), SandwichProduct.ITALIAN_BMT.getDefaultPrice(), new Pepperoni(),
                bread, cheeses, vegetables, sauces, additionalIngredients);
    }

    static class Pepperoni extends MainIngredient {
        public Pepperoni() {
            super("페퍼로니", 170);
        }
    }
}
