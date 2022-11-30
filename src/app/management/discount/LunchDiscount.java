package app.management.discount;

import java.util.Scanner;

public class LunchDiscount extends RateDiscount{

    private static final int ID = 2;
    private static final String NAME = "런치타임 할인";
    private static final int DISCOUNT_AMOUNT = 20;

    public LunchDiscount() {
        super(ID, NAME, DISCOUNT_AMOUNT);
    }

    public static int getOriginalId(){
        return ID;
    }
    public static String getOriginalName(){
        return NAME;
    }
    public static int getOriginalDiscountAmount(){
        return DISCOUNT_AMOUNT;
    }

    @Override
    boolean checkCondition() {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("입력예시 : 13시 58분인 경우 -> 13 를 입력 ");
            System.out.println("입력예시 : 16시 58분인 경우 -> 16 를 입력 \n");
            System.out.print("현재 시간의 시간 부분을 입력해주세요. >>> ");
            int timeResult = sc.nextInt();
            return timeResult >= 11 && timeResult <= 14;
        } catch (RuntimeException e){
            System.out.println("❗️***잘못된 입력입니다.");
            System.out.println("❗️***선택가능한 숫자만 입력 가능합니다.\n");
            return false;
        }
    }


}
