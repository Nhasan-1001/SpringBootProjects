package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Model.Employee;
import com.example.EmployeeManagementSystem.Service.EmployeeInterface;
import com.example.EmployeeManagementSystem.Service.OrganisationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeInterface employeeInterface;
    @Autowired
    OrganisationInterface organisationInterface;

    @GetMapping(value = "/login/{emp_email}", produces = MediaType.APPLICATION_XML_VALUE)

    public ResponseEntity<Employee>getEmployee(@PathVariable("emp_email")String emp_email){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (emp_email.equals(authentication.getName())) {
                Employee employee = employeeInterface.getEmployee(emp_email);
                return new ResponseEntity<>(employee,HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{email}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("email")String emp_email){
        employeeInterface.deleteEmployee(emp_email);
        return new ResponseEntity<>("Employee details deletion successful!",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>>getAllEmployee() {
        try {
            return new ResponseEntity<>(organisationInterface.getAll(), HttpStatus.OK);
        }
        catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<String>addEmployee(@RequestBody @Valid Employee employee)
    {
        if(! employee.getEmp_salary().contains("-")) {
            if (employee.getOrg_id()!= 0) {
                if (organisationInterface.addEmployee(employee))
                    return new ResponseEntity<>("Employee details creation successful!", HttpStatus.CREATED);
                else
                    return new ResponseEntity<>("Employee is already exist!",HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>("Please enter organisation id", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else
            return new ResponseEntity<>("Salary should be positive",HttpStatus.BAD_REQUEST);
    }
    @PutMapping
    public ResponseEntity<String>updateEmployee(@RequestBody @Valid Employee employee){
        try {
            if(! employee.getEmp_salary().contains("-")) {
                employeeInterface.updateEmployee(employee);
                return new ResponseEntity<>("Employee details Updated successfully!", HttpStatus.ACCEPTED);
            }
            else{
                return new ResponseEntity<>("Salary Should be positive",HttpStatus.BAD_REQUEST);
            }

        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>("Employee ID Not Found!",HttpStatus.NOT_FOUND);
        }
    }
}
