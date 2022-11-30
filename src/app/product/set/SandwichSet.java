package app.product.set;

import app.product.Product;
import app.product.sandwich.Sandwich;
import app.product.side.Setable;
import app.product.side.Side;
import app.product.side.drink.Drink;

public class SandwichSet extends Product {

    private Sandwich sandwich;
    private Setable cookieOrChip;
    private Drink drink;
    private static final int SET_DISCOUNT_PRICE = 1400;
    private static final int ID = 20;
    private static final String NAME = "세트";

    public SandwichSet(Sandwich sandwich, Setable cookieOrChip, Drink drink) {
        super(ID, sandwich.getKcal() + ((Side)cookieOrChip).getKcal() + drink.getKcal(),
                sandwich.getName() + NAME,
                sandwich.getPrice() + ((Side)cookieOrChip).getPrice() + drink.getPrice() - SET_DISCOUNT_PRICE);
        this.sandwich = sandwich;
        this.cookieOrChip = cookieOrChip;
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

    public static int getSetDiscountPrice(){
        return SET_DISCOUNT_PRICE;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public Side getCookieOrChip() {
        return (Side)cookieOrChip;
    }

    public Drink getDrink() {
        return drink;
    }
}
