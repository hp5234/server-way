package app.product;

public class Product {
    private int id;
    private int kcal;
    private String name;
    private int price;

    public Product(int id, int kcal, String name, int price) {
        this.id = id;
        this.kcal = kcal;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getKcal() {
        return kcal;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
