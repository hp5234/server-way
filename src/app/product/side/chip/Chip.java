package app.product.side.chip;

import app.product.side.Setable;
import app.product.side.Side;

public class Chip extends Side implements Setable {
    public Chip(int id, int kcal, String name, int price) {
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
