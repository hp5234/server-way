package app.management;

import app.ingredient.additionalingredient.*;
import app.ingredient.bread.Bread;
import app.ingredient.bread.HoneyOat;
import app.ingredient.bread.WheatBread;
import app.ingredient.bread.WhiteBread;
import app.ingredient.cheese.AmericanCheese;
import app.ingredient.cheese.Cheese;
import app.ingredient.cheese.MozzarellaCheese;
import app.ingredient.sauce.*;
import app.ingredient.vegetable.*;
import app.management.menu.info.sandwich.SandwichMenu;
import app.management.menu.info.sandwich.option.additioaningredient.AdditionalIngreOptionMenu;
import app.management.menu.info.sandwich.option.bread.BreadKindMenu;
import app.management.menu.info.sandwich.option.cheese.AdditionalCheeseMenu;
import app.management.menu.info.sandwich.option.cheese.CheeseKindMenu;
import app.management.menu.info.sandwich.option.sauce.SauceIngreOptionMenu;
import app.management.menu.info.sandwich.option.vegetable.VegetablesIngreOptionMenu;
import app.management.menu.info.side.chip.ChipMenu;
import app.management.menu.info.side.cookie.CookieMenu;
import app.management.menu.info.side.drink.DrinkMenu;
import app.management.menu.info.side.wedgesandsoup.WedgesAndSoupMenu;
import app.product.combo.SandwichCombo;
import app.product.sandwich.*;
import app.product.set.SandwichSet;
import app.product.side.Setable;
import app.product.side.chip.Chip;
import app.product.side.chip.PocaChips;
import app.product.side.chip.PotatoChips;
import app.product.side.chip.SwingChips;
import app.product.side.cookie.ChocoChipCookie;
import app.product.side.cookie.Cookie;
import app.product.side.cookie.DoubleChocoChipCookie;
import app.product.side.cookie.RaspberryCheeseCookie;
import app.product.side.drink.*;
import app.product.side.wedgesandsoup.*;

import java.util.ArrayList;

public class ProductMaker {

    // 샌드위치 생성
    public Sandwich makeSandwich(int kind, Bread bread, Cheese[] cheeses, Vegetable[] vegetables, Sauce[] sauces,
                                 AdditionalIngredient[] additionalIngredients){
        if(kind == SandwichMenu.ROAST_CHICKEN_SANDWICH.getMenuNum()){
            return new RoastChickenSandwich(bread, cheeses, vegetables, sauces, additionalIngredients);
        }
        else if (kind == SandwichMenu.EGG_MAYO_SANDWICH.getMenuNum()){
            return new EggMayoSandwich(bread, cheeses, vegetables, sauces, additionalIngredients);
        }
        else if (kind == SandwichMenu.ITALIAN_BMT_SANDWICH.getMenuNum()){
            return new ItalianBMTSandwich(bread, cheeses, vegetables, sauces, additionalIngredients);
        }
        else if (kind == SandwichMenu.VEGETARIAN_SANDWICH.getMenuNum()){
            return new VegetarianSandwich(bread, cheeses, vegetables, sauces, additionalIngredients);
        }
        return null;
    }

    // 콤보 생성
    public SandwichCombo makeCombo (Sandwich sandwich, Drink drink){
        return new SandwichCombo(sandwich, drink);
    }

    // 세트 생성
    public SandwichSet makeSet (Sandwich sandwich, Setable side, Drink drink){
        return new SandwichSet(sandwich, side, drink);
    }

    // 빵 생성
    public Bread makeBread(int kind, boolean bake, int length){
        if (kind == BreadKindMenu.WHITE_BREAD.getMenuNum()){
            return new WhiteBread(bake, length);
        }
        else if (kind == BreadKindMenu.WHEAT_BREAD.getMenuNum()){
            return new WheatBread(bake, length);
        }
        else if (kind == BreadKindMenu.HONEY_OAT.getMenuNum()){
            return new HoneyOat(bake, length);
        }
        return null;
    }

    // 치즈 배열 생성
    public Cheese[] makeCheeses(int[] answers){
        if (answers.length == 0){
            return null;
        }
        ArrayList<Cheese> cheeses = new ArrayList<>();
        for (int answer : answers) {
            if (answer != CheeseKindMenu.NONE_CHEESE.getMenuNum() &&
                    answer != AdditionalCheeseMenu.NONE_CHEESE.getMenuNum()){
                cheeses.add(makeCheese(answer));
            }
        }
        if (cheeses.size() == 0){
            return null;
        } else {
            return cheeses.toArray(Cheese[]::new);
        }
    }

    // 치즈 생성
    public Cheese makeCheese(int kind){
        if (kind == CheeseKindMenu.AMERICAN_CHEESE.getMenuNum()){
            return new AmericanCheese();
        }
        else if (kind == CheeseKindMenu.MOZZARELLA_CHEESE.getMenuNum()){
            return new MozzarellaCheese();
        }
        return null;
    }

    // 야채 배열 생성
    public Vegetable[] makeVegetables(int[] answers){
        if (answers.length == 0){
            return null;
        }
        ArrayList<Vegetable> vegetables = new ArrayList<>();
        for (int answer : answers) {
            vegetables.add(makeVegetable(answer));
        }
        return vegetables.toArray(Vegetable[]::new);
    }

    // 야채 생성
    public Vegetable makeVegetable(int kind){
        if (kind == VegetablesIngreOptionMenu.LETTUCE.getMenuNum()){
            return new Lettuce();
        }
        else if (kind == VegetablesIngreOptionMenu.TOMATO.getMenuNum()){
            return new Tomato();
        }
        else if (kind == VegetablesIngreOptionMenu.CUCUMBER.getMenuNum()){
            return new Cucumber();
        }
        else if (kind == VegetablesIngreOptionMenu.PICKLE.getMenuNum()){
            return new Pickle();
        }
        else if (kind == VegetablesIngreOptionMenu.OLIVE.getMenuNum()){
            return new Olive();
        }
        else if (kind == VegetablesIngreOptionMenu.JALAPENOS.getMenuNum()){
            return new Jalapenos();
        }
        return null;
    }

    // 소스 배열 생성
    public Sauce[] makeSauces(int[] answers){
        if (answers.length == 0){
            return null;
        }
        ArrayList<Sauce> sauces = new ArrayList<>();
        for (int answer : answers) {
            sauces.add(makeSauce(answer));
        }
        return sauces.toArray(Sauce[]::new);
    }

    // 소스 생성
    public Sauce makeSauce(int kind){
        if (kind == SauceIngreOptionMenu.MUSTARD.getMenuNum()){
            return new Mustard();
        }
        else if (kind == SauceIngreOptionMenu.SWEET_ONION.getMenuNum()){
            return new SweetOnion();
        }
        else if (kind == SauceIngreOptionMenu.SMOKED_BARBECUE.getMenuNum()){
            return new SmokedBarbecue();
        }
        else if (kind == SauceIngreOptionMenu.RANCH.getMenuNum()){
            return new Ranch();
        }
        else if (kind == SauceIngreOptionMenu.OLIVE_OIL.getMenuNum()){
            return new OliveOil();
        }
        return null;
    }

    // 추가재료 배열 생성
    public AdditionalIngredient[] makeAdditionalIngres(int[] answers){
        if (answers.length == 0){
            return null;
        }
        ArrayList<AdditionalIngredient> additionalIngres = new ArrayList<>();
        for (int answer : answers) {
            additionalIngres.add(makeAdditionalIngre(answer));
        }
        return additionalIngres.toArray(AdditionalIngredient[]::new);
    }

    // 추가재료 생성
    public AdditionalIngredient makeAdditionalIngre(int kind){
        if (kind == AdditionalIngreOptionMenu.EGG_MAYO.getMenuNum()){
            return new EggMayo();
        }
        else if (kind == AdditionalIngreOptionMenu.PEPPERONI.getMenuNum()){
            return new Pepperoni();
        }
        else if (kind == AdditionalIngreOptionMenu.BACON.getMenuNum()){
            return new Bacon();
        }
        else if (kind == AdditionalIngreOptionMenu.AVOCADO.getMenuNum()){
            return new Avocado();
        }
        else if (kind == AdditionalIngreOptionMenu.OMELETTE.getMenuNum()){
            return new Omelette();
        }
        return null;
    }

    // 칩 생성
    public Chip makeChip(int kind){
        if (kind == ChipMenu.POCA_CHIPS.getMenuNum()){
            return new PocaChips();
        }
        else if (kind == ChipMenu.POTATO_CHIPS.getMenuNum()){
            return new PotatoChips();
        }
        else if (kind == ChipMenu.SWING_CHIPS.getMenuNum()){
            return new SwingChips();
        }
        return null;
    }

    // 쿠키 생성
    public Cookie makeCookie (int kind){
        if (kind == CookieMenu.CHOCO_CHIP_COOKIE.getMenuNum()){
            return new ChocoChipCookie();
        }
        else if (kind == CookieMenu.DOUBLE_CHOCO_CHIP_COOKIE.getMenuNum()){
            return new DoubleChocoChipCookie();
        }
        else if (kind == CookieMenu.RASPBERRY_CHEESE_COOKIE.getMenuNum()) {
            return new RaspberryCheeseCookie();
        }
        return null;
    }

    // 음료 생성
    public Drink makeDrink(int kind){
        if (kind == DrinkMenu.COKE.getMenuNum()){
            return new Coke();
        }
        else if (kind == DrinkMenu.COKE_ZERO.getMenuNum()){
            return new CokeZero();
        }
        else if (kind == DrinkMenu.AMERICANO.getMenuNum()) {
            return new Americano();
        }
        else if (kind == DrinkMenu.SPRITE.getMenuNum()) {
            return new Sprite();
        }
        return null;
    }

    // 웨지 / 스프 생성
    public WedgesAndSoup makeWedgesAndSoup (int kind){
        if (kind == WedgesAndSoupMenu.BROCCOLI_SOUP.getMenuNum()){
            return new BroccoliSoup();
        }
        else if (kind == WedgesAndSoupMenu.MUSHROOM_SOUP.getMenuNum()){
            return new MushroomSoup();
        }
        else if (kind == WedgesAndSoupMenu.HASHBROWN.getMenuNum()) {
            return new Hashbrown();
        }
        else if (kind == WedgesAndSoupMenu.WEDGE_POTATO.getMenuNum()) {
            return new WedgePotato();
        }
        return null;
    }
}
