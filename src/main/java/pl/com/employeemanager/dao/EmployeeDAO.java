package pl.com.employeemanager.dao;

import pl.com.employeemanager.dto.EmployeeCriteriaDTO;
import pl.com.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> list();
    List<Employee> getEmployees(EmployeeCriteriaDTO criteria);
    Employee getEmployee(Integer personId);
}
