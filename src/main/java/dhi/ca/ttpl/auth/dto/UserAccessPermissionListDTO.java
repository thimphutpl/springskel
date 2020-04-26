package dhi.ca.ttpl.auth.dto;
/**
 * Created by jigme.dorji on 23/04/2020.
 */
public class UserAccessPermissionListDTO {

    private Integer id;
    private Integer screenId;
    private String screenName;
    private Boolean isScreenAccessAllowed;
    private Boolean isEditAccessAllowed;
    private Boolean isDeleteAccessAllowed;
    private Boolean isSaveAccessAllowed;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
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
