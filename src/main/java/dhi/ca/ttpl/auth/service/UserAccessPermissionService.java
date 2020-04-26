package dhi.ca.ttpl.auth.service;

import dhi.ca.ttpl.auth.dao.UserAccessPermissionDao;
import dhi.ca.ttpl.auth.dto.UserAccessPermissionDTO;
import dhi.ca.ttpl.auth.dto.UserAccessPermissionListDTO;
import dhi.ca.ttpl.auth.entity.UserAccessPermission;
import dhi.ca.ttpl.helper.CurrentUser;
import dhi.ca.ttpl.helper.DropdownDTO;
import dhi.ca.ttpl.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Service("userAccessPermissionService")
public class UserAccessPermissionService {

    @Autowired
    private UserAccessPermissionDao userAccessPermissionDao;

    public List<DropdownDTO> getUserRoleList() {
        return userAccessPermissionDao.getUserRoleList();
    }

    public List<UserAccessPermissionListDTO> getScreenList(Integer roleTypeId) {

        List<UserAccessPermissionListDTO> userAccessPermissionListDTOList;
        if (userAccessPermissionDao.isUserRoleAssigned(roleTypeId)) {
            userAccessPermissionListDTOList = userAccessPermissionDao.getScreenList(roleTypeId);
        } else {
            userAccessPermissionListDTOList = userAccessPermissionDao.getUnScreenList();
        }
        return userAccessPermissionListDTOList;
    }

    public ResponseMessage save(UserAccessPermissionDTO userAccessPermissionDTO, CurrentUser currentUser) {
        UserAccessPermission userAccessPermission = new UserAccessPermission();
        ResponseMessage responseMessage = new ResponseMessage();
        for (UserAccessPermissionListDTO userAccessPermissionListDTO : userAccessPermissionDTO.getUserAccessPermissionListDTO()) {
            userAccessPermission.setScreenId(userAccessPermissionListDTO.getScreenId());
            userAccessPermission.setRoleId(userAccessPermissionDTO.getUserRoleTypeId());
            userAccessPermission.setIsScreenAccessAllowed(userAccessPermissionListDTO.getIsScreenAccessAllowed());
            userAccessPermission.setIsEditAccessAllowed(userAccessPermissionListDTO.getIsEditAccessAllowed());
            userAccessPermission.setIsDeleteAccessAllowed(userAccessPermissionListDTO.getIsDeleteAccessAllowed());
            userAccessPermission.setIsSaveAccessAllowed(userAccessPermissionListDTO.getIsSaveAccessAllowed());
            if (userAccessPermissionListDTO.getId() != null) {
                userAccessPermission.setId(userAccessPermissionListDTO.getId());
                userAccessPermissionDao.update(userAccessPermission);
            } else {
                userAccessPermissionDao.save(userAccessPermission);
            }
        }

        responseMessage.setStatus(1);
        responseMessage.setText("Information successfully saved.");
        return responseMessage;
    }

    public List<UserAccessPermissionListDTO> getUserAccessPermissionDetails(Integer roleTypeId) {
        return userAccessPermissionDao.getScreenList(roleTypeId);
    }
}
