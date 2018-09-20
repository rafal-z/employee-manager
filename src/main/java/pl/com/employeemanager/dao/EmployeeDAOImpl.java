package pl.com.employeemanager.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.com.employeemanager.dto.EmployeeCriteriaDTO;
import pl.com.employeemanager.model.Employee;

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
}
