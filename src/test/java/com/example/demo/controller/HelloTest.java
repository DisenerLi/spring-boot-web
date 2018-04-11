package com.example.demo.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Base64;


import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by liqiang on 2018/4/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class HelloTest {

	@Autowired
	MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		ResultActions resultActions = mvc.perform(get("/helloworld").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("hello,spring boot!")));
		System.out.println(resultActions.andReturn().getResponse().toString());
	}

	private static final Logger logger = LogManager
			.getLogger(HelloTest.class);

	@Rule
	public OutputCapture output = new OutputCapture();

	@Test
	public void testLogger() {
		logger.info("Hello World");
		this.output.expect(containsString("Hello World"));
	}

	@Test
	public void validateLoggersEndpoint() throws Exception {
		this.mvc.perform(
				get("/actuator/loggers/org.apache.coyote.http11.Http11NioProtocol")
						.header("Authorization", "Basic " + getBasicAuth()))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"configuredLevel\":\"WARN\","
						+ "\"effectiveLevel\":\"WARN\"}")));
	}

	private String getBasicAuth() {
		return new String(Base64.getEncoder().encode(("user:password").getBytes()));
	}
}
