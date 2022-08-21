package com.example.EmployeeManagementSystem.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "assets_table")
public class Assets  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotEmpty(message = "Please provide Asset name")
    @Pattern(message = "Give proper name", regexp = "^[a-zA-Z ]+$")
    private String assets_name;

    @Column
    @NotEmpty(message = "Please provide Asset type")
    @Pattern(message = "Give proper type", regexp = "^[a-zA-Z ]+$")
    private  String assets_type;

    @Column
    @NotNull(message = "Please enter positive value")
    @Min(value = 1,message = "Value should be positive")
    private long assets_value;

    @Column(name = "org_id")
    private int orgid;


}

