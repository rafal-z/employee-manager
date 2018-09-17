package pl.com.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.employeemanager.dao.EmployeeDAO;
import pl.com.employeemanager.dto.EmployeeBaseDTO;
import pl.com.employeemanager.dto.EmployeeCriteriaDTO;
import pl.com.employeemanager.mapper.EmployeeMapper;
import pl.com.employeemanager.model.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployees() {
        return employeeDAO.list();
    }

    @Override
    public List<EmployeeBaseDTO> getEmployees(EmployeeCriteriaDTO criteria){
        List<Employee> employees = employeeDAO.getEmployees(criteria);
        return employeeMapper.repack(employees);
    }
}
