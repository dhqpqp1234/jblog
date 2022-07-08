package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;


@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	//블로그 메인
	@RequestMapping(value="/blog/{id}", method= {RequestMethod.POST,RequestMethod.GET})
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
		
	//내블로그 관리
	@RequestMapping(value="/blog/{id}/admin/basic", method= {RequestMethod.GET,RequestMethod.POST})
	public String management(@PathVariable String id) {
		System.out.println("blogController>management");
		
		return "blog/admin/blog-admin-basic";
	}
	
	//회원정보가져오기
	@RequestMapping(value="/blog/getUser", method= {RequestMethod.GET,RequestMethod.POST})
	public String getUser(@RequestParam("id") String id, Model model ) {
		System.out.println("blogController>getUser");
		
		BlogVo bVo = blogService.getUser(id);
		
		model.addAttribute("bVo",bVo);
		
		System.out.println(bVo);
		
		return "";
	}
}
