package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class memberServiceTest {
    AppConfig appConfig;
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given : ~게 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);
        // when : ~게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : ~된다
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
