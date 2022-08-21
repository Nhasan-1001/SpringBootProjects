package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Model.Employee;
import com.example.EmployeeManagementSystem.Model.Organisation;

import java.util.List;

public interface OrganisationInterface  {
    public boolean addEmployee(Employee employee);
    public void deleteEmployee(String emp_email);
    public List<Employee>getAll();
    public void updateEmployee(Employee employee);

    // Organisation Interface ---->
    void addOrganisation(Organisation org);
    void deleteOrganisation(int id);
    List<Organisation> getAllOrganisation();
    void updateOrganisation(int id,Organisation organisation);
}
