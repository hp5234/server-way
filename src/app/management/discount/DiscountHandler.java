package app.management.discount;

import java.util.LinkedList;

public class DiscountHandler {

    private final DiscountRepository discountRepository;

    public DiscountHandler(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    // 등록된 할인 갯수 확인
    public int getDiscountSize(){
        return discountRepository.getDiscountsSize();
    }

    // 현재 할인, 할인금액 출력
    public void printDiscountState(int price){
        if (discountRepository.getDiscountsSize() != 0) {
            LinkedList<Discount> discounts = discountRepository.getDiscounts();
            if (discountRepository.isFixedDiscounts()){
                // 할인 이름 // 할인 양 // 할인 가격
                for (Discount discount : discounts) {
                    FixedDiscount currentDiscount = (FixedDiscount) discount;
                    System.out.printf("[%s] [ %d 원 할인] : -%d원\n", currentDiscount.getName(), currentDiscount.getDiscountAmount(), currentDiscount.getDiscountAmount());
                }
            } else {
                for (Discount discount : discounts) {
                    RateDiscount currentDiscount = (RateDiscount) discount;
                    System.out.printf("[%s] [ %d %% 할인] : -%d원\n", currentDiscount.getName(), currentDiscount.getDiscountAmount(), currentDiscount.getDiscountPrice(price));
                }
            }
        } else {
            System.out.println("할인 없음\n");
        }
    }

    // 할인 목록 출력
    public void printDiscountList(){
        if (discountRepository.getDiscountsSize() != 0) {
            LinkedList<Discount> discounts = discountRepository.getDiscounts();
            if (discountRepository.isFixedDiscounts()) {
                FixedDiscount[] fixedDiscounts = discounts.toArray(FixedDiscount[]::new);
                for (int index = 0; index < discounts.size(); index++) {
                    System.out.printf("(%3d) %s [할인율 : %d원]\n", index + 1, fixedDiscounts[index].getName(), fixedDiscounts[index].getDiscountAmount());
                }
            } else {
                RateDiscount discount = (RateDiscount) discounts.get(0);
                System.out.printf("(%3d) %s [할인율 : %d%%]\n", 1, discount.getName(), discount.getDiscountAmount());
            }
        } else {
            System.out.println("현재 선택된 할인이 없습니다.\n");
        }
    }

    // 최종 결제 금액
    public int getDiscountResultTotalPrice(int totalPrice){
        if (discountRepository.getDiscountsSize() != 0) {
            LinkedList<Discount> discounts = discountRepository.getDiscounts();
            if (discountRepository.isFixedDiscounts()) {
                FixedDiscount[] fixedDiscounts = discounts.toArray(FixedDiscount[]::new);
                for (FixedDiscount fixedDiscount : fixedDiscounts) {
                    totalPrice -= fixedDiscount.discount(totalPrice);
                }
            } else {
                RateDiscount currentDiscount = (RateDiscount) discounts.get(0);
                totalPrice = currentDiscount.discount(totalPrice);
            }
        }
        return totalPrice;
    }

    // 할인 조건검사
    public boolean checkConditionById(int id){
        Discount discount = discountRepository.findById(id);
        if (discount != null) {
            return discount.checkCondition();
        }
        return false;
    }

    // 추가 전 기존 할인 비교 검사
    public boolean addDiscountProcess(int id) {
        // 길이 검사
        if (discountRepository.getDiscountsSize() != 0) {
            // 중복 검사
            if (discountRepository.checkExistDiscount(id)) {
                // 타입 일치 확인
                if (discountRepository.isSameType(id)) {
                    // 중복 가능타입 확인
                    if (discountRepository.isFixedDiscounts()) {
                        return addDiscount(id, false);
                    } else {
                        return addDiscount(id, true);
                    }
                } else {
                    return addDiscount(id, true);
                }
            } else {
                System.out.println("이미 추가된 할인 입니다.");
                return false;
            }
        } else {
            return addDiscount(id, false);
        }
    }

    // 추가 조건 검사 및 추가
    private boolean addDiscount(int id, boolean clearFirst){
        if (checkConditionById(id)) {
            if (clearFirst) {
                discountRepository.clearDiscounts();
            }
            if (discountRepository.addDiscount(id)){
                System.out.println("✅ 할인이 추가되었습니다.\n");
                return true;
            } else {
                System.out.println("❗️할인 추가에 실패하였습니다.\n");
                return false;
            }
        } else {
            System.out.println("❗️할인 대상이 아닙니다.\n");
            return false;
        }
    }

    // 삭제
    public boolean removeDiscount(int listNum) {
        int index = listNum - 1;
        Discount discount = discountRepository.removeDiscount(index);
        if (discount != null) {
            System.out.printf("[ %d. %s 를 할인 목록에서 삭제하였습니다.]\n", listNum, discount.getName());
            return true;
        } else {
            System.out.println("❗할인 삭제 대상을 찾을 수 없습니다.");
            System.out.println("❗️다시 시도해주세요.\n");
            return false;
        }
    }

    // 전체삭제
    public void clearDiscount(){
        discountRepository.clearDiscounts();
    }
}
