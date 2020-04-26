package dhi.ca.ttpl.helper;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    //region private variables
    @Column(name = "CreateBy")
    private String createBy;

    @Column(name = "SetDate")
    private Date setDate;
    //endregion

    //region setters and getters
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getSetDate() {
        return setDate;
    }

    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }
    //endregion
}
