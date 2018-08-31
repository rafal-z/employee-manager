package pl.com.employeemanager.dao;

import java.util.List;

import pl.com.employeemanager.model.Person;

public interface PersonDAO {

    public void save(Person p);

    public List<Person> list();

}
