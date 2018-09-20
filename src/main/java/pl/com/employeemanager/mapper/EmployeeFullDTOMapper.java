package pl.com.employeemanager.mapper;

import org.springframework.stereotype.Component;
import pl.com.employeemanager.dto.EmployeeFullDTO;
import pl.com.employeemanager.model.Address;
import pl.com.employeemanager.model.Employee;

@Component
public class EmployeeFullDTOMapper {
    public EmployeeFullDTO repack(Employee from){
        EmployeeFullDTO to = new EmployeeFullDTO();
        to.setPersonId(from.getPersonId());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setMiddleName(from.getMiddleName());
        to.setNationalNo(from.getNationalNo());
        to.setDob(from.getDob());
        to.setPlaceOfBrith(from.getPlaceOfBrith());
        to.setSex(from.getSex());
        to.setCellPhone(from.getCellPhone());
        to.setEmail(from.getEmail());
        to.setActive(from.isActive());
        to.setRoomNo(from.getRoomNo());
        to.setOnline(from.isOnline());
        to.setSalary(from.getSalary());
        to.setCurrency(from.getCurrency());
        to.setOccupation(from.getOccupation());
        to.setTeam(from.getTeam());
        to.setDateHired(from.getDateHired());
        to.setDateDismissal(from.getDateDismissal());

        for(Address address : from.getAddress()){
            if(address.getAddressTypeId() == 1){
                to.setStreet(address.getStreet());
                to.setHomeNo(address.getHomeNo());
                to.setFlattNo(address.getFlattNo());
                to.setVoivodship(address.getVoivodship());
                to.setDistrict(address.getDistrict());
                to.setPlace(address.getPlace());
                to.setPostalCode(address.getPostalCode());
                to.setPostOffice(address.getPostOffice());
                to.setCountry(address.getCountry());
            }
        }

        return to;
    }
}
