package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * Linux/Mac: ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic greet_wrols --from-beginning
 * Windows: .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic hello_world --from-beginning
 */

@Service
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	String kafkaTopic = "hello_world";
	
	public void send(String message) {
		kafkaTemplate.send(kafkaTopic,message);
	}

}
