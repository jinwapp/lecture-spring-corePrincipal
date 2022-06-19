package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // AppConfig 를 설정정보로 사용한다.
public class AppConfig {

    @Bean
    public MemberService memberService() { //역할
        return new MemberServiceImpl(memberRepository());//구현
    }

    @Bean
    public MemberRepository memberRepository() {//역할
        return new MemoryMemberRepository();//구현
    }

    @Bean
    public OrderService orderService() {//역할
        return new OrderServiceImpl(memberRepository(),discountPolicy());//구현
    }

    @Bean
    public DiscountPolicy discountPolicy(){//역할
//      return new FixDiscountPolicy();//구현
        return new RateDiscountPolicy();//구현
    }
}
