package app.product.products;

public enum SandwichProduct {
    ROAST_CHICKEN(1, "π λ‘μ€νΈμΉν¨ μλμμΉ", 6700),
    EGG_MAYO(2, "π₯ μκ·Έλ§μ μλμμΉ", 4900),
    ITALIAN_BMT(3, "π₯ ννΌλ‘λ μλμμΉ", 6100),
    VEGETARIAN(4, "π₯¬ λ² μ§ μλμμΉ", 4400);

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
