package com.example.demo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Customer;
import com.example.demo.model.CreateCustomerRequestModel;
import com.example.demo.model.CreateCustomerResponseModel;
import com.example.demo.model.GetCustomerResponseModel;

@Service
public class CustomerService {

	Configuration cfg;
	SessionFactory sessionFactory;

	public CustomerService() {
		// TODO Auto-generated constructor stub
		cfg = new Configuration();
		sessionFactory = cfg.configure("hbm.cfg.xml").buildSessionFactory();

	}

	public CreateCustomerResponseModel createCustomer(CreateCustomerRequestModel customer) {

		Session session = sessionFactory.openSession();
		CreateCustomerResponseModel response;
		Transaction tx;

		if (customer.getName() == null || customer.getName().equals("null") || customer.getName().equals("")) {
			response = new CreateCustomerResponseModel(301, "Name cannot be null.");
			return response;
		}
		try {
			tx = session.beginTransaction();

			Customer c = new Customer();
			c.setName(customer.getName());
			c.setAddress(customer.getAddress());
			c.setEmail(customer.getUsername() + "@" + customer.getDomain());
			session.save(c);
			session.flush();
			tx.commit();

			response = new CreateCustomerResponseModel(c.getId(), c.getName(), c.getEmail(), 200, "Success!");

		} catch (Exception e) {
			response = new CreateCustomerResponseModel(300, "Error while Saving Customer" + e);

		}

		return response;

	}

	public GetCustomerResponseModel getEmployeeById(int id) {
		
		Session session = sessionFactory.openSession();
		GetCustomerResponseModel response;
		Transaction tx;
		if (id <= 0 ) {
			response = new GetCustomerResponseModel(301, "Id must a a number.");
			return response;
		}
		
		Customer c= session.get(Customer.class, id);
		response = new GetCustomerResponseModel(c.getId(), c.getName(), c.getEmail(), 200, "Success");
		
		return response;
		
	}

}
