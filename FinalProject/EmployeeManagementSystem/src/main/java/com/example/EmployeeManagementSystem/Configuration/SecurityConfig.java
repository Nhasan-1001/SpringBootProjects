package com.example.EmployeeManagementSystem.Configuration;

import com.example.EmployeeManagementSystem.Security.EmployeeSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String ADMIN = "admin";
    private static final String MANAGER = "manager";
    private static final String EMPLOYEE = "employee";

    @Autowired
    private EmployeeSecurity employeeSecurity;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/employee/**").hasAnyAuthority(ADMIN,MANAGER)
                .antMatchers(HttpMethod.PUT,"/api/employee/**").hasAnyAuthority(ADMIN,MANAGER)
                .antMatchers(HttpMethod.DELETE,"/api/employee/**").hasAnyAuthority(ADMIN)
                .antMatchers(HttpMethod.GET,"/api/employee/login/**").hasAnyAuthority(EMPLOYEE)
                .antMatchers(HttpMethod.GET,"/api/employee/**").hasAnyAuthority(ADMIN,MANAGER)
                .antMatchers(HttpMethod.POST,"/api/assets/**").hasAnyAuthority(ADMIN,MANAGER)
                .antMatchers(HttpMethod.PUT,"/api/assets/**").hasAnyAuthority(ADMIN,MANAGER)
                .antMatchers(HttpMethod.DELETE,"/api/assets/**").hasAnyAuthority(ADMIN)
                .antMatchers(HttpMethod.GET,"/api/assets/**").hasAnyAuthority(ADMIN,MANAGER,EMPLOYEE)

                .antMatchers(HttpMethod.POST,"/api/organisation/**").hasAnyAuthority(ADMIN)
                .antMatchers(HttpMethod.PUT,"/api/organisation/**").hasAnyAuthority(ADMIN)
                .antMatchers(HttpMethod.DELETE,"/api/organisation/**").hasAnyAuthority(ADMIN)
                .antMatchers(HttpMethod.GET,"/api/organisation/**").hasAnyAuthority(ADMIN,MANAGER,EMPLOYEE)

                .anyRequest().authenticated()
                .and().httpBasic();
        http.csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employeeSecurity).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
