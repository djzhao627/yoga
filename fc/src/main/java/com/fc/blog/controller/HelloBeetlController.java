package com.fc.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HelloBeetlController {
	
	private static Logger logger = LoggerFactory.getLogger(HelloBeetlController.class);

	/**
     * 测试beetl模板
     *
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView home(Model model) {
    	 ModelAndView modelAndView = new ModelAndView();
         logger.info("add request");
         modelAndView.addObject("email", "apk2sf@163.com");
         modelAndView.setViewName("add");

         return modelAndView;
    }

}
