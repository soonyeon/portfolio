package kr.kh.test2.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test2.service.MemberService;
import kr.kh.test2.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, Integer num) {
		String name = memberService.selectMemberName(num);
		mv.setViewName("/main/home");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(ModelAndView mv) {
		mv.setViewName("/member/signup");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO member) {	
		boolean res = memberService.signup(member);
		if(res) {
			//성공했다고 알림 메세지(추후 구현 예정)
			mv.setViewName("redirect:/");
		}else {
			//실패했다고 알림 메세지(추후 구현 예정)
			mv.setViewName("redirect:/signup");
		}
		
		return mv;
	}
}