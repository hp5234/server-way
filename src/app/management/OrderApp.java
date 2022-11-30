package app.management;

import app.ingredient.additionalingredient.AdditionalIngredient;
import app.ingredient.bread.Bread;
import app.ingredient.cheese.Cheese;
import app.ingredient.sauce.Sauce;
import app.ingredient.vegetable.Vegetable;
import app.management.discount.DiscountHandler;
import app.management.menu.Menu;
import app.management.menu.MenuHandler;
import app.management.menu.YesOrNo;
import app.management.menu.info.*;
import app.management.menu.info.discount.FixedDiscountMenu;
import app.management.menu.info.discount.RateDiscountMenu;
import app.management.menu.info.sandwich.SandwichMenu;
import app.management.menu.info.set.SetSideMenu;
import app.management.menu.info.side.SideMenu;
import app.management.menu.info.side.chip.ChipMenu;
import app.management.menu.info.side.cookie.CookieMenu;
import app.management.menu.info.side.drink.DrinkMenu;
import app.management.menu.info.side.wedgesandsoup.WedgesAndSoupMenu;
import app.product.combo.SandwichCombo;
import app.product.sandwich.Sandwich;
import app.product.set.SandwichSet;
import app.product.side.Setable;
import app.product.side.chip.Chip;
import app.product.side.cookie.Cookie;
import app.product.side.drink.Drink;
import app.product.side.wedgesandsoup.WedgesAndSoup;

public class OrderApp {

    private final Menu menu;
    private final MenuHandler menuHandler;
    private final Cart cart;
    private final ProductMaker productMaker;
    private final DiscountHandler discountHandler;
    private final Payment payment;

    public OrderApp(Menu menu, MenuHandler menuHandler, Cart cart, ProductMaker productMaker, DiscountHandler discountHandler, Payment payment) {
        this.menu = menu;
        this.menuHandler = menuHandler;
        this.cart = cart;
        this.productMaker = productMaker;
        this.discountHandler = discountHandler;
        this.payment = payment;
    }

    public void start(){
        while (true){
            int firstMenuAnswer = menuHandler.handleFirstMenu();
            if (firstMenuAnswer == FirstMenu.CHOOSE_PRODUCT.getMenuNum()){
                int chooseProductAnswer = menuHandler.handleChooseProduct();
                if (chooseProductAnswer == ProductCategoryMenu.GO_TO_FIRST.getMenuNum()){
                    continue;
                }
                else if (chooseProductAnswer == ProductCategoryMenu.ORDER_SANDWICH.getMenuNum()){
                    // 샌드위치 선택
                    int sandwichAnswer = menuHandler.handleChooseSandwich(false);
                    if (sandwichAnswer == SandwichMenu.GO_TO_FIRST.getMenuNum()){
                        continue;
                    }
                    else {
                        Sandwich sandwich = makeSandwichProcess(sandwichAnswer);
                        if (sandwich == null){
                            continue;
                        }
                        cart.add(sandwich);
                        continue;
                    }
                }
                else if (chooseProductAnswer == ProductCategoryMenu.ORDER_SIDE.getMenuNum()){
                    int sideAnswer = menuHandler.handleChooseSide();
                    if (sideAnswer == SideMenu.GO_TO_FIRST.getMenuNum()){
                        continue;
                    }
                    else if (sideAnswer == SideMenu.ORDER_COOKIE.getMenuNum()){
                        int cookieAnswer = menuHandler.handleChooseCookie(false);
                        if  (cookieAnswer == CookieMenu.GO_TO_FIRST.getMenuNum()){
                            continue;
                        }
                        else {
                            Cookie cookie = productMaker.makeCookie(cookieAnswer);
                            cart.add(cookie);
                            continue;
                        }
                    }
                    else if (sideAnswer == SideMenu.ORDER_CHIP.getMenuNum()){
                        int chipAnswer = menuHandler.handleChooseChip(false);
                        if  (chipAnswer == ChipMenu.GO_TO_FIRST.getMenuNum()){
                            continue;
                        }
                        else {
                            Chip chip = productMaker.makeChip(chipAnswer);
                            cart.add(chip);
                            continue;
                        }
                    }
                    else if (sideAnswer == SideMenu.ORDER_WEDGES_AND_SOUP.getMenuNum()){
                        int wedgesAndSoupAnswer = menuHandler.handleChooseWedgesAndSoup();
                        if  (wedgesAndSoupAnswer == WedgesAndSoupMenu.GO_TO_FIRST.getMenuNum()){
                            continue;
                        }
                        else {
                            WedgesAndSoup wedgesAndSoup = productMaker.makeWedgesAndSoup(wedgesAndSoupAnswer);
                            cart.add(wedgesAndSoup);
                        }
                    }
                    else if (sideAnswer == SideMenu.ORDER_DRINK.getMenuNum()){
                        int drinkAnswer = menuHandler.handleChooseDrink(false);
                        if  (drinkAnswer == DrinkMenu.GO_TO_FIRST.getMenuNum()){
                            continue;
                        }
                        else {
                            Drink drink = productMaker.makeDrink(drinkAnswer);
                            cart.add(drink);
                        }
                    }
                }
                else if (chooseProductAnswer == ProductCategoryMenu.ORDER_SET.getMenuNum()){
                    SandwichSet sandwichSet = makeSandwichSetProcess();
                    if (sandwichSet == null){
                        continue;
                    }
                    cart.add(sandwichSet);
                }
                else if (chooseProductAnswer == ProductCategoryMenu.ORDER_COMBO.getMenuNum()){
                    SandwichCombo sandwichCombo = makeSandwichComboProcess();
                    if (sandwichCombo == null){
                        continue;
                    }
                    cart.add(sandwichCombo);
                }
            // 장바구니
            } else if (firstMenuAnswer == FirstMenu.CART.getMenuNum()){
                boolean checkGoToPayment = false;
                while (true) {
                    menu.printCartMain();
                    cart.printAllCart();
                    int cartMenuAnswer = menuHandler.handleChooseCartMenu();
                    if (cartMenuAnswer == CartMenu.GO_TO_FIRST.getMenuNum()) {
                        break;
                    } else if (cartMenuAnswer == CartMenu.VIEW_DETAIL.getMenuNum()) {
                        cart.printAllCart();
                        int viewDetailAnswer = menuHandler.handleViewDetailCart(cart.getCartSize());
                        cart.printProductDetail(viewDetailAnswer, true);
                    } else if (cartMenuAnswer == CartMenu.REMOVE_FROM_CART.getMenuNum()) {
                        cart.printAllCart();
                        int removeFromCartAnswer = menuHandler.handleRemoveFromCart(cart.getCartSize());
                        cart.removeFromCart(removeFromCartAnswer);
                    } else if (cartMenuAnswer == CartMenu.CLEAR_CART.getMenuNum()) {
                        menu.printYesOrNoMenu();
                        menu.askSureClearCart();
                        int yesOrNoAnswer = menuHandler.handleYesOrNo();
                        if (yesOrNoAnswer == YesOrNo.YES.getMenuNum()) {
                            cart.clearCart();
                        }
                    } else if (cartMenuAnswer == CartMenu.GO_TO_PAYMENT.getMenuNum()) {
                        if (cart.getCartSize() != 0) {
                            checkGoToPayment = true;
                            break;
                        } else {
                            menu.printCantEnterPayment();
                        }
                    }
                }
                if (checkGoToPayment) {
                    while (true) {
                        menu.printPaymentMain();
                        payment.printPaymentState();
                        int paymentMenuAnswer = menuHandler.handlePaymentMenu();
                        if (paymentMenuAnswer == PaymentMenu.GO_TO_FIRST.getMenuNum()) {
                            break;
                        } else if (paymentMenuAnswer == PaymentMenu.PAY.getMenuNum()){
                            payment.doPay();
                            cart.clearCart();
                            discountHandler.clearDiscount();
                        } else if (paymentMenuAnswer == PaymentMenu.CHOOSE_DISCOUNT.getMenuNum()){
                            // 할인 선택 메뉴
                            while (true){
                                int discountMenuAnswer = menuHandler.handleDiscountMenu();
                                if (discountMenuAnswer == DiscountMenu.GO_BACK.getMenuNum()) {
                                    break;
                                } else if (discountMenuAnswer == DiscountMenu.ADD_DISCOUNT.getMenuNum()) {
                                    menu.printDiscountGuideMessage();
                                    discountHandler.printDiscountList();
                                    int addDiscountType = menuHandler.handleAddDiscountMenu();
                                    if (addDiscountType == AddDiscountMenu.GO_BACK.getMenuNum()) {
                                        continue;
                                    } else if (addDiscountType == AddDiscountMenu.ADD_RATE_DISCOUNT.getMenuNum()){
                                        int rateDiscountMenuAnswer = menuHandler.handleRateDiscountMenu();
                                        Integer rateDiscountId = findRateDiscountId(rateDiscountMenuAnswer);
                                        if (rateDiscountId != null) {
                                            discountHandler.addDiscountProcess(rateDiscountId);
                                        }
                                    } else if (addDiscountType == AddDiscountMenu.ADD_FIXED_DISCOUNT.getMenuNum()) {
                                        int fixedDiscountMenuAnswer = menuHandler.handleFixedDiscountMenu();
                                        Integer fixedDiscountId = findFixedDiscountId(fixedDiscountMenuAnswer);
                                        if (fixedDiscountId != null) {
                                            discountHandler.addDiscountProcess(fixedDiscountId);
                                        }
                                    }
                                } else if (discountMenuAnswer == DiscountMenu.REMOVE_DISCOUNT.getMenuNum()) {
                                    discountHandler.printDiscountList();
                                    int removeDiscountAnswer = menuHandler.handleRemoveDiscount(discountHandler.getDiscountSize());
                                    discountHandler.removeDiscount(removeDiscountAnswer);
                                } else if (discountMenuAnswer == DiscountMenu.CLEAR_DISCOUNT.getMenuNum()) {
                                    menu.printYesOrNoMenu();
                                    menu.askSureClearDiscount();
                                    int yesOrNoAnswer = menuHandler.handleYesOrNo();
                                    if (yesOrNoAnswer == YesOrNo.YES.getMenuNum()) {
                                        discountHandler.clearDiscount();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private Integer findFixedDiscountId(int menuNum) {
        for (FixedDiscountMenu fixedDiscount : FixedDiscountMenu.values()) {
            if (menuNum == fixedDiscount.getMenuNum()){
                return fixedDiscount.getId();
            }
        }
        System.out.println("❗️❗️❗할인 정보를 찾을 수 없습니다.");
        System.out.println("❗️❗️❗다시 시도해주세요.");
        return null;
    }

    private Integer findRateDiscountId(int menuNum) {
        for (RateDiscountMenu rateDiscount : RateDiscountMenu.values()) {
            if (menuNum == rateDiscount.getMenuNum()){
                return rateDiscount.getId();
            }
        }
        System.out.println("❗️❗️❗할인 정보를 찾을 수 없습니다.");
        System.out.println("❗️❗️❗다시 시도해주세요.");
        return null;
    }

    // 샌드위치 생성과정
    private Sandwich makeSandwichProcess(int sandwichAnswer){
        try {
            Bread bread = productMaker.makeBread(menuHandler.handleChooseBreadKind(), menuHandler.handleChooseBreadBake(), menuHandler.handleChooseBreadLength());
            Cheese[] cheeses = productMaker.makeCheeses(menuHandler.handleChooseCheese());
            Vegetable[] vegetables = productMaker.makeVegetables(menuHandler.handleChooseVegetable());
            Sauce[] sauces = productMaker.makeSauces(menuHandler.handleChooseSauce());
            AdditionalIngredient[] additionalIngredients = productMaker.makeAdditionalIngres(menuHandler.handleChooseAdditionalIngre());
            Sandwich sandwich = productMaker.makeSandwich(sandwichAnswer, bread, cheeses, vegetables, sauces, additionalIngredients);
            return sandwich;
        } catch (Exception e){
            System.out.println("❗️❗️❗️샌드위치 생성 과정 중 오류가 발생하였습니다.");
            System.out.println("❗️❗️❗️처음으로 돌아갑니다.");
            return null;
        }
    }

    // 샌드위치 세트 생성과정
    private SandwichSet makeSandwichSetProcess(){
        try {
            menu.printChooseSetComment();
            int sandwichAnswer = menuHandler.handleChooseSandwich(true);
            Sandwich sandwich = makeSandwichProcess(sandwichAnswer);
            if (sandwich == null) {
                return null;
            }
            int setOption = menuHandler.handleChooseSetOptionSide();
            Setable setableSide = null;
            if (setOption == SetSideMenu.COOKIE.getMenuNum()){
                int cookieAnswer = menuHandler.handleChooseCookie(true);
                setableSide = productMaker.makeCookie(cookieAnswer);
            }
            else if(setOption == SetSideMenu.CHIP.getMenuNum()){
                int chipAnswer = menuHandler.handleChooseChip(true);
                setableSide = productMaker.makeChip(chipAnswer);
            }
            int drinkAnswer = menuHandler.handleChooseDrink(true);
            Drink drink = productMaker.makeDrink(drinkAnswer);
            SandwichSet sandwichSet = productMaker.makeSet(sandwich, setableSide, drink);
            return sandwichSet;
        } catch (Exception e) {
            System.out.println("❗️❗️❗️샌드위치 세트 구성 과정 중 오류가 발생하였습니다.");
            System.out.println("❗️❗️❗️처음으로 돌아갑니다.");
            return null;
        }
    }

    // 샌드위치 콤보 생성과정
    private SandwichCombo makeSandwichComboProcess(){
        try {
            menu.printChooseComboComment();
            int sandwichAnswer = menuHandler.handleChooseSandwich(true);
            Sandwich sandwich = makeSandwichProcess(sandwichAnswer);
            if (sandwich == null) {
                return null;
            }
            int drinkAnswer = menuHandler.handleChooseDrink(true);
            Drink drink = productMaker.makeDrink(drinkAnswer);
            SandwichCombo sandwichCombo = productMaker.makeCombo(sandwich, drink);
            return sandwichCombo;
        } catch (Exception e) {
            System.out.println("❗️❗️❗️샌드위치 콤보 구성 과정 중 오류가 발생하였습니다.");
            System.out.println("❗️❗️❗️처음으로 돌아갑니다.");
            return null;
        }
    }
}
