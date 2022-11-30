package app.product.side.drink;

import app.product.products.DrinkProduct;

public class Sprite extends Drink{

    public Sprite() {
        super(DrinkProduct.SPRITE.getId(), DrinkProduct.SPRITE.getKcal(), DrinkProduct.SPRITE.getName(), DrinkProduct.SPRITE.getDefaultPrice());
    }
}
