package app.management.menu;

import app.ingredient.additionalingredient.AdditionalIngredient;
import app.ingredient.cheese.Cheese;
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
import app.product.combo.SandwichCombo;
import app.product.set.SandwichSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Menu {


    // 에러 메세지 출력 - 범위 초과
    public void printWrongNumberMessage(){
        System.out.println("❗️***잘못된 입력입니다.");
        System.out.println("❗️***선택가능한 번호를 다시 확인해주세요.\n");
    }

    // 에러 메세지 출력 - 입력 오류
    public void printWrongInputMessage(){
        printWrongNumberMessage();
        System.out.println("❗️***숫자만 입력 가능합니다.\n");
    }

    // 에러 메세지 출력 - 중복 입력
    public void printAlreadyExistMessage(){
        System.out.println("❗️***이미 선택한 항목입니다.\n");
    }

    // 초기화면 메뉴 출력
    public void printFirstMenu(){
        System.out.println("🚃".repeat(30));
        System.out.println("🥪 ServerWay Order Service  🥪");
        System.out.println("🚃".repeat(30) + "\n");
        System.out.println("[📣] 안녕하세요!");

        for (FirstMenu value : FirstMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askFistMenu(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 이용하실 서비스를 선택해주세요 : ");
    }

    // 제품 선택하기 출력
    public void printChooseProduct(){
        System.out.println("-".repeat(60));
        System.out.println("[📣] 제품 선택하기");
        System.out.println("-".repeat(60) + "\n");

        for (ProductCategoryMenu value : ProductCategoryMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChooseProduct(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 주문할 제품을 선택해주세요 : ");
    }

    // 샌드위치 선택하기 출력
    public void printChooseSandwich(boolean isIncludeSetOrCombo){
        System.out.println("-".repeat(60));
        System.out.println("[📣] 샌드위치 주문하기  🥪");
        System.out.println("-".repeat(60) + "\n");
        if (!isIncludeSetOrCombo){
            System.out.println("표시 가격은 빵 길이 15cm, 추가치즈없음, 추가재료없음 기준입니다");
            System.out.println("가격은 샌드위치 옵션에 따라 달라질 수 있습니다.\n");
        }
        for (SandwichMenu value : SandwichMenu.values()) {
            if (value.getMenuNum() == SandwichMenu.GO_TO_FIRST.getMenuNum()){
                if (isIncludeSetOrCombo == false) {
                    System.out.println(value.getMenuName());
                    continue;
                } else {
                    continue;
                }
            }
            if (!isIncludeSetOrCombo){
                System.out.printf("%s - 가격: %5d원\n",value.getMenuName(), value.getPrice());
            } else {
                System.out.printf("%s\n",value.getMenuName());
            }
        }
        System.out.println();
    }
    public void askChooseSandwich(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 샌드위치 제품을 선택해주세요 : ");
    }

    // 빵 옵션 화면 출력
    public void printBreadMain(){
        System.out.println("-".repeat(60));
        System.out.println("🍞 샌드위치: 빵 옵션을 선택해주세요 🍞");
        System.out.println("-".repeat(60) + "\n");
    }

    // 빵 옵션 - 길이 선택 출력
    public void printChooseBreadLength(){
        System.out.println("\n빵 옵션 1. :  빵 길이");
        for (BreadLengthMenu value : BreadLengthMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChooseBreadLength(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 빵 길이를 선택해주세요. : ");
    }

    // 빵 옵션 - 굽기 선택 출력
    public void printChooseBreadBake(){
        System.out.println("\n빵 옵션 2. :  빵 굽기");
        for (BreadBakeMenu value : BreadBakeMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChooseBreadBake(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 빵 굽기를 선택해주세요. : ");
    }

    // 빵 옵션 - 종류 선택 출력
    public void printChooseBreadKind(){
        System.out.println("\n빵 옵션 3. :  빵 종류");
        for (BreadKindMenu value : BreadKindMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChooseBreadKind(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 빵 종류를 선택해주세요. : ");
    }

    // 치즈 옵션 선택하기
    public void printCheeseMain(){
        System.out.println("-".repeat(60));
        System.out.println("🧀 샌드위치: 치즈 옵션을 선택해주세요 🧀");
        System.out.println("-".repeat(60) + "\n");
    }

    // 치즈 옵션 - 종류 선택 출력
    public void printChooseCheeseKind(){
        System.out.println("\n1. 치즈 종류 선택");
        for (CheeseKindMenu value : CheeseKindMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChooseCheeseKind(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 치즈 종류를 선택해주세요. : ");
    }

    // 치즈 옵션 - 추가치즈 선택 출력
    public void printChooseAdditionalCheese(){
        System.out.println("\n2. 치즈 추가 선택");
        System.out.println("추가시 추가요금 : " + Cheese.getAdditionalPrice() + " 원\n");
        for (AdditionalCheeseMenu value : AdditionalCheeseMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChooseAdditionalCheese(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 추가 치즈 여부를 선택해주세요. : ");
    }

    // 야채 옵션 선택하기
    public void printChooseVegetable(){
        System.out.println("-".repeat(60));
        System.out.println("🥬 샌드위치: 야채 옵션을 선택해주세요 🥬 ");
        System.out.println("-".repeat(60) + "\n");

        System.out.println("\n종류 :");
        VegetablesIngreOptionMenu[] values = VegetablesIngreOptionMenu.values();
        for (int i = 0; i < values.length-2; i++) {
            System.out.print(values[i].getMenuName() + " ");
            if ((i + 1) % 3 == 0){
                System.out.println();
            }
        }
        System.out.println();
        for (int i = values.length-2; i < values.length; i++) { // 모두포함, 선택완료
            System.out.print(values[i].getMenuName() + " ");
        }
        System.out.println("\n");
    }
    public void askChooseVegetable(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 야채를 선택해주세요.(최대 6개 선택가능)(1개씩 입력) : ");
    }

    // 현재 선택한 야채 출력
    public void printCurrentChoosedVegetable(HashSet<Integer> vegetables ){
        StringBuilder currentVege = new StringBuilder();
        ArrayList<Integer> vegeList = new ArrayList<>(vegetables);
        Collections.sort(vegeList);

        for (Integer vegetable : vegeList) {
            for (VegetablesIngreOptionMenu value : VegetablesIngreOptionMenu.values()) {
                if (vegetable == value.getMenuNum()){
                    currentVege.append(value.getMenuName()).append(" ");
                }
            }
        }
        System.out.println("\n현재 선택한 야채 수 : " + vegetables.size());
        System.out.println("선택결과 : ");
        System.out.println("\t" + currentVege);
        System.out.println();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////

    // 소스 옵션 선택하기 출력
    public void printChooseSauce(){
        System.out.println("-".repeat(60));
        System.out.println("🧂🥫 샌드위치: 소스 옵션을 선택해주세요 🧂🥫");
        System.out.println("-".repeat(60) + "\n");
        System.out.println("\n종류 :");
        SauceIngreOptionMenu[] values = SauceIngreOptionMenu.values();
        for (int i = 0; i < values.length-2; i++) {
            System.out.print(values[i].getMenuName() + " ");
            if ((i + 1) % 3 == 0){
                System.out.println();
            }
        }
        System.out.println();
        for (int i = values.length-2; i < values.length; i++) { // 소스선택안함, 선택완료
            System.out.print(values[i].getMenuName() + " ");
        }
        System.out.println("\n");
    }
    public void askChooseSauce(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 소스를 선택해주세요.(최대 3개 선택가능)(1개씩 입력) : ");
    }

    // 현재 선택한 소스 출력
    public void printCurrentChoosedSauce(HashSet<Integer> sauces ){
        StringBuilder currentSauce = new StringBuilder();
        ArrayList<Integer> sauceList = new ArrayList<>(sauces);
        Collections.sort(sauceList);

        for (Integer sauce : sauceList) {
            for (SauceIngreOptionMenu value : SauceIngreOptionMenu.values()) {
                if (sauce == value.getMenuNum()){
                    currentSauce.append(value.getMenuName()).append(" ");
                }
            }
        }
        System.out.println("\n현재 선택한 소스 수 : " + sauces.size());
        System.out.println("선택결과 : ");
        System.out.println("\t" + currentSauce);
        System.out.println();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    // 추가 재료 옵션 선택하기 출력
    public void printChooseAdditionalIngre(){
        System.out.println("-".repeat(60));
        System.out.println("🍗🥚🥑 추가할 재료 옵션을 선택해주세요 🍗🥚🥑 ");
        System.out.println("-".repeat(60) + "\n");
        System.out.println("\n추가시 종류당 추가요금 : " + AdditionalIngredient.getAdditionalPrice() + " 원\n");
        System.out.println("\n종류 :");
        AdditionalIngreOptionMenu[] values = AdditionalIngreOptionMenu.values();
        for (int i = 0; i < values.length-2; i++) {
            System.out.print(values[i].getMenuName() + " ");
            if ((i + 1) % 3 == 0){
                System.out.println();
            }
        }
        System.out.println();
        for (int i = values.length-2; i < values.length; i++) { // 추가재료 선택안함, 선택완료
            System.out.print(values[i].getMenuName() + " ");
        }
        System.out.println("\n");
    }
    public void askChooseAdditionalIngre(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 추가재료를 선택해주세요.(최대 5개 선택가능)(1개씩 입력) : ");
    }

    // 현재 선택한 추가재료 출력
    public void printCurrentChoosedAdditionalIngre(HashSet<Integer> additionalIngre ){
        StringBuilder currentAdditionalIngre = new StringBuilder();
        ArrayList<Integer> additionalIngreList = new ArrayList<>(additionalIngre);
        Collections.sort(additionalIngreList);

        for (Integer ingre : additionalIngreList) {
            for (AdditionalIngreOptionMenu value : AdditionalIngreOptionMenu.values()) {
                if (ingre == value.getMenuNum()){
                    currentAdditionalIngre.append(value.getMenuName()).append(" ");
                }
            }
        }
        System.out.println("\n현재 선택한 소스 수 : " + additionalIngre.size());
        System.out.println("선택결과 : ");
        System.out.println("\t" + currentAdditionalIngre);
    }

    // 콤보 선택 출력
    public void printChooseComboComment() {
        System.out.println("-".repeat(60));
        System.out.println("🌮🥤콤보 주문하기 🌮🥤");
        System.out.println("-".repeat(60) + "\n");
        System.out.println("\n- 콤보 가격은 샌드위치 가격과 음료가격을 합한 금액보다 " + SandwichCombo.getComboDiscountPrice() + "원 저렴합니다.");
        System.out.println("- 콤보는 [샌드위치주문하기] 와 [음료주문하기]가 순차적으로 진행됩니다.");
        System.out.println("\n- 순서대로 진행해주세요.\n");
    }
    // 세트 선택 출력
    public void printChooseSetComment() {
        System.out.println("-".repeat(60));
        System.out.println("🌮🥤🍟세트 주문하기 🌮🥤🍟");
        System.out.println("-".repeat(60) + "\n");
        System.out.println("\n- 세트 가격은 샌드위치 가격,음료가격,쿠키 or 칩 가격 을 합한 금액보다 " + SandwichSet.getSetDiscountPrice() + "원 저렴합니다.");
        System.out.println("- 세트는 [샌드위치주문하기] 와 [음료주문하기] 와 [쿠키 or 칩 주문하기]가 순차적으로 진행됩니다.");
        System.out.println("\n- 순서대로 진행해주세요.\n");
    }

    // 세트 옵션 - 세트구성(쿠키 or 칩) 선택하기 출력
    public void printChooseCookieOrChip(){
        System.out.println("-".repeat(60));
        System.out.println("☑️ 세트 구성 선택 ");
        System.out.println("세트에 포함될 사이드 구성 중 하나를 선택해주세요. ");
        System.out.println("-".repeat(60) + "\n");
        for (SetSideMenu value : SetSideMenu.values()) {
            System.out.println(value.getMenuName());
        }
    }
    public void askChooseCookieOrChip(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 세트 구성을 선택해주세요. : ");
    }

    // 사이드 선택하기 출력
    public void printChooseSide(){
        System.out.println("-".repeat(60));
        System.out.println("[📣] 사이드 주문하기 🍪🍟🥤");
        System.out.println("-".repeat(60) + "\n");

        for (SideMenu value : SideMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChooseSide(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 사이드를 선택해주세요 :");
    }

    // 쿠키 주문 하기
    public void printChooseCookie(boolean isIncludeSet){
        System.out.println("-".repeat(60));
        System.out.println("[📣] 쿠키 주문하기 🍪");
        System.out.println("-".repeat(60) + "\n");
        for (CookieMenu value : CookieMenu.values()) {
            if (value.getMenuNum() == CookieMenu.GO_TO_FIRST.getMenuNum()){
                if (isIncludeSet == false) {
                    System.out.println(value.getMenuName());
                    continue;
                } else {
                    continue;
                }
            }
            System.out.printf("%s - 가격: %5d원\n",value.getMenuName(), value.getPrice());
        }
        System.out.println();
    }
    public void askChooseCookie(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 쿠키를 선택해주세요 : ");
    }

    // 칩 주문 하기
    public void printChooseChip(boolean isIncludeSet){
        System.out.println("-".repeat(60));
        System.out.println("[📣] 칩 주문하기 🥠");
        System.out.println("-".repeat(60) + "\n");
        for (ChipMenu value : ChipMenu.values()) {
            if (value.getMenuNum() == ChipMenu.GO_TO_FIRST.getMenuNum()){
                if (isIncludeSet == false) {
                    System.out.println(value.getMenuName());
                    continue;
                } else {
                    continue;
                }
            }
            System.out.printf("%s - 가격: %5d원\n",value.getMenuName(), value.getPrice());
        }
        System.out.println();
    }
    public void askChooseChip(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 칩을 선택해주세요 : ");
    }

    // 웨지 또는 스프 주문 하기
    public void printChooseWedgesAndSoup(){
        System.out.println("-".repeat(60));
        System.out.println("[📣] 웨지/스프 주문하기 🍟🍵");
        System.out.println("-".repeat(60) + "\n");
        for (WedgesAndSoupMenu value : WedgesAndSoupMenu.values()) {
            if (value.getMenuNum() == WedgesAndSoupMenu.GO_TO_FIRST.getMenuNum()){
                System.out.println(value.getMenuName());
                continue;
            }
            System.out.printf("%s - 가격: %5d원\n",value.getMenuName(), value.getPrice());
        }
        System.out.println();
    }
    public void askChooseWedgesAndSoup(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 웨지/스프를 선택해주세요 : ");
    }

    // 음료 주문 하기
    public void printChooseWedgesAndDrink(boolean isIncludeSetOrCombo){
        System.out.println("-".repeat(60));
        System.out.println("[📣] 음료 주문하기 ☕️🥤");
        System.out.println("-".repeat(60) + "\n");
        for (DrinkMenu value : DrinkMenu.values()) {
            if (value.getMenuNum() == DrinkMenu.GO_TO_FIRST.getMenuNum()){
                if (isIncludeSetOrCombo == false) {
                    System.out.println(value.getMenuName());
                    continue;
                } else {
                    continue;
                }
            }
            if (!isIncludeSetOrCombo){
                System.out.printf("%s - 가격: %5d원\n",value.getMenuName(), value.getPrice());
            } else {
                System.out.printf("%s\n",value.getMenuName());
            }
        }
        System.out.println();
    }
    public void askChooseDrink(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 음료를 선택해주세요 : ");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    // 장바구니
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    // 장바구니 메인 출력
    public void printCartMain(){
        System.out.println("🚃".repeat(30));
        System.out.println("🧺 장바구니  🧺");
        System.out.println("🚃".repeat(30) + "\n");
    }
    // 장바구니 메뉴 출력
    public void printCartMenu(){
        for (CartMenu value : CartMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChooseCartMenu(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 이용하실 서비스를 선택해주세요 : ");
    }

    // 상세보기
    public void askChooseViewDetailCart(){
        System.out.print("☑️ 상세보기 할 항목의 번호를 선택해주세요 : ");
    }

    // 삭제하기
    public void askChooseRemoveFromCart(){
        System.out.print("☑️ 삭제하실 항목의 번호를 선택해주세요 : ");
    }

    // 전체 삭제 확인
    public void askSureClearCart(){
        System.out.println("-".repeat(60));
        System.out.println("❗️장바구니 항목을 초기화 하시겠습니까?");
        System.out.print("☑️ 항목의 번호를 선택해주세요 : ");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    // 결제하기
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    // 결제하기 진입 불가 메세지 출력
    public void printCantEnterPayment(){
        System.out.println("❗현재 장바구니가 비어있습니다.");
        System.out.println("❗장바구니에 상품을 담은 뒤에 선택가능합니다.");
    }

    // 결제하기 메인 출력
    public void printPaymentMain(){
        System.out.println("🚃".repeat(30));
        System.out.println("💵 결제하기 💵");
        System.out.println("🚃".repeat(30) + "\n");
    }

    // 결제하기 메뉴 출력
    public void printPaymentMenu(){
        for (PaymentMenu value : PaymentMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChoosePaymentMenu(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 이용하실 서비스를 선택해주세요 : ");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    // 할인 관련
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    // 할인 메뉴 출력
    public void printDiscountMenu() {
        System.out.println();
        for (DiscountMenu value : DiscountMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChooseDiscountMenu(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 이용하실 할인서비스를 선택해주세요 : ");
    }

    // 할인 추가하기 메뉴 출력
    public void printAddDiscountMenu() {
        System.out.println();
        for (AddDiscountMenu value : AddDiscountMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChooseAddDiscountMenu(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 추가하실 할인을 선택해주세요 : ");
    }

    // 비율할인 메뉴 출력
    public void printRateDiscountMenu() {
        System.out.println();
        for (RateDiscountMenu value : RateDiscountMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChooseRateDiscountMenu(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 비율할인을 선택해주세요 : ");
    }

    // 금액 할인 메뉴 출력
    public void printFixedDiscountMenu() {
        System.out.println();
        for (FixedDiscountMenu value : FixedDiscountMenu.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }
    public void askChooseFixedDiscountMenu(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 추가하실 고정할인을 선택해주세요 : ");
    }

    // 할인 삭제하기
    public void askChooseRemoveDiscount(){
        System.out.println("-".repeat(60));
        System.out.print("☑️ 삭제하실 항목의 번호를 선택해주세요 : ");
    }

    // 전체 삭제 확인
    public void askSureClearDiscount(){
        System.out.println("-".repeat(60));
        System.out.println("할인 항목을 초기화 하시겠습니까?");
        System.out.print("☑️ 항목의 번호를 선택해주세요 : ");
    }

    // 할인 안내 메세지
    public void printDiscountGuideMessage() {
        System.out.println("\n❗️***비율 할인은 1개만 선택 가능합니다.");
        System.out.println("❗️***금액 할인은 여러개 추가 가능합니다.");
        System.out.println("❗️***비율할인은 추가를 하여도 마지막에 선택한 1개만 적용됩니다.");
        System.out.println("❗️***현재 선택하신 종류와 다른 종류 할인을 선택시 선택하셨던 할인은 자동으로 취소됩니다.\n");
    }

    // 예 아니오 메뉴 출력
    public void printYesOrNoMenu() {
        for (YesOrNo value : YesOrNo.values()) {
            System.out.println(value.getMenuName());
        }
        System.out.println();
    }

}
