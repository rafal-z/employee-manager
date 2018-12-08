package pl.com.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
    public @ResponseBody List<Employee> getEmployees(){
        List<Employee> list = employeeService.getEmployees();
        return list;
    }

    @PreAuthorize("hasAuthority('user')")
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public @ResponseBody List<EmployeeBaseDTO> getEmployees(@RequestBody EmployeeCriteriaDTO criteria){
        return employeeService.getEmployees(criteria);
    }

    @PreAuthorize("hasAuthority('technical')")
    @RequestMapping(value = "/employee/{personId}", method = RequestMethod.GET)
    public @ResponseBody
    EmployeeFullDTO getEmployee(@PathVariable("personId") Integer personId){
        return employeeService.getEmployee(personId);
    }

    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public @ResponseBody Integer saveEmployee(@RequestBody EmployeeFullDTO employeeFullDTO){
        if(employeeFullDTO.getPersonId() == null){
            return employeeService.saveEmployee(employeeFullDTO);
        } else {
            return employeeService.updateEmployee(employeeFullDTO);
        }
    }
}
