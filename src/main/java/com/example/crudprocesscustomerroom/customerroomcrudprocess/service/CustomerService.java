package com.example.crudprocesscustomerroom.customerroomcrudprocess.service;

import com.example.crudprocesscustomerroom.customerroomcrudprocess.domain.Customer;
import com.example.crudprocesscustomerroom.customerroomcrudprocess.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created on December, 2017
 *
 * @author adilcan
 */
@Slf4j
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public void create(Customer customer) {
		if(customer.getRoom().getCustomers().size() >= customer.getRoom().getCapacity()){
			log.warn("Room with {} ID is full of capacity", customer.getRoom().getId());
		}
		else{
			customer.setCreationDate(new Date());
		}
		customerRepository.save(customer);
	}
}
