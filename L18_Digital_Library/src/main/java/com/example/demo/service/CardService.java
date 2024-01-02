package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Card;
import com.example.demo.entity.CardStatus;
import com.example.demo.entity.Student;
import com.example.demo.repositories.CardRepository;

@Service
public class CardService {

	@Autowired
	CardRepository cardRepository;
	
	public Card createCard(Student student) {
		Card c = new Card();
		c.setStudent(student);
		c.setCardStatus(CardStatus.ACTIVATED);
		student.setCard(c);
		cardRepository.save(c);
		return c;
	}
}
