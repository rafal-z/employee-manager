package pl.com.employeemanager.dto;

import java.util.Date;

public class EmployeeFullDTO extends EmployeeBaseDTO {
    private String middleName;
    private String nationalNo;
    private Date dob;
    private String placeOfBrith;

    private String street;
    private Integer homeNo;
    private Integer flattNo;
    private String voivodship;
    private String district;
    private String place;
    private String postalCode;
    private String postOffice;
    private String country;

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNationalNo() {
        return nationalNo;
    }

    public void setNationalNo(String nationalNo) {
        this.nationalNo = nationalNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPlaceOfBrith() {
        return placeOfBrith;
    }

    public void setPlaceOfBrith(String placeOfBrith) {
        this.placeOfBrith = placeOfBrith;
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
}
