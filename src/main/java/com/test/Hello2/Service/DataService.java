package com.test.Hello2.Service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class DataService {

	@Value("${HELLO_MSG}")
	String hello_msg;

	private final Logger logger = LogManager.getLogger();

	RestTemplate restTemplate = new RestTemplate();


	/**
	 * To reply with greeting MSG.
	 * 
	 * @param msg
	 *            A variable of type String.
	 * @return String
	 */
	public String getGreeting() {
		logger.info("Sending greeting from Service.getGreeting method.");
		return hello_msg;
	}

}
