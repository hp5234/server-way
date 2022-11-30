package app.product.side;

import app.product.Product;

public class Side extends Product {
    public Side(int id, int kcal, String name, int price) {
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
