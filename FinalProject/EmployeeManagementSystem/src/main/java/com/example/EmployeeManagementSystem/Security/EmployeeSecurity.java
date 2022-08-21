package com.example.EmployeeManagementSystem.Security;

import com.example.EmployeeManagementSystem.Reposetory.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSecurity implements UserDetailsService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.employeeRepo.findByEmail(username);
  }
}
