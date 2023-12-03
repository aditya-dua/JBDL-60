package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	@Autowired
	KafkaSender kafkaSender;
	
	
	@GetMapping(value="/kafka")
	public String producer(@RequestParam String message) {
		kafkaSender.send(message);
		return "Message send to kafka topic: "+kafkaSender.kafkaTopic+" message:"+message;
	}
}
