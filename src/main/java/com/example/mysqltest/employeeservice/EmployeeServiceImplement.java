package com.example.mysqltest.employeeservice;

import com.example.mysqltest.entity.Employee;
import com.example.mysqltest.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplement implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImplement(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Employee updateById(Employee employee, Long id) {
        Optional<Employee> value = repository.findById(id);
        if (value.isPresent()) {
            repository.deleteById(id);
            return repository.save(employee);
        } else {
            return null;
        }
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> value = repository.findById(id);
        return value.orElse(null);
    }

    @Override
    public double findSalaryById(Employee employee) {
        return employee.getSalary() + employee.getBonus() - employee.getPenalty();
    }
}
