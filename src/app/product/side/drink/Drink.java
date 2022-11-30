package app.product.side.drink;

import app.product.side.Side;

public class Drink extends Side {

    public Drink(int id, int kcal, String name, int price) {
        super(id, kcal, name, price);
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
}
