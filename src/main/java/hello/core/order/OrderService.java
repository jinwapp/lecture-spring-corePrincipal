// OrderService.java
// 1. 클라이언트로부터 회원id, 상품명, 상품가격을 받아서
// 2. 주문 결과를 반환한다.

package hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
