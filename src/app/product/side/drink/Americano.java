package app.product.side.drink;

import app.product.products.DrinkProduct;

public class Americano extends Drink{
    public Americano() {
        super(DrinkProduct.AMERICANO.getId(), DrinkProduct.AMERICANO.getKcal(), DrinkProduct.AMERICANO.getName(), DrinkProduct.AMERICANO.getDefaultPrice());
    }
}
