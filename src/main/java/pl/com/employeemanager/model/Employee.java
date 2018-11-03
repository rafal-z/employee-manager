package pl.com.employeemanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee extends Person{

    private boolean active;
    private String roomNo;
    private boolean online;
    private Double salary;
    private String currency;
    private String occupation;
    private String team;
    private Date dateHired;
    private Date dateDismissal;
    private Date insertDate;
    private Integer insertingPerson;
    private Date lastModDate;
    private Integer lastModPerson;


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public Date getDateDismissal() {
        return dateDismissal;
    }

    public void setDateDismissal(Date dateDismissal) {
        this.dateDismissal = dateDismissal;
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
