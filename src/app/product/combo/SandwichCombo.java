package app.product.combo;

import app.product.Product;
import app.product.sandwich.Sandwich;
import app.product.side.drink.Drink;

public class SandwichCombo extends Product {

    private Sandwich sandwich;
    private Drink drink;
    private static final int COMBO_DISCOUNT_PRICE = 1000;
    private static final int ID = 19;
    private static final String NAME = "콤보";

    public SandwichCombo(Sandwich sandwich, Drink drink) {
        super(ID, sandwich.getKcal() + drink.getKcal(), sandwich.getName() + NAME, sandwich.getPrice() + drink.getPrice() - COMBO_DISCOUNT_PRICE);
        this.sandwich = sandwich;
        this.drink = drink;
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
    public String getName() {
        return super.getName();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    public static int getComboDiscountPrice(){
        return COMBO_DISCOUNT_PRICE;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public Drink getDrink() {
        return drink;
    }
}
