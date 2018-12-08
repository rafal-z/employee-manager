package pl.com.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.com.employeemanager.model.Person;
import pl.com.employeemanager.service.PersonService;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/usersXxX", method = RequestMethod.GET)
    public @ResponseBody
    List<Person> getUsers() {
        List<Person> list = personService.getUsers();
        return list;
    }
}
