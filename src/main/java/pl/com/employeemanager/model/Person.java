
package pl.com.employeemanager.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @Column(name="PersonID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer personId;

    private String firstName;
    private String lastName;
    private String middleName;
    private String sex;
    private String nationalNo;
    private Date dob;
    private String placeOfBrith;
    private String cellPhone;
    private String email;
    private Date insertDate;
    private Integer insertingPerson;
    private Date lastModDate;
    private Integer lastModPerson;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "LAddressPerson", joinColumns = @JoinColumn(name = "PersonId"), inverseJoinColumns = @JoinColumn(name = "AddressId"))
    @Fetch(FetchMode.SELECT)
    private List<Address> address;


    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "personId="+personId+", firstName="+firstName+", lastName="+lastName;
    }
}
