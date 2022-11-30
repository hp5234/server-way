package app.management;

import app.ingredient.Ingredient;
import app.ingredient.additionalingredient.AdditionalIngredient;
import app.ingredient.bread.Bread;
import app.ingredient.cheese.Cheese;
import app.ingredient.sauce.Sauce;
import app.ingredient.vegetable.Vegetable;
import app.product.Product;
import app.product.combo.SandwichCombo;
import app.product.sandwich.Sandwich;
import app.product.set.SandwichSet;

import java.util.LinkedList;

public class Cart {

    private final LinkedList<Product> products = new LinkedList<>();

    public LinkedList<Product> getProducts() {
        return products;
    }

    // 장바구니 사이즈 반환
    public int getCartSize(){
        return products.size();
    }

    // 합계 금액
    public int getTotalPrice() {
        int price = 0;
        for (Product product : products) {
            price += product.getPrice();
        }
        return price;
    }

    // 장바구니 내역 출력
    public void printAllCart(){
        if (products.size() == 0){
            System.out.println("❎ 장바구니가 비었습니다.\n");
        } else {
            System.out.println("-----------🔻현재 장바구니🔻--------------");
            printAllProduct();
            System.out.println("\nTotal price : " + getTotalPrice());
            System.out.println("----------------------------------------");
        }
    }

    // 장바구니 목록 출력
    public void printAllProduct() {
        for (int i = 0; i < products.size(); i++) {
            printProduct(i, products.get(i));
        }
    }

    // 전체 상세 보기
    public void printAllDetailProduct() {
        for (int i = 0; i < products.size(); i++) {
            printProductDetail(i, false);
        }
    }

    // 제품 상세보기
    public void printProductDetail(int listNum, boolean showComment){
        if (showComment) {
            System.out.println("-----------🔻🔻상세보기🔻🔻-----------");
        }
        try {
            Product product = products.get(listNum - 1);
            System.out.printf("(%3d) %s %5dKcal  %7d원\n", listNum, product.getName(), product.getKcal(), product.getPrice());
            // 구성품 출력
            if (product instanceof Sandwich) {
                printSandwich((Sandwich) product, false);
            } else if (product instanceof SandwichCombo){
                printSandwichCombo((SandwichCombo) product);
            } else if (product instanceof SandwichSet){
                printSandwichSet((SandwichSet) product);
            }
            System.out.println("-".repeat(50));
        } catch (Exception e) {
            System.out.println("❗️장바구니 상세 조회 중 오류가 발생했습니다.");
            System.out.println("❗️다시 시도해주세요.");
        }
    }

    // 제품 : 리스트번호, 제품이름, 제품칼로리, 제품가격
    private void printProduct(int index, Product product){
        System.out.printf("(%3d) %s %5dKcal  %7d원\n", index + 1, product.getName(), product.getKcal(), product.getPrice());
    }

    // 샌드위치 출력
    private void printSandwich(Sandwich sandwich, boolean isIncludeSetOrCombo){
        String tab = getTabString(isIncludeSetOrCombo);
        System.out.printf(tab + "%15s %5dKcal\n", sandwich.getName(), sandwich.getKcal());
        System.out.println(tab + tab + "[메인재료]");
        printIngredient(sandwich.getMainIngredient(), isIncludeSetOrCombo);

        System.out.println(tab + tab + "[빵]");
        printIngredient(sandwich.getBread(), isIncludeSetOrCombo);

        System.out.println(tab + tab + "[치즈]");
        Cheese[] cheeses = sandwich.getCheeses();
        if (cheeses == null || cheeses.length == 0){
            System.out.println(tab + tab + tab + " 치즈 선택 안함");
        } else {
            printIngredients(cheeses, isIncludeSetOrCombo);
        }
        System.out.println(tab + tab + "[야채]");
        Vegetable[] vegetables = sandwich.getVegetables();
        if (vegetables == null || vegetables.length == 0){
            System.out.println(tab + tab + tab + "야채 선택 안함");
        } else {
            printIngredients(vegetables, isIncludeSetOrCombo);
        }
        System.out.println(tab + tab + "[소스]");
        Sauce[] sauces = sandwich.getSauces();
        if (sauces == null || sauces.length == 0){
            System.out.println(tab + tab + tab + "소스 선택 안함");
        } else {
            printIngredients(sauces, isIncludeSetOrCombo);
        }
        System.out.println(tab + tab + "[추가재료]");
        AdditionalIngredient[] additionalIngredients = sandwich.getAdditionalIngredients();
        if (additionalIngredients == null || additionalIngredients.length == 0){
            System.out.println(tab + tab + tab + " 추가재료 선택 안함");
        } else {
            printIngredients(additionalIngredients, isIncludeSetOrCombo);
        }
    }

    // 탭사이즈 설정
    private String getTabString(boolean isIncludeSetOrCombo) {
        String tab = "\t";
        if (isIncludeSetOrCombo){
            tab = "\t\t";
        }
        return tab;
    }

    // 샌드위치 콤보 출력
    private void printSandwichCombo(SandwichCombo combo){
        printSandwich(combo.getSandwich(), true);
        printSetOrComboComponent(combo.getDrink());
    }

    // 샌드위치 세트 출력
    private void printSandwichSet(SandwichSet set){
        printSandwich(set.getSandwich(), true);
        printSetOrComboComponent(set.getCookieOrChip());
        printSetOrComboComponent(set.getDrink());
    }

    // 세트 or 콤보 구성품 출력
    private void printSetOrComboComponent(Product product){
        System.out.printf("\t %s %5dKcal\n", product.getName(), product.getKcal());
    }

    // 재료들 출력
    private void printIngredients(Ingredient[] ingredients, boolean isIncludeSetOrCombo){
        if (ingredients.length == 0 || ingredients == null){
            return;
        } else {
            for (Ingredient ingredient : ingredients) {
                printIngredient(ingredient, isIncludeSetOrCombo);
            }
        }
    }

    // 재료 : 이름, 칼로리, 옵션
    private void printIngredient(Ingredient ingredient, boolean isIncludeSetOrCombo){
        String tab = getTabString(isIncludeSetOrCombo);
        if (ingredient instanceof Bread) {
            Bread bread = (Bread)ingredient;
            String isBake = "굽기선택";
            if (bread.getBake()){
                isBake = "굽지않음";
            }
            System.out.printf(tab + tab + tab + "%s %6dKcal %2dcm %s\n", bread.getName(), bread.getKcal(), bread.getLength(), isBake);
        }
        else {
            System.out.printf(tab + tab + tab + "%s %6dKcal\n", ingredient.getName(), ingredient.getKcal());
        }
    }

    // 장바구니에서 삭제
    public boolean removeFromCart(int listNum){
        try {
            Product remove = products.remove(listNum - 1);
            System.out.printf("\n------✅ %d. %s 이(가) 장바구니에서 제거되었습니다.------\n\n", listNum, remove.getName());
            return true;
        } catch (Exception e){
            System.out.println("❗️장바구니 삭제 중 오류가 발생했습니다.");
            System.out.println("❗️다시 시도해주세요.");
            return false;
        }
    }

    // 장바구니 추가
    public void add(Product product){
        products.add(product);
        System.out.println("\n------✅ 장바구니에 추가되었습니다.------\n\n");
        System.out.println("추가된 제품 : " + product.getName());
        System.out.println("-----------------------------------");
    }

    // 장바구니 비우기
    public void clearCart(){
        products.clear();
        System.out.println("\n------✅ 장바구니가 초기화 되었습니다.------\n\n");
    }
}
