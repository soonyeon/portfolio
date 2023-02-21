package kr.kh.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView mv,String name, Integer age) {
		System.out.println(name);
		mv.addObject("name1",name); //왼쪽name1은 회면에서 불릴 이름, 오른쪽은 보낼 테이터명
		mv.addObject("age",age);
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping(value = "/board/{num}") //게시글을 중괄호를 이용하여 경로로 넘김
	public ModelAndView board(ModelAndView mv,@PathVariable("num")Integer num1) {
		System.out.println("게시글 번호 : " + num1);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/test")
	public ModelAndView test(ModelAndView mv, InfoVO info) {
		mv.addObject("info1", info);
		mv.setViewName("home2");
		return mv;
	}
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		mv.addObject("login");
		return mv;
	}
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, String id, String pw) {
		System.out.println(id);
		System.out.println(pw);
		mv.addObject("login");
		return mv;
	}
	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String home2(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	
}





















