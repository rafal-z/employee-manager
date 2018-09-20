package pl.com.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.com.employeemanager.dto.EmployeeBaseDTO;
import pl.com.employeemanager.dto.EmployeeCriteriaDTO;
import pl.com.employeemanager.dto.EmployeeFullDTO;
import pl.com.employeemanager.model.Employee;
import pl.com.employeemanager.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
    public @ResponseBody List<Employee> getEmployees(){
        List<Employee> list = employeeService.getEmployees();
        return list;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public @ResponseBody List<EmployeeBaseDTO> getEmployees(@RequestBody EmployeeCriteriaDTO criteria){
        return employeeService.getEmployees(criteria);
    }

    @RequestMapping(value = "/employee/{personId}", method = RequestMethod.GET)
    public @ResponseBody
    EmployeeFullDTO getEmployee(@PathVariable("personId") Integer personId){
        return employeeService.getEmployee(personId);
    }
}
