package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BlogController {
	
	@Autowired
	
	//블로그 메인
	@RequestMapping(value="/blog/main", method= {RequestMethod.POST,RequestMethod.GET})
	public String blogMain() {
		System.out.println("blogController>blogMain");
		
		return "blog/blog-main";
	}
		
		//블로그 로그아웃
		@RequestMapping(value="/blog/logout", method= {RequestMethod.GET, RequestMethod.POST})
		public String logout(HttpSession session) {
			System.out.println("blogController>logout");
			
			session.removeAttribute("authUser");
			session.invalidate();
			
			return "redirect:/blog/main";
		}
}
