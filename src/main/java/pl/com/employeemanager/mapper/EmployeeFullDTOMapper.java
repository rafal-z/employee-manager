package pl.com.employeemanager.mapper;

import org.springframework.stereotype.Component;
import pl.com.employeemanager.dto.AddressDTO;
import pl.com.employeemanager.dto.EmployeeFullDTO;
import pl.com.employeemanager.model.Address;
import pl.com.employeemanager.model.Employee;

import java.util.ArrayList;

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
            if(address.getAddressTypeId().equals(1)) {
                AddressDTO addressDTO = new AddressDTO();
                addressDTO.setAddressId(address.getAddressId());
                addressDTO.setAddressTypeId(address.getAddressTypeId());
                addressDTO.setStreet(address.getStreet());
                addressDTO.setHomeNo(address.getHomeNo());
                addressDTO.setFlattNo(address.getFlattNo());
                addressDTO.setVoivodship(address.getVoivodship());
                addressDTO.setDistrict(address.getDistrict());
                addressDTO.setPlace(address.getPlace());
                addressDTO.setPostalCode(address.getPostalCode());
                addressDTO.setPostOffice(address.getPostOffice());
                addressDTO.setCountry(address.getCountry());
                to.setAddress(addressDTO);
            } else {
                AddressDTO addressDTO = new AddressDTO();
                addressDTO.setAddressId(address.getAddressId());
                addressDTO.setAddressTypeId(address.getAddressTypeId());
                addressDTO.setStreet(address.getStreet());
                addressDTO.setHomeNo(address.getHomeNo());
                addressDTO.setFlattNo(address.getFlattNo());
                addressDTO.setVoivodship(address.getVoivodship());
                addressDTO.setDistrict(address.getDistrict());
                addressDTO.setPlace(address.getPlace());
                addressDTO.setPostalCode(address.getPostalCode());
                addressDTO.setPostOffice(address.getPostOffice());
                addressDTO.setCountry(address.getCountry());
                to.setCorrespondenceAddress(addressDTO);
            }
        }

        return to;
    }

    public Employee pack(EmployeeFullDTO from){
        Employee to = new Employee();
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
        to.setAddress(new ArrayList<>());

        if(from.getAddress() != null){
            AddressDTO addressDTO = from.getAddress();
            Address address = new Address();
            address.setAddressId(addressDTO.getAddressId());
            address.setAddressTypeId(addressDTO.getAddressTypeId());
            address.setStreet(addressDTO.getStreet());
            address.setHomeNo(addressDTO.getHomeNo());
            address.setFlattNo(addressDTO.getFlattNo());
            address.setVoivodship(addressDTO.getVoivodship());
            address.setDistrict(addressDTO.getDistrict());
            address.setPlace(addressDTO.getPlace());
            address.setPostalCode(addressDTO.getPostalCode());
            address.setPostOffice(addressDTO.getPostOffice());
            address.setCountry(addressDTO.getCountry());
            to.getAddress().add(address);
        }

        if(from.getCorrespondenceAddress() != null){
            AddressDTO addressDTO = from.getCorrespondenceAddress();
            Address address = new Address();
            address.setAddressId(addressDTO.getAddressId());
            address.setAddressTypeId(addressDTO.getAddressTypeId());
            address.setStreet(addressDTO.getStreet());
            address.setHomeNo(addressDTO.getHomeNo());
            address.setFlattNo(addressDTO.getFlattNo());
            address.setVoivodship(addressDTO.getVoivodship());
            address.setDistrict(addressDTO.getDistrict());
            address.setPlace(addressDTO.getPlace());
            address.setPostalCode(addressDTO.getPostalCode());
            address.setPostOffice(addressDTO.getPostOffice());
            address.setCountry(addressDTO.getCountry());
            to.getAddress().add(address);
        }

        return to;
    }
}
