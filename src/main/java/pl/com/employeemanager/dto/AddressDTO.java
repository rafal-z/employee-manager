package pl.com.employeemanager.dto;

public class AddressDTO {
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
}
