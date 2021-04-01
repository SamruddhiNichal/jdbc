package com.spjdbc.jdbc.controller;

import com.spjdbc.jdbc.dao.EmployeeDao;
import com.spjdbc.jdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getemployees")
    public List<Employee> getEmp(){
        return employeeDao.getEmployeeList();
    }


    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeDao.insertData(employee);
    }

    @GetMapping("/getEmp/{id}")
    public Employee getEmp(@PathVariable Integer id){
        return employeeDao.getEmployee(id);
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
        return employeeDao.updateEmployee(employee);
    }

    @PostMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        return employeeDao.deleteEmployee(id);
    }

    @GetMapping("/joinData")
    public List<Map<String,Object>> getJoinData(){
        return employeeDao.getCombineData();
    }
}
