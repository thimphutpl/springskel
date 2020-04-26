package dhi.ca.ttpl.auth.dto;

/**
 * Created by nzepa on 4/20/2020.
 */
public class CompanyRegistrationDTO {
    private Integer companyId;
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
