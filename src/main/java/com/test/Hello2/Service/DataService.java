package com.test.Hello2.Service;


import java.net.InetAddress;
import java.net.UnknownHostException;

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
	 * @throws UnknownHostException 
	 */
	public String getGreeting() throws UnknownHostException {
		logger.info("Sending greeting from Service.getGreeting method.");
		return "("+hello_msg+ "< IP : "+InetAddress.getLocalHost()+ " >";
	}

}
