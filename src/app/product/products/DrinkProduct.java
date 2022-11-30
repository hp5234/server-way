package app.product.products;

public enum DrinkProduct {

    COKE(15, "🥤 콜라", 2000, 37),
    COKE_ZERO(16, "🥤 제로콜라", 2000, 0),
    AMERICANO(17, "☕️ 아메리카노", 2000, 10),
    SPRITE(18, "🥤 스프라이트", 2000, 34);


    private final int id;
    private final String name;
    private final int defaultPrice;
    private final int kcal;

    DrinkProduct(int id, String name, int defaultPrice, int kcal) {
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
