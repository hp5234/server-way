package app.ingredient.bread;

import app.ingredient.Ingredient;

public class Bread extends Ingredient {
    private final boolean bake;
    private final int length;

    public Bread(String name, int kcal, boolean bake, int length) {
        super(name, kcal);
        if (length == 15){
            super.setKcal(kcal * 2);
        }
        this.bake = bake;
        this.length = length;
    }

    public boolean getBake() {
        return bake;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getKcal() {
        return super.getKcal();
    }
}
