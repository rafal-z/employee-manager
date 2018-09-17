package pl.com.employeemanager.mapper;

import org.springframework.stereotype.Component;
import pl.com.employeemanager.dto.EmployeeBaseDTO;
import pl.com.employeemanager.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {
    public List<EmployeeBaseDTO> repack(final List<Employee> from){
        List<EmployeeBaseDTO> to = new ArrayList<>();
        for(Employee employee : from){
            EmployeeBaseDTO employeeDTO = new EmployeeBaseDTO();
            employeeDTO.setPersonId(employee.getPersonId());
            employeeDTO.setFirstName(employee.getFirstName());
            employeeDTO.setLastName(employee.getLastName());
            employeeDTO.setNationalNo(employee.getNationalNo());
            employeeDTO.setDob(employee.getDob());
            employeeDTO.setSex(employee.getSex());
            employeeDTO.setCellPhone(employee.getCellPhone());
            employeeDTO.setEmail(employee.getEmail());
            to.add(employeeDTO);
        }
        return to;
    }

    public List<Employee> pack(final List<EmployeeBaseDTO> from){
        List<Employee> to = new ArrayList<>();
        for(EmployeeBaseDTO employeeDTO : from){
            Employee employee = new Employee();
            employee.setPersonId(employeeDTO.getPersonId());
            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());
            employee.setNationalNo(employeeDTO.getNationalNo());
            employee.setDob(employeeDTO.getDob());
            employee.setSex(employeeDTO.getSex());
            employee.setCellPhone(employeeDTO.getCellPhone());
            employee.setEmail(employeeDTO.getEmail());
            to.add(employee);
        }
        return to;
    }
}
