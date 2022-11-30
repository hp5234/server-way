package app.management.menu;

import app.management.menu.info.*;
import app.management.menu.info.discount.FixedDiscountMenu;
import app.management.menu.info.discount.RateDiscountMenu;
import app.management.menu.info.sandwich.SandwichMenu;
import app.management.menu.info.sandwich.option.additioaningredient.AdditionalIngreOptionMenu;
import app.management.menu.info.sandwich.option.bread.BreadBakeMenu;
import app.management.menu.info.sandwich.option.bread.BreadKindMenu;
import app.management.menu.info.sandwich.option.bread.BreadLengthMenu;
import app.management.menu.info.sandwich.option.cheese.AdditionalCheeseMenu;
import app.management.menu.info.sandwich.option.cheese.CheeseKindMenu;
import app.management.menu.info.sandwich.option.sauce.SauceIngreOptionMenu;
import app.management.menu.info.sandwich.option.vegetable.VegetablesIngreOptionMenu;
import app.management.menu.info.set.SetSideMenu;
import app.management.menu.info.side.SideMenu;
import app.management.menu.info.side.chip.ChipMenu;
import app.management.menu.info.side.cookie.CookieMenu;
import app.management.menu.info.side.drink.DrinkMenu;
import app.management.menu.info.side.wedgesandsoup.WedgesAndSoupMenu;

import java.util.HashSet;
import java.util.Scanner;

public class MenuHandler {

    private final Menu menu;
    private Scanner sc = new Scanner(System.in);

    public MenuHandler(Menu menu) {
        this.menu = menu;
    }

    // 초기화면 선택 과정
    public int handleFirstMenu(){
        menu.printFirstMenu();
        while(true){
            menu.askFistMenu();
            try {
                int result = sc.nextInt();
                for (int value : FirstMenu.getAllFirstMenuNum()) {
                    if (value == result){
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 제품 선택하기 선택 과정
    public int handleChooseProduct(){
        menu.printChooseProduct();
        while(true){
            menu.askChooseProduct();
            try {
                int result = sc.nextInt();
                for (int value : ProductCategoryMenu.getAllProductCategoryMenuNum()) {
                    if (value == result){
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 샌드위치 종류 선택 과정
    public int handleChooseSandwich(boolean isIncludeSetOrCombo){
        menu.printChooseSandwich(isIncludeSetOrCombo);
        while(true){
            menu.askChooseSandwich();
            try {
                int result = sc.nextInt();
                for (int value : SandwichMenu.getAllSandwichMenuNum()) {
                    if (value == result){
                        if (isIncludeSetOrCombo && value == SandwichMenu.GO_TO_FIRST.getMenuNum()){
                            continue;
                        }
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 빵 옵션 - 길이 선택 과정
    public int handleChooseBreadLength(){
        BreadLengthMenu[] lengthMenus = BreadLengthMenu.values();
        menu.printChooseBreadLength();
        while(true){
            menu.askChooseBreadLength();
            try {
                int result = sc.nextInt();
                for (BreadLengthMenu lengthMenu : lengthMenus) {
                    if (result == lengthMenu.getMenuNum()){
                        return lengthMenu.getValue();
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 빵 옵션 - 굽기 선택 과정
    public boolean handleChooseBreadBake() {
        BreadBakeMenu[] bakeMenus = BreadBakeMenu.values();
        menu.printChooseBreadBake();
        while(true){
            menu.askChooseBreadBake();
            try {
                int result = sc.nextInt();
                for (BreadBakeMenu bakeMenu : bakeMenus) {
                    if (result == bakeMenu.getMenuNum()){
                        return bakeMenu.getValue();
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 빵 옵션 - 종류 선택 과정
    public int handleChooseBreadKind() {
        menu.printChooseBreadKind();
        while(true){
            menu.askChooseBreadKind();
            try {
                int result = sc.nextInt();
                for (int value : BreadKindMenu.getAllBreadKindMenuNum()) {
                    if (value == result){
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 치즈 옵션 설정 과정
    public int[] handleChooseCheese() {
        menu.printCheeseMain();
        int basicCheese = handleChooseCheeseKind();
        if (basicCheese != CheeseKindMenu.NONE_CHEESE.getMenuNum()){
            int additionalCheese = handleChooseAdditionalCheese();
            if (additionalCheese != AdditionalCheeseMenu.NONE_CHEESE.getMenuNum()){
                return new int[]{basicCheese, additionalCheese};
            } else {
                return new int[]{basicCheese};
            }
        } else {
            return new int[]{};
        }
    }

    // 기본 치즈 옵션
    public int handleChooseCheeseKind() {
        menu.printChooseCheeseKind();
        while(true){
            menu.askChooseCheeseKind();
            try {
                int result = sc.nextInt();
                for (int value : CheeseKindMenu.getAllCheeseKindMenuNum()) {
                    if (value == result){
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }
    // 추가 치즈 옵션
    public int handleChooseAdditionalCheese() {
        menu.printChooseAdditionalCheese();
        while(true){
            menu.askChooseAdditionalCheese();
            try {
                int result = sc.nextInt();
                for (int value : AdditionalCheeseMenu.getAllAdditionalCheeseMenuNum()) {
                    if (value == result){
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    // 야채 옵션 - 포함할 야채 설정 과정
    public int[] handleChooseVegetable() {
        HashSet<Integer> vegeSet = new HashSet<>();
        int maxSize = VegetablesIngreOptionMenu.getAllOnlyVegeMenuNum().length;

        menu.printChooseVegetable();
        while (vegeSet.size() <  maxSize) {
            menu.askChooseVegetable();
            int result = handleVegetableAnswer();
            if (result == VegetablesIngreOptionMenu.ALL.getMenuNum() ) {
                System.out.println("선택결과 : ");
                System.out.println("\t[야채 모두 포함 선택]");
                return VegetablesIngreOptionMenu.getAllOnlyVegeMenuNum();
            }
            else if (result == VegetablesIngreOptionMenu.COMPLETE.getMenuNum()) {
                if (vegeSet.isEmpty()){
                    System.out.println("선택결과 : ");
                    System.out.println("\t[선택 야채 없음]");
                    return new int[]{};
                } else {
                    return vegeSet.stream().mapToInt(Integer::intValue).toArray();
                }
            }
            else {
                if (!vegeSet.add(result)){
                    menu.printAlreadyExistMessage();
                }
            }
            menu.printCurrentChoosedVegetable(vegeSet);
            if (vegeSet.size() == maxSize){
                return vegeSet.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return null;
    }

    // 야채 선택 답변 확인 과정
    public int handleVegetableAnswer() {
        while(true){
            try {
                int result = sc.nextInt();
                for (int value : VegetablesIngreOptionMenu.getAllVegetablesIngreOptionMenu()) {
                    if (value == result){
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                menu.askChooseVegetable();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                menu.askChooseVegetable();
                sc.nextLine();
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////

    // 소스 옵션 - 포함할 소스 설정 과정
    public int[] handleChooseSauce() {
        HashSet<Integer> sauceSet = new HashSet<>();

        menu.printChooseSauce();
        while (sauceSet.size() < SauceIngreOptionMenu.MAX_USABLE_COUNT ) {
            menu.askChooseSauce();
            int result = handleSauceAnswer();
            if (result == SauceIngreOptionMenu.NONE_SAUCE.getMenuNum() ) {
                return new int[]{};
            }
            else if (result == SauceIngreOptionMenu.COMPLETE.getMenuNum()) {
                if (sauceSet.isEmpty()){
                    System.out.println("선택결과 : ");
                    System.out.println("\t[선택된 소스 없음]");
                    return new int[]{};
                } else {
                    return sauceSet.stream().mapToInt(Integer::intValue).toArray();
                }
            }
            else {
                if (!sauceSet.add(result)){
                    menu.printAlreadyExistMessage();
                }
            }
            menu.printCurrentChoosedSauce(sauceSet);
            if (sauceSet.size() == SauceIngreOptionMenu.MAX_USABLE_COUNT){
                return sauceSet.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return null;
    }

    // 소스 선택 답변 확인 과정
    public int handleSauceAnswer() {
        while(true){
            try {
                int result = sc.nextInt();
                for (int value : SauceIngreOptionMenu.getAllSauceIngreOptionMenuNum()) {
                    if (value == result){
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                menu.askChooseSauce();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                menu.askChooseSauce();
                sc.nextLine();
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////

    // 추가재료 옵션 - 포함할 추가재료 설정 과정
    public int[] handleChooseAdditionalIngre() {
        HashSet<Integer> additionalIngreSet = new HashSet<>();
        int maxSize = AdditionalIngreOptionMenu.getAllOnlyIngreMenuNum().length;

        menu.printChooseAdditionalIngre();
        while (additionalIngreSet.size() < maxSize ) {
            menu.askChooseAdditionalIngre();
            int result = handleAdditionalIngreAnswer();
            if (result == AdditionalIngreOptionMenu.NONE_ADDITIONAL_INGRE.getMenuNum()) {
                return new int[]{};
            }
            else if (result == AdditionalIngreOptionMenu.COMPLETE.getMenuNum()) {
                if (additionalIngreSet.isEmpty()){
                    System.out.println("선택결과 : ");
                    System.out.println("\t[선택된 추가재료 없음]");
                    return new int[]{};
                } else {
                    return additionalIngreSet.stream().mapToInt(Integer::intValue).toArray();
                }
            }
            else {
                if (!additionalIngreSet.add(result)){
                    menu.printAlreadyExistMessage();
                }
            }
            menu.printCurrentChoosedAdditionalIngre(additionalIngreSet);
            if (additionalIngreSet.size() == maxSize){
                return additionalIngreSet.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return null;
    }

    // 추가재료 선택 답변 확인 과정
    public int handleAdditionalIngreAnswer() {
        while(true){
            try {
                int result = sc.nextInt();
                for (int value : AdditionalIngreOptionMenu.getAllAdditionalIngreMenuNum()) {
                    if (value == result){
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                menu.askChooseAdditionalIngre();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                menu.askChooseAdditionalIngre();
                sc.nextLine();
            }
        }
    }

    // 세트 옵션 과정
    public int handleChooseSetOptionSide() {
        menu.printChooseCookieOrChip();
        while(true){
            menu.askChooseCookieOrChip();
            try {
                int result = sc.nextInt();
                for (int value : SetSideMenu.getAllComboSideMenuNum()) {
                    if (value == result){
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 사이드 주문 과정
    public int handleChooseSide(){
        menu.printChooseSide();
        while(true){
            menu.askChooseSide();
            try {
                int result = sc.nextInt();
                for (int value : SideMenu.getAllSideMenuNum()) {
                    if (value == result){
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 쿠키 주문 과정
    public int handleChooseCookie(boolean isIncludeSet){
        menu.printChooseCookie(isIncludeSet);
        while(true){
            menu.askChooseCookie();
            try {
                int result = sc.nextInt();
                for (int value : CookieMenu.getAllCookieMenuNum()) {
                    if (value == result){
                        if (isIncludeSet && value == CookieMenu.GO_TO_FIRST.getMenuNum()){
                            continue;
                        }
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 칩 주문하기
    public int handleChooseChip(boolean isIncludeSet){
        menu.printChooseChip(isIncludeSet);
        while(true){
            menu.askChooseChip();
            try {
                int result = sc.nextInt();
                for (int value : ChipMenu.getAllChipMenuNum()) {
                    if (value == result){
                        if (isIncludeSet && value == ChipMenu.GO_TO_FIRST.getMenuNum()){
                            continue;
                        }
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 웨지 또는 스프 주문 하기
    public int handleChooseWedgesAndSoup(){
        menu.printChooseWedgesAndSoup();
        while(true){
            menu.askChooseWedgesAndSoup();
            try {
                int result = sc.nextInt();
                for (int value : WedgesAndSoupMenu.getAllWedgesAndSoupMenuNum()) {
                    if (value == result){
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 음료 주문 하기 과정
    public int handleChooseDrink(boolean isIncludeSetOrCombo){
        menu.printChooseWedgesAndDrink(isIncludeSetOrCombo);
        while(true){
            menu.askChooseDrink();
            try {
                int result = sc.nextInt();
                for (int value : DrinkMenu.getAllDrinkMenuNum()) {
                    if (value == result){
                        if (isIncludeSetOrCombo && value == DrinkMenu.GO_TO_FIRST.getMenuNum()){
                            continue;
                        }
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    // 장바구니
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    // 장바구니 메뉴 선택 과정
    public int handleChooseCartMenu(){
        menu.printCartMenu();
        while(true){
            menu.askChooseCartMenu();
            try {
                int result = sc.nextInt();
                for (int value : CartMenu.getAllCartMenuNum()) {
                    if (value == result){
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 장바구니에서 상세보기
    public int handleViewDetailCart(int cartMaxSize) {
        while(true){
            menu.askChooseViewDetailCart();
            try {
                int result = sc.nextInt();
                if (result > 0 && result <= cartMaxSize){
                    return result;
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 장바구니에서 삭제
    public int handleRemoveFromCart(int cartMaxSize) {
        while(true){
            menu.askChooseRemoveFromCart();
            try {
                int result = sc.nextInt();
                if (result > 0 && result <= cartMaxSize){
                    return result;
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    // 결제하기
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    // 결제하기 메뉴 선택 과정
    public int handlePaymentMenu() {
        menu.printPaymentMenu();
        while (true) {
            menu.askChoosePaymentMenu();
            try {
                int result = sc.nextInt();
                for (int value : PaymentMenu.getAllPaymentMenuNum()) {
                    if (value == result) {
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    // 할인 관련
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    // 할인 메뉴 선택 과정
    public int handleDiscountMenu() {
        menu.printDiscountMenu();
        while (true) {
            menu.askChooseDiscountMenu();
            try {
                int result = sc.nextInt();
                for (int value : DiscountMenu.getAllDiscountMenuNum()) {
                    if (value == result) {
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 할인 추가하기 메뉴 선택 과정
    public int handleAddDiscountMenu() {
        menu.printAddDiscountMenu();
        while (true) {
            menu.askChooseAddDiscountMenu();
            try {
                int result = sc.nextInt();
                for (int value : AddDiscountMenu.getAllAddDiscountMenuNum()) {
                    if (value == result) {
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 비율할인 선택 과정
    public int handleRateDiscountMenu() {
        menu.printRateDiscountMenu();
        while (true) {
            menu.askChooseRateDiscountMenu();
            try {
                int result = sc.nextInt();
                for (int value : RateDiscountMenu.getAllRateDiscountMenuNum()) {
                    if (value == result) {
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 금액할인 메뉴 선택 과정
    public int handleFixedDiscountMenu() {
        menu.printFixedDiscountMenu();
        while (true) {
            menu.askChooseFixedDiscountMenu();
            try {
                int result = sc.nextInt();
                for (int value : FixedDiscountMenu.getAllFixedDiscountMenuNum()) {
                    if (value == result) {
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    // 할인 삭제하기
    public int handleRemoveDiscount(int discountSize) {
        while(true){
            menu.askChooseRemoveDiscount();
            try {
                int result = sc.nextInt();
                if (result > 0 && result <= discountSize){
                    return result;
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e ) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    // Yes or No
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public int handleYesOrNo() {
        while(true){
            try {
                int result = sc.nextInt();
                for (int value : YesOrNo.getAllYesOrNoNum()) {
                    if (value == result) {
                        return result;
                    }
                }
                menu.printWrongNumberMessage();
                sc.nextLine();
            } catch (RuntimeException e) {
                menu.printWrongInputMessage();
                sc.nextLine();
            }
        }
    }
}
