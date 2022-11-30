package app.ingredient;


public class Ingredient {
    private String name;
    private int kcal;

    public Ingredient() {
    }

    public Ingredient(String name, int kcal) {
        this.name = name;
        this.kcal = kcal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public static int getIngredientsKcal(Ingredient[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int result = 0;
        for (Ingredient ingredient : arr) {
            result += ingredient.getKcal();
        }
        return result;
    }
}
