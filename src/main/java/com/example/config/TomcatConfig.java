package com.example.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liqiang on 2018/4/9.
 */
@Configuration
public class TomcatConfig {

	@Bean
	public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
		ConfigurableEmbeddedServletContainer factory = new TomcatEmbeddedServletContainerFactory();
		//factory.setDocumentRoot(new File("D:\\workspace\\spring-boot-web\\src\\main\\resources"));
		return (EmbeddedServletContainerFactory) factory;
	}
}
