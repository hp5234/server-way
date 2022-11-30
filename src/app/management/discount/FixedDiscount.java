package app.management.discount;

public abstract class FixedDiscount extends Discount{

    private final int discountAmount;

    public FixedDiscount(int id, String name, int discountAmount) {
        super(id, name);
        this.discountAmount = discountAmount;
    }

    @Override
    public int discount(int price) {
        return price;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    abstract boolean checkCondition();

}
