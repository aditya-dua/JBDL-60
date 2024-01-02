package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Card;
import com.example.demo.entity.CardStatus;
import com.example.demo.entity.Transaction;
import com.example.demo.entity.TransactionStatus;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.CardRepository;
import com.example.demo.repositories.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CardRepository cardRepository;
	
	public String issueBooks(int cardId,int bookId) throws Exception {
		Book book = bookRepository.findById(bookId).get();
		
		if(book == null || book.isAvailable()!=true) {
			throw new Exception("Either book doesnot exists or is not available.");
		}
		
		Card card = cardRepository.findById(cardId).get();;
		
		if(card == null || card.getCardStatus()== CardStatus.DEACTIVATED) {
			throw new Exception("InValid Card.");
		}
		if(card.getBooks().size()>3) {
			throw new Exception("Book limit reached for the card.");
		}
		
		book.setAvailable(false);
		book.setCard(card);
		List<Book> books= card.getBooks();
		books.add(book);
		card.setBooks(books);
		//bookRepository Call the update logic to update the avilablity status
		
		Transaction transaction = new Transaction();
		transaction.setBook(book);
		transaction.setCard(card);
		transaction.setIssueOperation(true);
		transaction.setTransactionStatus(TransactionStatus.SUCCESSFUL);
		transactionRepository.save(transaction);
		
		return transaction.getTransactionId();
		
	}
	
	
	
	public String returnBooks(int cardId, int bookId) {
		List<Transaction> transactions = transactionRepository.findByCard_Book(cardId, bookId, TransactionStatus.SUCCESSFUL, true);
		
		Transaction last_transaction = transactions.get(transactions.size()-1);
		
		Date issue_date = last_transaction.getCreatedOn();
		Long issueTime = Math.abs(issue_date.getTime()-System.currentTimeMillis());
		long numberOfDays = TimeUnit.DAYS.convert(issueTime,TimeUnit.MILLISECONDS);
		int fine = 0;
		
		if(numberOfDays > 5 ) {
			fine = (int) Math.abs(numberOfDays-5)*10;
			
		}
		
		Card card = last_transaction.getCard();
		Book book = last_transaction.getBook();
		book.setCard(null);
		book.setAvailable(true);
		
		//bookRepository.update  Update logic to free up the book
		
		Transaction return_trans= new Transaction();
		return_trans.setBook(book);
		return_trans.setCard(card);
		return_trans.setFineAmount(fine);
		return_trans.setIssueOperation(false);
		return_trans.setTransactionStatus(TransactionStatus.SUCCESSFUL);
		transactionRepository.save(return_trans);
		return return_trans.getTransactionId();
		
	}

}
