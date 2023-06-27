package com.example.mysqltest.employeeservice;

import com.example.mysqltest.entity.Employee;
import com.example.mysqltest.repository.EmployeeRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

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
        repository.deleteById(id);
        return repository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        if (repository.findById(id).isEmpty()) {
            throw new ObjectNotFoundException(id, "id");
        }
        return repository.findById(id).get();
    }

    @Override
    public double findSalaryById(Employee employee) {
        return employee.getSalary() + employee.getBonus() - employee.getPenalty();
    }
}
