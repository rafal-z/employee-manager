package pl.com.employeemanager.dto;

import java.util.Date;

public class EmployeeFullDTO extends EmployeeBaseDTO {
    private String middleName;
    private String nationalNo;
    private Date dob;
    private String placeOfBrith;

    private AddressDTO address;
    private AddressDTO correspondenceAddress;

    private Double salary;
    private String currency;
    private Date dateHired;
    private Date dateDismissal;

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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public AddressDTO getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(AddressDTO correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
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
}
