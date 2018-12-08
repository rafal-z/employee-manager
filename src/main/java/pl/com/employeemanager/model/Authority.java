package pl.com.employeemanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authority {
    @Id
    private Integer authorityId;

    private String name;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
