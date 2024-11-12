package hello.core.member;

public interface MemberService {

    void join(Member memver);

    Member findMember(Long memberId);
}
