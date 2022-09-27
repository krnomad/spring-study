package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    // 모두 interface(역할)만 return하고 내부에 그 역할에 대한 구현만을 표시 하므로 AppConfig만 변경해서 전체 app동작이 바뀌게 된다
    // 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악할 수 있다
    public MemberService memberService() {
        // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderservice() {
        // 생성자 주입
        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
