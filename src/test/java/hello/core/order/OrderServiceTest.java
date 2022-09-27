package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        memberService = appConfig.memberService();
        orderService = appConfig.orderservice();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        assert order.getDiscountPrice() == 1000;
    }
}
