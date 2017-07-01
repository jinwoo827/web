package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemController {
	private Service service;
	
	public void setService(Service service){
		this.service = service;
	}
	
	@RequestMapping(value = "/form.do")
	public String form(){
		return "form";
	}
	
	@RequestMapping(value = "/insert.do")
	public String insert(Member m){
		service.addMember(m);
		return "login";
	}
	
	@RequestMapping(value = "/check.do")
	public ModelAndView check(@RequestParam(value = "id") String id){
		Member m = service.getMember(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("check");
		String str = "";
		if( m == null){
			str = "사용가능한 아이디";
		} else {
			str = "사용 불가능한아이디";
		}
		mav.addObject("str", str);
		return mav;
	}
	
	@RequestMapping(value = "/login.do")
	public ModelAndView login(Member m,HttpSession session,HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String str = service.login(m);
		if(str == null){
			session = req.getSession();
			session.setAttribute("id", m.getId());
			mav.setViewName("login");
		} else {
			mav.setViewName("loginForm");
			mav.addObject("msg", str);
		}
		return mav;
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session,HttpServletRequest req){
		session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "loginForm";
	}
	
	@RequestMapping(value = "/editForm.do")
	public ModelAndView editForm(HttpSession session,HttpServletRequest req){
		session = req.getSession(false);
		String id = (String)session.getAttribute("id");
		Member m = service.getMember(id);
		ModelAndView mav = new ModelAndView("editForm");
		mav.addObject("m",m);
		return mav;
	}
	
	@RequestMapping(value = "/edit.do")
	public String edit(Member m){
		service.editMember(m);
		return "login";
	}
	
	@RequestMapping(value = "/del.do")
	public String del(HttpSession session,HttpServletRequest req){
		session = req.getSession(false);
		String id = (String)session.getAttribute("id");
		service.delMember(id);
		return "redirect:/logout.do";
	}

}
