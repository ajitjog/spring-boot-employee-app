package com.learnwithamit.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwithamit.employeeapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}