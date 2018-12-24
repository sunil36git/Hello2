package com.test.Hello1;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.test.Hello1.domain.ErrorMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ControllerAdvice
public class ExceptionHandlerclass extends ResponseEntityExceptionHandler {
	private final Logger logger = LogManager.getLogger();

	@Autowired
	private ErrorMessage response;

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> catchAllExceptions(HttpServletRequest req, Exception Ex) {
		StringWriter sw = new StringWriter();
		if (!(Ex.getMessage().contains("500 null"))) {
			response = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), Ex.getMessage());
			logger.error("Error Occured - " + Ex.getMessage());
			Ex.printStackTrace(new PrintWriter(sw));
			logger.error(sw.toString());

		} else {
			response = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal error occurred");
			logger.error("Internal Error occurred ");
			Ex.printStackTrace(new PrintWriter(sw));
			logger.error(sw.toString());
		}

		return new ResponseEntity<ErrorMessage>(response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
