package pl.com.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.employeemanager.dao.PersonDAO;
import pl.com.employeemanager.model.Person;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDAO personDAO;

    @Override
    public List<Person> getUsers(){
        return personDAO.list();
    }
}
