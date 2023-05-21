//FixDiscountPolicy.java
// 할인 금액 1000원 리턴한다.

package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{
    // 진행중
    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade()== Grade.VIP){
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
