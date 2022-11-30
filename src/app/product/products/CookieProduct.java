package app.product.products;

public enum CookieProduct {

    CHOCO_CHIP_COOKIE(5, "🍪 초코칩쿠키", 1300, 228),
    DOUBLE_CHOCO_CHIP_COOKIE(6, "🍪 더블초코칩쿠키", 1300, 212),
    RASPBERRY_CHEESE_COOKIE(7, "🍪 라즈베리치즈쿠키", 1300, 204);

    private final int id;
    private final String name;
    private final int defaultPrice;
    private final int kcal;

    CookieProduct(int id, String name, int defaultPrice, int kcal) {
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
