package dhi.ca.ttpl.dhiCompact.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nzepa on 4/20/2020.
 */
@Entity
@Table(name = "company")
public class CompanyRegistration {
    @Id
    @Column(name = "companyId")
    private Integer companyId;

    @Column(name = "companyName")
    private String companyName;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
