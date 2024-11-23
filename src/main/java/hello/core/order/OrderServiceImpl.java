package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
/* 생성자 주입
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("1. OrderServiceImpl.OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
*/
/* 수정자 주입(setter 주입)
    @Autowired(required = false): 주입할 대상이 없어도 동작하게 하려면 required 로 지정하면 된다.
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }
*/
/* 필드 주입 => 애플리케이션의 실제 코드와 관계없는 테스트 코드에서만 사용하자.
   @Autowired private  MemberRepository memberRepository;
   @Autowired private  DiscountPolicy discountPolicy;
*/
/* 일반 메서드 주입
@Autowired
public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
}
*/
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

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
