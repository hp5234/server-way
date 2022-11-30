package app.management.discount;

public abstract class Discount {
    private int id;
    private String name;
    abstract int discount(int prive);
    abstract boolean checkCondition();

    public Discount(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
