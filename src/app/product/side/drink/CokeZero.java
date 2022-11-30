package app.product.side.drink;

import app.product.products.DrinkProduct;

public class CokeZero extends Drink{
    public CokeZero() {
        super(DrinkProduct.COKE_ZERO.getId(), DrinkProduct.COKE_ZERO.getKcal(), DrinkProduct.COKE_ZERO.getName(), DrinkProduct.COKE_ZERO.getDefaultPrice());
    }
}
