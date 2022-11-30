package app.management.menu.info;

import java.util.Arrays;

public enum PaymentMenu {
    PAY(1,"[1. 결제 ]"),
    CHOOSE_DISCOUNT(2, "[2. 할인 선택]"),
    GO_TO_FIRST(0,"[0. 처음으로]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    PaymentMenu(int menuNum, String menuName) {
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public int getMenuNum() {
        return menuNum;
    }

    public String getMenuName() {
        return menuName;
    }

    // 모든 메뉴 번호 반환
    public static int[] getAllPaymentMenuNum() {
        return Arrays.stream(PaymentMenu.values()).mapToInt(PaymentMenu::getMenuNum).toArray();
    }
}
