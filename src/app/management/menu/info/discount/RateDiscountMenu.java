package app.management.menu.info.discount;

import app.management.discount.AgeDiscount;
import app.management.discount.LunchDiscount;

import java.util.Arrays;

public enum RateDiscountMenu {
    AGE_DISCOUNT(1,"[1. " + AgeDiscount.getOriginalName() + "]", AgeDiscount.getOriginalId(), AgeDiscount.getOriginalDiscountAmount()),
    LUNCH_DISCOUNT(2,"[2. " + LunchDiscount.getOriginalName() + "]", LunchDiscount.getOriginalId(), LunchDiscount.getOriginalDiscountAmount());

    private final int menuNum; // 메뉴 번호
    private final String menuName;
    private final int id;
    private final int discountAmount;

    RateDiscountMenu(int menuNum, String menuName, int id, int discountAmount) {
        this.menuNum = menuNum;
        this.menuName = menuName;
        this.id = id;
        this.discountAmount = discountAmount;
    }

    public int getMenuNum() {
        return menuNum;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getId() {
        return id;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    // 모든 메뉴 번호 반환
    public static int[] getAllRateDiscountMenuNum() {
        return Arrays.stream(RateDiscountMenu.values()).mapToInt(RateDiscountMenu::getMenuNum).toArray();
    }
}
