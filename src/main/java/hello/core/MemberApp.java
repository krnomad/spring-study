package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        // AppConfig class환경 정보를 가지고 Spring caontainer에 객체를 생성하고 관리한다
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        AppConfig appConfig = new AppConfig();
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
//        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "member", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
