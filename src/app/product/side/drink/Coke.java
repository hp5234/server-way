package app.product.side.drink;

import app.product.products.DrinkProduct;

public class Coke extends Drink{
    public Coke() {
        super(DrinkProduct.COKE.getId(), DrinkProduct.COKE.getKcal(), DrinkProduct.COKE.getName(), DrinkProduct.COKE.getDefaultPrice());
    }
}
