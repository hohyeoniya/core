package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;    // DI, 의존관계 주입 또는 의존성 주입 : 의존관계를 외부에서 주입해주는 것

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member memver) {
        memberRepository.save(memver);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
