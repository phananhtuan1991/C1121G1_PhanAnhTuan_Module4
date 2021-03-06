package com.case_study_module4_furama_by_spring.service.customer_service.impl;

import com.case_study_module4_furama_by_spring.model.customer.Customer;
import com.case_study_module4_furama_by_spring.repository.customer_repo.ICustomerRepository;
import com.case_study_module4_furama_by_spring.service.customer_service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findALlCustomer(String searchWord,Pageable pageable) {
        return customerRepository.findCustomerByCustomerNameContaining(searchWord,pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }
}
