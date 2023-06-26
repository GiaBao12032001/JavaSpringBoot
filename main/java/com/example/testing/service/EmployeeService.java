package com.example.testing.service;

import com.example.testing.dto.EmployeeDTO;
import com.example.testing.dto.SalaryDTO;
import com.example.testing.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final List<Employee> employee = new ArrayList<>();

    public Employee addEmployee(Employee newEmployee) {
        employee.add(newEmployee);
        return newEmployee;
    }

    public List<EmployeeDTO> showEmployees() {
        return employee.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public EmployeeDTO getById(Long id) {
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getId() == (id)) {
                return convertToDTO(employee.get(i));
            }
        }
        return null;
    }

    public EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setAge(employee.getAge());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setSalary(employee.getSalary());
        return employeeDTO;
    }

    public SalaryDTO convertToDTOSalary(Employee employee) {
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setSalary(employee.getSalary());
        salaryDTO.setBonus(employee.getBonus());
        salaryDTO.setPenalty(employee.getPenalty());
        return salaryDTO;
    }

    public String removeById(long id) {
        if (existID(id)) {
            employee.removeIf(idx -> Objects.equals(idx.getId(), id));
            return "Employee deleted.";
        } else {
            return null;
        }
    }

    public Employee updateEmployee(Employee employee, Long id) {
        if (existID(id)) {
            removeById(id);
            return addEmployee(employee);
        }
        return null;
    }

    public double checkSalary(SalaryDTO salaryDTO) {
        return salaryDTO.getSalary() + salaryDTO.getBonus() - salaryDTO.getPenalty();
    }

    public SalaryDTO getByIdSalary(Long id) {
        for (int i = 0; i < employee.size(); i++) {
            if (Objects.equals(employee.get(i).getId(), id)) {
                return convertToDTOSalary(employee.get(i));
            }
        }
        return null;
    }

    public boolean existID(Long id) {
        return employee.stream().filter(e -> e.getId().equals(id)).count() == 1;
    }
}
