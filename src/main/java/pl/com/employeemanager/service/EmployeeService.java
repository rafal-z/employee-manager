package pl.com.employeemanager.service;

import pl.com.employeemanager.dto.EmployeeBaseDTO;
import pl.com.employeemanager.dto.EmployeeCriteriaDTO;
import pl.com.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    List<EmployeeBaseDTO> getEmployees(EmployeeCriteriaDTO criteria);
}
