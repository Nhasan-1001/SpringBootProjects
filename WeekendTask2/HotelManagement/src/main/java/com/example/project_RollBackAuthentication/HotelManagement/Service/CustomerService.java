package com.example.project_RollBackAuthentication.HotelManagement.Service;

import com.example.project_RollBackAuthentication.HotelManagement.Model.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer>getCustomer();
    Customer getCustomerID(int id);
    Customer updateCustomer(Customer customer, int id);
    void deleteCustomer(int id);
}