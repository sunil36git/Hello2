package com.test.Hello2.web;

import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.test.Hello2.Service.DataService;


@RestController
@RequestMapping
public class AppController {
	
	ObjectMapper objectMapper = new ObjectMapper();
	private final Logger logger = LogManager.getLogger();
	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	
	@Autowired
	private DataService service;
	
	@RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
	public String sayHi(@PathVariable String name) throws JsonProcessingException, UnknownHostException
	{
		logger.info("Request received for name..." + name);
		logger.info("Response sent for name..." + name);
		return service.getGreeting();

	}
	
}
