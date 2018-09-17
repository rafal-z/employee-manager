package pl.com.employeemanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer addressId;

    private Integer addressTypeId;
    private String street;
    private Integer homeNo;
    private Integer flattNo;
    private String voivodship;
    private String district;
    private String place;
    private String postalCode;
    private String postOffice;
    private String country;
    private boolean active;
    private Date insertDate;
    private Integer insertingPerson;
    private Date lastModDate;
    private Integer lastModPerson;


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(Integer addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(Integer homeNo) {
        this.homeNo = homeNo;
    }

    public Integer getFlattNo() {
        return flattNo;
    }

    public void setFlattNo(Integer flattNo) {
        this.flattNo = flattNo;
    }

    public String getVoivodship() {
        return voivodship;
    }

    public void setVoivodship(String voivodship) {
        this.voivodship = voivodship;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
