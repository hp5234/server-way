package app.management.discount;
import java.util.LinkedList;

public class DiscountRepository {

    private final Discount[] allDiscountList = new Discount[]{
            new AgeDiscount(),
            new LunchDiscount(),
            new TelecomDiscount(),
            new SundayDiscount()
    };

    private final LinkedList<Discount> discounts = new LinkedList<>();

    public int getDiscountsSize(){
        return discounts.size();
    }

    // 전체조회
    public LinkedList<Discount> getDiscounts() {
        return discounts;
    }

    // 단일 조회
    public Discount findById(int id) {
        for (Discount discount : allDiscountList) {
            if ( id == discount.getId()) {
                return discount;
            }
        }
        return null;
    }

    // 현재 담긴 할인 타입과 신규 할인의 일치 확인
    public boolean isSameType(int id) {
        Discount targetDiscount = findById(id);
        return (targetDiscount instanceof FixedDiscount) == isFixedDiscounts();
    }

    // 현재 담긴 할인 타입 확인
    public boolean isFixedDiscounts(){
        Discount discount = discounts.get(0);
        if (discount instanceof FixedDiscount){
            return true;
        } else {
            return false;
        }
    }

    // 추가
    public boolean addDiscount(int id) {
        for (Discount discount : allDiscountList) {
            if (discount.getId() == id) {
                return discounts.add(discount);
            }
        }
        return false;
    }

    // 중복 검사
    public boolean checkExistDiscount(int id) {
        for (Discount discount : discounts) {
            if (discount.getId() == id)  {
                return false;
            }
        }
        return true;
    }

    // 초기화
    public void clearDiscounts() {
        discounts.clear();
    }

    // 삭제
    public Discount removeDiscount(int index){
        return discounts.remove(index);
    }
}
