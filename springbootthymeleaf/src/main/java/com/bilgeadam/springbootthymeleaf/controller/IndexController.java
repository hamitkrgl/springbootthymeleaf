package com.bilgeadam.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@GetMapping(path = { "index.html", "index" })
	public ModelAndView index() {
		ModelAndView indexHTML = new ModelAndView("index");
		return indexHTML;
	}
}
