package com.example.EmployeeManagementSystem.Reposetory;

import com.example.EmployeeManagementSystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository <Employee,Integer> {
    Employee findAllByEmail(String emp_email);

    Employee findByEmail(String emp_email);
    @Query(nativeQuery = true,value = "SELECT * FROM `employee_table` WHERE org_id=:emp_id")
    List<Employee>  deleteData(@Param(value = "emp_id") int id);
}
