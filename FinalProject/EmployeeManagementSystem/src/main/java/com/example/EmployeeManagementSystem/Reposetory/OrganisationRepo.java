package com.example.EmployeeManagementSystem.Reposetory;

import com.example.EmployeeManagementSystem.Model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepo  extends JpaRepository<Organisation,Integer> {

}
