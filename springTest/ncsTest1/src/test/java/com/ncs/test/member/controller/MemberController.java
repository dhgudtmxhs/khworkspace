package com.ncs.test.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import
org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@Controller 
@SessionAttributes("loginMember")
public class MemberController {

	@Autowired
	private MemberService memservice;
	
	@PostMapping(value = "login")
	public String memberLogin(@ModelAttribute Member member,
							  				  Model model,
							  				  RedirectAttributes ra) {
		
		Member loginMember = memservice.memberLogin(member);

		if(loginMember != null) {
			
			model.addAttribute("loginMember", loginMember);
	
			ra.addFlashAttribute("message", loginMember.getMemberId() + "님 환영합니다." );
			
		}else {
			
			ra.addFlashAttribute("message", "로그인 실패" );
			
		}
		
		return "redirect:/";
	}
	
}

