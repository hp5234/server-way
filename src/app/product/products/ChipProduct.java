package app.product.products;

public enum ChipProduct {

    POCA_CHIPS(8, "🥠 포카칩", 1500, 245),
    POTATO_CHIPS(9, "🥠 포테이토칩", 1500, 260),
    SWING_CHIPS(10, "🥠 스윙칩", 1500, 270);

    private final int id;
    private final String name;
    private final int defaultPrice;
    private final int kcal;

    ChipProduct(int id, String name, int defaultPrice, int kcal) {
        this.id = id;
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.kcal = kcal;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDefaultPrice() {
        return defaultPrice;
    }

    public int getKcal() {
        return kcal;
    }
}
