package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//회원가입 폼
	@RequestMapping(value="/user/joinForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("userController>joinForm");
		
		return "/user/joinForm";
	
	}
	/*
	//아이디 중복검사
	@ResponseBody
	@RequestMapping(value="/user/idCheck", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinCheck(@RequestParam("id") String id) {
		System.out.println("UserController>joinCheck");
		System.out.println(id);
		
		return userService.idCheck(id);
	}
	*/
	//회원가입
	@RequestMapping(value="/user/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("userController>join");
		
		userService.userInsert(userVo);
		
		return"/user/joinSuccess";
	}
	
	//로그인 폼
	@RequestMapping(value="/user/loginForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController>loginForm");
		
		return "/user/loginForm";
	}
	
	//로그인
	@RequestMapping(value="/user/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController>login");
		
		 UserVo authUser = userService.login(userVo);
		 
		 
		 if(authUser != null) { //로그인 성공시
			 
			 //세션에 저장
			 session.setAttribute("authUser", authUser);
			 
			 System.out.println("로그인성공");
			 
			 return "redirect:/main";
		 }else { //로그인 실패시
			 System.out.println("로그인실패");
			 
			 return "redirect:/user/loginForm";
		 }
	}
	
	//로그아웃
	@RequestMapping(value="/user/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("userController>logout");
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/main";
	}
}
