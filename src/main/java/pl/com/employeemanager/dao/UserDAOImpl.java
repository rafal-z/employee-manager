package pl.com.employeemanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.com.employeemanager.model.User;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserByLogin(String login) {
        Session session = sessionFactory.openSession();
        User user = (User) session.createCriteria(User.class)
                            .add(Restrictions.eq("login", login))
                            .uniqueResult();
        session.close();
        return user;
    }
}
