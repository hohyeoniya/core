package hello.core;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

import java.security.PublicKey;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl();
    }


}
