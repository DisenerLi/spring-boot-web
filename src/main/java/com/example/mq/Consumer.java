package com.example.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by liqiang on 2018/4/10.
 */
@Component
public class Consumer {

	@JmsListener(destination = "sample.queue")
	public void receiveQueue(String text){
		System.out.println(text);
	}
}
