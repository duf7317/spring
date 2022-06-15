package com.spring.spring.Controller;

import com.spring.spring.domain.Member;
import com.spring.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.desktop.SystemSleepEvent;
import java.util.List;

@Controller
public class MemberController {
//필드 주입
//    @Autowired private final MemberService memberService;



    //    생성사주입 권장
        @Autowired // DI
    private final MemberService memberService;
    public MemberController(MemberService memberService) {
            this.memberService = memberService;
    }


    //    setter주입
//    private MemberService memberService;
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;

    @GetMapping("/members/new")
    public String CreateForm(){
        return "members/createMembersForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String memberview(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}


