package app.management.discount;

public abstract class RateDiscount extends Discount{

    private final int DISCOUNT_AMOUNT;

    public RateDiscount(int id, String name, int discountAmount) {
        super(id, name);
        this.DISCOUNT_AMOUNT = discountAmount;
    }

    @Override
    public int discount(int price) {
        return price - getDiscountPrice(price);
    }

    public int getDiscountAmount() {
        return DISCOUNT_AMOUNT;
    }

    public int getDiscountPrice(int price) {
        return price * (DISCOUNT_AMOUNT / 100);
    }

    abstract boolean checkCondition();
}
