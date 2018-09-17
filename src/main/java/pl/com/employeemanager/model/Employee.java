package pl.com.employeemanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee extends Person{

    private Integer employeeId;

    private boolean active;
    private Date insertDate;
    private Integer insertingPerson;
    private Date lastModDate;
    private Integer lastModPerson;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
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
}
