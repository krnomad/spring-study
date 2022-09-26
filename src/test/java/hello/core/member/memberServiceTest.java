package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class memberServiceTest {

    MemberService memberService = new MemberServiceImpl();

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
