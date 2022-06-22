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

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository()

    // call AppConfig.memberService
    // call AppConfig.memberRepository()
    // call AppConfig.orderService

    @Bean
    public MemberService memberService() { //역할
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());//구현
    }

    @Bean
    public MemberRepository memberRepository() {//역할
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();//구현
    }

    @Bean
    public OrderService orderService() {//역할
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());//구현
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
