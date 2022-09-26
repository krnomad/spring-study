package hello.core.order

import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemberService
import hello.core.member.MemberServiceImpl
import org.junit.jupiter.api.Test

class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl()
    OrderService orderService = new OrderServiceImpl()

    @Test
    void createOrder() {
        Long memberId = 1L
        def member = new Member(memberId, "memberA", Grade.VIP)
        memberService.join(member)

        Order order = orderService.createOrder(memberId, "itemA", 10000)
        assert order.getDiscountPrice() == 1000
    }
}