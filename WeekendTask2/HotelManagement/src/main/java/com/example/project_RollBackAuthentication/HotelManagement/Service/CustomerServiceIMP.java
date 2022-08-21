package com.example.project_RollBackAuthentication.HotelManagement.Service;

import com.example.project_RollBackAuthentication.HotelManagement.Model.Customer;
import com.example.project_RollBackAuthentication.HotelManagement.Repository.CustomerRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIMP implements CustomerService{
    private CustomerRepository customerRepository;
    public CustomerServiceIMP(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerID(int id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @Override
    public Customer updateCustomer(Customer customer, int id) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow();
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        customerRepository.save(existingCustomer);
        return existingCustomer;
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.findById(id).orElseThrow();
        customerRepository.deleteById(id);
    }
}
