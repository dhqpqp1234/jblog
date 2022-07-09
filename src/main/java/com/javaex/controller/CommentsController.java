package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.javaex.dao.CommentsDao;

@Controller
public class CommentsController {
	
	@Autowired
	private CommentsDao comDao;
	
}
