package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountpolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    /* 각각 다른 2개의 MemoryMemberRepository 가 생성 되면서 싱글톤이 깨지는 것 처럼 보인다.? -> No!
     * @Bean 이 붙은 메서드마다 이미 스피링 빈이 존재하면 존재하는 빈을 반환하고,
     * 스피링 빈이 없으면 생성해서 스피링 빈으로 등록하고 반환하는 코드가 동적으로 만들어 진다.
     * 따라서 싱글톤이 보장된다.
     * 여기서! @Configuration 이 없으면 memberRepository()처럼 의존관계 주입이 필요해서 메서드를 직접 호출할 때
     * 싱글톤을 보장하지 않는다. => 그러니 스프링 설정 정보는 항상 @Configuration 을 사용하자
    */
    @Bean

    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
//        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountpolicy();
    }

}
