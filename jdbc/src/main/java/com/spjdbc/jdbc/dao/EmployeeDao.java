package com.spjdbc.jdbc.dao;

import com.spjdbc.jdbc.model.Employee;
import com.spjdbc.jdbc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getEmployeeList() {
        String sql ="select * from employee";
        List<Employee> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Employee.class));
        return list;
    }

    @Override
    public String insertData(Employee employee) {
        String sql = "insert into employee values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{employee.getId(),employee.getName(),employee.getCity()});
        return "Employee added";
    }

    @Override
    public Employee getEmployee(Integer id) {
        String sql = "select * from employee where id =?";
        Employee emp = jdbcTemplate.queryForObject(sql,new Object[]{id},new int[]{Types.INTEGER},
                new BeanPropertyRowMapper<>(Employee.class));
        return emp;
    }

    @Override
    public String updateEmployee(Employee employee) {
        String sql = "update employee set name = ?,city = ? where id = ?";
        jdbcTemplate.update(sql,new Object[]{employee.getName(),employee.getCity(),employee.getId()});
        return "Employee updated";
    }

    @Override
    public String deleteEmployee(Integer id) {
        String sql =" delete from employee where id = ?";
        jdbcTemplate.update(sql,new  Object[]{id});
        return "Employee deleted";
    }

    @Override
    public List<Map<String, Object>> getCombineData() {
        String sql =" select a.id,a.name as empname ,a.city,b.name as deptname from employee a,department b where a.dept_id=b.id;";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }


}
