package app.management;

import app.management.discount.DiscountHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Payment {

    private final Cart cart;
    private final DiscountHandler discountHandler;

    public Payment(Cart cart, DiscountHandler discountHandler) {
        this.cart = cart;
        this.discountHandler = discountHandler;
    }

    // 현재 정보 출력 : 현재금액, 결제 금액
    public void printPaymentState() {
        cart.printAllProduct();
        int totalPrice = cart.getTotalPrice();
        getPaymentPriceState(totalPrice);
    }

    // 할인 전 후 금액 출력
    private void getPaymentPriceState(int totalPrice){
        System.out.println("----------------------------------------");
        System.out.println("할인 전 금액 : " + totalPrice);
        discountHandler.printDiscountState(totalPrice);
        System.out.println("----------------------------------------");
        System.out.println("최종 결제 금액 : " + discountHandler.getDiscountResultTotalPrice(totalPrice) + "\n");
    }

    // 결제
    public void doPay(){
        System.out.println("\n✅ 결제가 완료되었습니다.\n");
        System.out.println("-".repeat(50));
        System.out.println("-".repeat(47) + "영 수 증" + "-".repeat(48));
        System.out.println("결제시간 : " + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        System.out.println("-".repeat(50));
        cart.printAllDetailProduct();
        int totalPrice = cart.getTotalPrice();
        getPaymentPriceState(totalPrice);
        System.out.println("-".repeat(50) + "\n");
    }
}
