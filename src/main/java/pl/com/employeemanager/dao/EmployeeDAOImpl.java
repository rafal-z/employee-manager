package pl.com.employeemanager.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.com.employeemanager.dto.EmployeeCriteriaDTO;
import pl.com.employeemanager.model.Address;
import pl.com.employeemanager.model.Employee;

import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> list() {
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery("from Employee").list();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getEmployees(EmployeeCriteriaDTO criteriaDTO){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        buildCriteria(criteria, criteriaDTO);
        List<Employee> result = criteria.list();
        return result;
    }

    private void buildCriteria(Criteria criteria, EmployeeCriteriaDTO employeeCriteriaDTO){
        if(employeeCriteriaDTO.getPersonId() != null){
            criteria.add(Restrictions.eq("personId", employeeCriteriaDTO.getPersonId()));
        }
        if(employeeCriteriaDTO.getFirstName() != null){
            criteria.add(Restrictions.ilike("firstName", employeeCriteriaDTO.getFirstName()));
        }
        if(employeeCriteriaDTO.getLastName() != null){
            criteria.add(Restrictions.ilike("lastName", employeeCriteriaDTO.getLastName()));
        }
        if(employeeCriteriaDTO.getNationalNo() != null){
            criteria.add(Restrictions.ilike("nationalNo", employeeCriteriaDTO.getNationalNo()));
        }
    }

    public Employee getEmployee(Integer personId){
        Session session = sessionFactory.openSession();
        Employee employee = (Employee) session.get(Employee.class, personId);
        session.close();
        return employee;
    }

    public Integer saveEmployee(Employee employee){
        addLastInsertDateAndPerson(employee);
        addLastModifiedDateAndPerson(employee);
        Session session = sessionFactory.openSession();
        Integer personId = (Integer) session.save(employee);
        for(Address address: employee.getAddress()){
            address.setInsertDate(new Date());
            address.setLastModDate(new Date());
            session.save(address);
        }
        session.flush();
        session.close();
        return personId;
    }

    public Integer updateEmployee(Employee employee){
        addLastModifiedDateAndPerson(employee);
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(employee);
        for(Address address: employee.getAddress()){
            address.setLastModDate(new Date());
            session.saveOrUpdate(address);
        }
        session.flush();
        session.close();
        return employee.getPersonId();
    }

    private void addLastInsertDateAndPerson(Employee employee){
        employee.setLastModDate(new Date());
//        employee.setLastModPerson(); //TODO
    }

    private void addLastModifiedDateAndPerson(Employee employee){
        employee.setLastModDate(new Date());
//        employee.setLastModPerson(); //TODO
    }
}
