package com.mailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mailsender.bean.UserData;
import com.mailsender.publisher.Publisher;

@RestController
public class PdfController {

	@Autowired
	Publisher publisher;

	@RequestMapping(value = "/generatePDF", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.OK)	
	public String generatePDF(@RequestBody UserData data) 
	{
		publisher.produceMsg(data);
		return "Successfully Message Sent to queue!";
	}
}