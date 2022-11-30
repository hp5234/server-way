package app.management.menu.info.discount;

import app.management.discount.SundayDiscount;
import app.management.discount.TelecomDiscount;

import java.util.Arrays;

public enum FixedDiscountMenu {

    TELECOM_DISCOUNT(1,"[1. " + TelecomDiscount.getOriginalName() + "]", TelecomDiscount.getOriginalId(), TelecomDiscount.getOriginalDiscountAmount()),
    SUNDAY_DISCOUNT(2,"[2. " + SundayDiscount.getOriginalName() + "]", SundayDiscount.getOriginalId(), SundayDiscount.getOriginalDiscountAmount());

    private final int menuNum; // 메뉴 번호
    private final String menuName;
    private final int id;
    private final int discountAmount;

    FixedDiscountMenu(int menuNum, String menuName, int id, int discountAmount) {
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
    public static int[] getAllFixedDiscountMenuNum() {
        return Arrays.stream(FixedDiscountMenu.values()).mapToInt(FixedDiscountMenu::getMenuNum).toArray();
    }
}
