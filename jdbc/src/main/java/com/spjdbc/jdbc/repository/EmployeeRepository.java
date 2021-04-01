package com.spjdbc.jdbc.repository;

import com.spjdbc.jdbc.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    List<Employee> getEmployeeList();

    String insertData(Employee employee);

    Employee getEmployee(Integer id);

    String updateEmployee(Employee employee);

    String deleteEmployee(Integer id);

    List<Map<String,Object>> getCombineData();
}
