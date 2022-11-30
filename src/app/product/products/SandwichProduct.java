package app.product.products;

public enum SandwichProduct {
    ROAST_CHICKEN(1, "🍗 로스트치킨 샌드위치", 6700),
    EGG_MAYO(2, "🥚 에그마요 샌드위치", 4900),
    ITALIAN_BMT(3, "🥓 페퍼로니 샌드위치", 6100),
    VEGETARIAN(4, "🥬 베지 샌드위치", 4400);

    private final int id;
    private final String name;
    private final int defaultPrice;

    SandwichProduct(int id, String name, int defaultPrice) {
        this.id = id;
        this.name = name;
        this.defaultPrice = defaultPrice;
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
}
