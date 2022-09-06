package com.example.EmployeeManagementSystem.Service;
import com.example.EmployeeManagementSystem.Model.Employee;
import com.example.EmployeeManagementSystem.Reposetory.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements EmployeeInterface {
   @Autowired
    EmployeeRepo employeeRepo;
   @Autowired
    PasswordEncoder passwordEncoder;

   @Override
    public Employee getEmployee(String emp_email){
       Employee employee= employeeRepo.findAllByEmail(emp_email);
       return employee;
   }

    @Override
    public void deleteEmployee(String emp_email) {
        Employee employee = employeeRepo.findByEmail(emp_email);
        employeeRepo.deleteById(employee.getId());
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee employee1 = employeeRepo.findById(employee.getId()).orElseThrow();
        employee1.setEmail(employee.getEmail());
        employee1.setEmp_name(employee.getEmp_name());
        employee1.setEmp_salary(employee.getEmp_salary());
        employee1.setEmp_password(passwordEncoder.encode(employee.getEmp_password()));
        employee1.setEmp_role(employee.getEmp_role());
        employee1.setEmp_phone_no(employee.getEmp_phone_no());
        employee1.setOrg_id(employee.getOrg_id());
        employeeRepo.save(employee1);
    }
}
