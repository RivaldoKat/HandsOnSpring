package com.example.crudRestDemo.dao;

import com.example.crudRestDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // add a method to sort by last name
    List<Employee> findAllByOrderByLastNameAsc();

}
