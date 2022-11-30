package app.management.discount;

import java.util.Scanner;

public class SundayDiscount extends FixedDiscount{

    private static final int ID = 4;
    private static final String NAME = "일요일 할인";
    private static final int DISCOUNT_AMOUNT = 500;

    public SundayDiscount() {
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
            System.out.println("\n[ 1. 월요일 ] [ 2. 화요일 ] [ 3. 수요일 ] [ 4. 목요일 ] ");
            System.out.println("[ 5. 금요일 ] [ 6. 토요일 ] [ 7. 일요일 ] \n");
            System.out.print("오늘에 해당하는 요일을 선택해주세요.(숫자만 입력 가능) >>> ");
            int dayResult = sc.nextInt();
            return dayResult == 7;
        } catch (RuntimeException e){
            System.out.println("❗️***잘못된 입력입니다.");
            System.out.println("❗️***선택가능한 숫자만 입력 가능합니다.\n");
            return false;
        }
    }
}
