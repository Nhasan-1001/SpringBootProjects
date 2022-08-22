package com.example.EmployeeManagementSystem.Model;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Table(name = "employee_table")
public class Employee implements UserDetails {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotEmpty(message = "Employee name should not be empty")
    @Pattern(message="Give proper name", regexp = "^[a-zA-Z ]+$")
    private String emp_name;
    @Column(name="emp_email")
    @Email(message = "Email is not valid", regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @Column
    @NotEmpty(message = "Phone number should not be empty")
    @Pattern(message="Phone number is not valid", regexp = "^[0-9]{10}$")
    private String emp_phone_no;
    @Column
    @NotEmpty(message = "Role should not be empty")
    private String emp_role;

    @Column
    @NotEmpty(message = "Please enter positive value")
    private String emp_salary;

    @Column
    @NotEmpty(message = "Give a password")
    private String emp_password;

    @Column
    @NotNull
    private int org_id;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(emp_role));
    }

    @Override
    public String getPassword() {
        return this.emp_password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
