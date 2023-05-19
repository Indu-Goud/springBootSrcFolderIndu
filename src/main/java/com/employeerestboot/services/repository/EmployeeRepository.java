package com.employeerestboot.services.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.employeerestboot.services.model.Employee;
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
