//OrderServiceImpl.java

// 1. 클라이언트로부터 회원id, 상품명, 상품가격을 받아서
// 2. 주문 결과를 반환한다.

package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

//  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
// Fix -> Rate로 변경되면 OrderServiceimpl의 소스코드가 변경되므로 DIP, OCP 위반이다.
// OCP : 소스의 변경 없이 기능을 확장
// DIP : 추상화에만 의존하고 구체화는 의존하면 안된다. BUT 현재 OrderServiceImpl 은 DiscountPolicy(인터페이스)와 RateDiscountPolicy(구현체)에도 의존하고 있다.
