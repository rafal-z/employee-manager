package pl.com.employeemanager.mapper;

import org.springframework.stereotype.Component;
import pl.com.employeemanager.dto.EmployeeBaseDTO;
import pl.com.employeemanager.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {
    public List<EmployeeBaseDTO> repackList(final List<Employee> from){
        List<EmployeeBaseDTO> to = new ArrayList<>();
        for(Employee employee : from){
            to.add(repack(employee));
        }
        return to;
    }

    public EmployeeBaseDTO repack(final Employee from){
        EmployeeBaseDTO to = new EmployeeBaseDTO();
        to.setPersonId(from.getPersonId());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setSex(from.getSex());
        to.setCellPhone(from.getCellPhone());
        to.setEmail(from.getEmail());
        to.setActive(from.isActive());
        to.setRoomNo(from.getRoomNo());
        to.setOnline(from.isOnline());
        to.setOccupation(from.getOccupation());
        to.setTeam(from.getTeam());
        return to;
    }

    public Employee pack(final EmployeeBaseDTO from){
        Employee to = new Employee();
        to.setPersonId(from.getPersonId());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setSex(from.getSex());
        to.setCellPhone(from.getCellPhone());
        to.setEmail(from.getEmail());
        to.setActive(from.isActive());
        to.setRoomNo(from.getRoomNo());
        to.setOnline(from.isOnline());
        to.setOccupation(from.getOccupation());
        to.setTeam(from.getTeam());
        return to;
    }
}
