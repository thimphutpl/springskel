
package dhi.ca.ttpl.auth.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Entity
@Table(name = "tbl_users")
public class CreateUser implements Serializable {

    private static final long serialVersionUID = -723583058586873479L;
    //region private column fields
    @Id
    @NotNull
    @Column(name = "UserId")
    private String loginId;

    @NotNull
    @Column(name = "UserName")
    private String txtUserName;

    @Column(name = "UserMobileNo")
    private String userMobileNo;

    @NotNull
    @Column(name = "UserPassword")
    private String txtPassword;

    @NotNull
    @Column(name = "UserCreatedDate")
    private Date createdDate;

    @NotNull
    @Column(name = "userStatus")
    private Character userStatus;

    @Column(name = "UserUpdatedDate")
    private Date updatedDate;

    @Column(name = "UserUpdatedBy")
    private String updatedBy;

    @Column(name = "userRoleTypeId")
    private Integer userRoleTypeId;

    //endregion


    //region public setter and getter
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserName(String txtUserName) {
        this.txtUserName = txtUserName;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    public void setUserStatus(Character userStatus) {
        this.userStatus = userStatus;
    }

    public Character getUserStatus() {
        return userStatus;
    }

    public String getUserMobileNo() {
        return userMobileNo;
    }

    public void setUserMobileNo(String userMobileNo) {
        this.userMobileNo = userMobileNo;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getUserRoleTypeId() {
        return userRoleTypeId;
    }

    public void setUserRoleTypeId(Integer userRoleTypeId) {
        this.userRoleTypeId = userRoleTypeId;
    }
    //endregion
}
