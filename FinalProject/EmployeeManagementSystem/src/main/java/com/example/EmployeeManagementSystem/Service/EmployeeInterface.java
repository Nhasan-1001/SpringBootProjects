package com.example.EmployeeManagementSystem.Service;
import com.example.EmployeeManagementSystem.Model.Employee;


public interface EmployeeInterface {
    public Employee getEmployee(String emp_email);

    void deleteEmployee(String emp_email);

    void updateEmployee(Employee employee);
}
