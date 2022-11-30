package app.management.discount;

import java.util.Scanner;

public class TelecomDiscount extends FixedDiscount{

    private static final int ID = 3;
    private static final String NAME = "통신사 할인";
    private static final int DISCOUNT_AMOUNT = 1000;

    public TelecomDiscount() {
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
            System.out.println("\n[ 1. SKT ] [ 2. KT ] [ 3. LG ] \n");
            System.out.print("이용하시는 통신사를 선택해주세요.(숫자만 입력가능) >>> ");
            int telecomResult = sc.nextInt();
            return telecomResult == 1;
        } catch (RuntimeException e){
            System.out.println("❗️***잘못된 입력입니다.");
            System.out.println("❗️***선택가능한 숫자만 입력 가능합니다.\n");
            return false;
        }
    }
}
