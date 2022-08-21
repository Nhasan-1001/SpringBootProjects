package com.example.project_RollBackAuthentication.HotelManagement.Controller;

import com.example.project_RollBackAuthentication.HotelManagement.Model.Customer;
import com.example.project_RollBackAuthentication.HotelManagement.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotelManagement")
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
       this.customerService = customerService;
   }
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer)
    {
        return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Customer> getCustomer()
    {
        return customerService.getCustomer();
    }
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerID(@PathVariable("id") int id)
    {
        return new ResponseEntity<Customer>(customerService.getCustomerID(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id,@RequestBody Customer customer)
    {
        return new ResponseEntity<Customer>(customerService.updateCustomer(customer,id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id)
    {
        customerService.deleteCustomer(id);
        return new ResponseEntity<String>("Customer deleted successfully",HttpStatus.OK);
    }
}
