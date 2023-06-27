package com.example.mysqltest.controller;

import com.example.mysqltest.employeeservice.EmployeeService;
import com.example.mysqltest.entity.Employee;
import com.example.mysqltest.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeService service;
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeService service, EmployeeRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Employee> getEmployees() {
        return service.findAll();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.save(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void removeEmployee(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateById(employee, id);
    }

    @GetMapping("/salary/{id}")
    public double findSalaryById(@PathVariable Long id, Employee employee) {
        employee = service.findById(id);
        return service.findSalaryById(employee);
    }
}
