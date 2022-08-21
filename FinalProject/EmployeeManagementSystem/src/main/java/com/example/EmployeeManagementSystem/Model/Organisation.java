package com.example.EmployeeManagementSystem.Model;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Data
@Entity
@Table(name="organisation_table")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="org_name")
    @NotEmpty(message = "Please provide Organisation name")
    @Pattern(message = "Give proper name", regexp = "^[a-zA-Z ]+$")
    private String orgname;

}

