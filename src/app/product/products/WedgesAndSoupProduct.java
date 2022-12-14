package app.product.products;

public enum WedgesAndSoupProduct {

    BROCCOLI_SOUP(11, "π΅ λΈλ‘μ½λ¦¬μ€ν", 2300, 166),
    MUSHROOM_SOUP(12, "π΅ λ¨Έμ¬λ£Έμ€ν", 2300, 147),
    HASHBROWN(13, "π ν΄μ¬λΈλΌμ΄", 2300, 86),
    WEDGE_POTATO(14, "π μ¨μ§κ°μ", 2300, 140);

    private final int id;
    private final String name;
    private final int defaultPrice;
    private final int kcal;

    WedgesAndSoupProduct(int id, String name, int defaultPrice, int kcal) {
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
