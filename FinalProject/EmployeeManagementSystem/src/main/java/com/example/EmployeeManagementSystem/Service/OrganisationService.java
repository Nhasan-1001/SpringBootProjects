package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Model.Employee;
import com.example.EmployeeManagementSystem.Model.Organisation;
import com.example.EmployeeManagementSystem.Reposetory.EmployeeRepo;
import com.example.EmployeeManagementSystem.Reposetory.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OrganisationService implements OrganisationInterface {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    OrganisationRepo organisationRepo;

    //
    @Override
    public boolean addEmployee(Employee employee) {
        List<Employee>emp=employeeRepo.findAll();
        boolean isFound=false;
        for (Employee employee1:emp)
        {
            if (employee.getEmail().equals(employee1.getEmail())){
                isFound=true;
                break;
            }
        }

        if (isFound)
        {
            return false;
        }
        else {
            employee.setEmp_password(passwordEncoder.encode(employee.getEmp_password()));
            employeeRepo.save(employee);
            return true;
        }
    }
    @Override
    public void deleteEmployee(String emp_email) {
        Employee employee=employeeRepo.findByEmail(emp_email);
       employeeRepo.deleteById(employee.getId());
    }
    @Override
    public List<Employee> getAll() {
        List<Employee>emp= employeeRepo.findAll();
        for (Employee employee:emp)

        {
            employee.setEmp_password("*****Confidential*****");
            employee.setEmp_salary("*****Confidential*****");
        }
        return emp;
    }

    @Override
    public void updateEmployee(Employee employee)
    {
        Employee e1 = employeeRepo.findById(employee.getId()).orElseThrow();
        e1.setEmp_role(employee.getEmp_role());
        e1.setEmp_name(employee.getEmp_name());
        e1.setEmp_phone_no(employee.getEmp_phone_no());
        e1.setEmp_password(passwordEncoder.encode(employee.getEmp_password()));
        e1.setOrg_id(employee.getOrg_id());
        e1.setEmp_salary(employee.getEmp_salary());
        e1.setEmail(employee.getEmail());
        employeeRepo.save(e1);
    }


    //Organisation Service starts --->

    @Override
    public void addOrganisation(Organisation org) {
        organisationRepo.save(org);
    }

    @Override
    public void deleteOrganisation(int org) {
        organisationRepo.deleteById(org);
    }

    @Override
    public List<Organisation>getAllOrganisation() {
        return organisationRepo.findAll();
    }

    @Override
    public void updateOrganisation(int id, Organisation organisation) {
        Organisation organisation1=organisationRepo.findById(id).orElseThrow();
        organisation1.setOrgname(organisation.getOrgname());
        organisationRepo.save(organisation1);
    }

}
