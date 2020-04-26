
package dhi.ca.ttpl.helper;

import java.util.Date;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
public class CurrentUser {

    //region private fields
    private String loginId;
    private String txtUserName;
    private Date createdDate = new Date();
    private Character userStatus;
    private Integer roleTypeId;
    //endregion

    //region empty constructor
    public CurrentUser() {
    }
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Character getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Character userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getRoleTypeId() {
        return roleTypeId;
    }

    public void setRoleTypeId(Integer roleTypeId) {
        this.roleTypeId = roleTypeId;
    }

    //endregion
}
