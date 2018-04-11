package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liqiang on 2018/4/9.
 */
@RestController
public class HelloSpringController {

	private Logger logger = LoggerFactory.getLogger(HelloSpringController.class);

	@GetMapping("/helloworld")
	@ResponseBody
	public String hello(String name) {
		logger.info("user name:"+name);
		return "hello "+name+"! welcome to spring boot!";
	}
}
