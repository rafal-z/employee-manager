package pl.com.employeemanager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
    @Id
    private Integer userId;

    private String email;
    private String login;
    private String password;
    private Date ExpiredPassword;
    private boolean active;
    private Date InsertDate;
    private Integer insertingPerson;
    private Date lastModDate;
    private Integer lastModPerson;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserAuthority", joinColumns = @JoinColumn(name = "UserID"), inverseJoinColumns = @JoinColumn(name = "AuthorityID"))
    private Set<Authority> authorities;

    @OneToOne
    @JoinColumn(name = "PersonID")
    private Person person;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExpiredPassword() {
        return ExpiredPassword;
    }

    public void setExpiredPassword(Date expiredPassword) {
        ExpiredPassword = expiredPassword;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getInsertDate() {
        return InsertDate;
    }

    public void setInsertDate(Date insertDate) {
        InsertDate = insertDate;
    }

    public Integer getInsertingPerson() {
        return insertingPerson;
    }

    public void setInsertingPerson(Integer insertingPerson) {
        this.insertingPerson = insertingPerson;
    }

    public Date getLastModDate() {
        return lastModDate;
    }

    public void setLastModDate(Date lastModDate) {
        this.lastModDate = lastModDate;
    }

    public Integer getLastModPerson() {
        return lastModPerson;
    }

    public void setLastModPerson(Integer lastModPerson) {
        this.lastModPerson = lastModPerson;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
