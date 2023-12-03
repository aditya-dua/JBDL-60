package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Service
public class KafkaListener {

	private String topicName = "hello_world";
	
	@org.springframework.kafka.annotation.KafkaListener(topics="hello_world", groupId="group_id")
	public void consume(ConsumerRecord<String, String> payload) {
		System.out.println("Topic Name:"+payload.topic());
		System.out.println("Key Name:"+payload.key());
		System.out.println("Value:"+payload.value());
		System.out.println("Payload"+payload.toString());
	}
	
}
