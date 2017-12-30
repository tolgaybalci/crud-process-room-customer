package com.example.crudprocesscustomerroom.customerroomcrudprocess.repository;

import com.example.crudprocesscustomerroom.customerroomcrudprocess.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
