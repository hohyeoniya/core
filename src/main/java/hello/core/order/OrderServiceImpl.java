package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
/* 생성자 주입의 장점
   final 사용으로 불변!
   누락을 막을 수 있다.
   오직 생성자 주입 방식만 'final' 키워드를 사용할 수 있다.
*/
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /* @Autowired > 생성자가 하나일때 생략가능 */
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

    //테스트 용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
