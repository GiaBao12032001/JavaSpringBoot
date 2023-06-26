package com.example.testing.controller;

import com.example.testing.dto.EmployeeDTO;
import com.example.testing.entity.Employee;
import com.example.testing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> showEmployees() {
        return employeeService.showEmployees();
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("employee/{id}")
    public EmployeeDTO getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @DeleteMapping("deleteEmployee/{id}")
    public String removeById(@PathVariable Long id) {
        if (employeeService.existID(id)) {
            employeeService.removeById(id);
            return "Employee Deleted";
        } else {
            return "Employee does not exist";
        }
    }

    @GetMapping("/employeeSalary/{id}")
    double checkSalary(@PathVariable Long id) {
        return employeeService.checkSalary(employeeService.getByIdSalary(id));
    }

    @PutMapping("/replace/{id}")
    Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return employeeService.updateEmployee(employee, id);
    }
}
