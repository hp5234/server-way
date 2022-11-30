package app.management.discount;

import java.util.Scanner;

public class AgeDiscount extends RateDiscount{

    private static final int ID = 1;
    private static final String NAME = "나이 우대 할인";
    private static final int DISCOUNT_AMOUNT = 10;

    public AgeDiscount() {
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
            System.out.print("고객님의 나이를 입력해주세요. >>> ");
            int ageResult = sc.nextInt();
            return ageResult >= 50 || ageResult <= 10;
        } catch (RuntimeException e){
            System.out.println("❗️***잘못된 입력입니다.");
            System.out.println("❗️***선택가능한 숫자만 입력 가능합니다.\n");
            return false;
        }
    }


}
