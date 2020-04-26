package dhi.ca.ttpl.auth.entity;

import javax.persistence.*;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Entity
@Table(name = "tbl_useraccesspermission")
public class UserAccessPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "roleId")
    private Integer roleId;

    @Column(name = "screenId")
    private Integer screenId;

    @Column(name = "isScreenAccessAllowed")
    private Boolean isScreenAccessAllowed;

    @Column(name = "isEditAccessAllowed")
    private Boolean isEditAccessAllowed;

    @Column(name = "isDeleteAccessAllowed")
    private Boolean isDeleteAccessAllowed;

    @Column(name = "isSaveAccessAllowed")
    private Boolean isSaveAccessAllowed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public Boolean getIsScreenAccessAllowed() {
        return isScreenAccessAllowed;
    }

    public void setIsScreenAccessAllowed(Boolean isScreenAccessAllowed) {
        this.isScreenAccessAllowed = isScreenAccessAllowed;
    }

    public Boolean getIsEditAccessAllowed() {
        return isEditAccessAllowed;
    }

    public void setIsEditAccessAllowed(Boolean isEditAccessAllowed) {
        this.isEditAccessAllowed = isEditAccessAllowed;
    }

    public Boolean getIsDeleteAccessAllowed() {
        return isDeleteAccessAllowed;
    }

    public void setIsDeleteAccessAllowed(Boolean isDeleteAccessAllowed) {
        this.isDeleteAccessAllowed = isDeleteAccessAllowed;
    }

    public Boolean getIsSaveAccessAllowed() {
        return isSaveAccessAllowed;
    }

    public void setIsSaveAccessAllowed(Boolean isSaveAccessAllowed) {
        this.isSaveAccessAllowed = isSaveAccessAllowed;
    }
}
