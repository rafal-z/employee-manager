package pl.com.employeemanager.mapper;

import org.springframework.stereotype.Component;
import pl.com.employeemanager.dto.UserDTO;
import pl.com.employeemanager.model.User;

@Component
public class UserMapper {
    public UserDTO repack(User from){
        UserDTO to = new UserDTO();
        to.setUserId(from.getUserId());
        to.setLogin(from.getLogin());
        if(from.getPerson() != null) {
            to.setFirstName(from.getPerson().getFirstName());
            to.setLastName(from.getPerson().getLastName());
        }
        return to;
    }
}
