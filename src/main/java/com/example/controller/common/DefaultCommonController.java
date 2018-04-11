package com.example.controller.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by liqiang on 2018/4/9.
 */
@Controller
public class DefaultCommonController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@RequestMapping("/")
	public ModelAndView defaultView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("time",new Date());
		modelAndView.addObject("message",this.message);
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleMyRuntimeException(Exception exception) {
		return exception+"Some data I want to send back to the client.";
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@RequestMapping("/**")
	public @ResponseBody String notFound(Exception exception) {
		System.out.println(exception);
		return "not found,haha";
	}
}
