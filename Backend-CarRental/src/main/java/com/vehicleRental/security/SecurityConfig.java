package com.vehicleRental.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("test").password("{noop}test").roles("USER").and()
                .withUser("root").password("{noop}root").roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("**/car/addCar").hasRole("ADMIN")
                .antMatchers("**/car/readCar").hasRole("ADMIN")
                .antMatchers("**/car/updateCar").hasRole("ADMIN")
                .antMatchers("**/car/deleteCar").hasRole("ADMIN")
                .antMatchers("**/car/findAll").hasRole("ADMIN")
                .antMatchers("**/car/carCategory").hasRole("ADMIN")
                .antMatchers("**/car/carAvailable").hasRole("ADMIN")
                .antMatchers("**/customer/addCustomer").hasRole("ADMIN")
                .antMatchers("**/customer/findCustomerByID").hasRole("ADMIN")
                .antMatchers("**/customer/updateCustomer").hasRole("ADMIN")
                .antMatchers("**/customer/deleteCustomer").hasRole("ADMIN")
                .antMatchers("**/customer/findAll").hasRole("ADMIN")
                .antMatchers("**/customer/findByEmail").hasRole("ADMIN")
                .antMatchers("**/rent/rentCar").hasRole("ADMIN")
                .antMatchers("**/rent/customer").hasRole("ADMIN")
                .antMatchers("**/rent/updateRent").hasRole("ADMIN")
                .antMatchers("**/rent/deleteRent").hasRole("ADMIN")
                .antMatchers("**/rent/findAll").hasRole("ADMIN")
                .anyRequest()
                .fullyAuthenticated()
                .and().httpBasic();
        httpSecurity.csrf().disable();
    }
}

