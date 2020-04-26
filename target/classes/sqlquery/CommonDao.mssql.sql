
CommonDao.getOldCredentials = SELECT UserPassword FROM tbl_users WHERE UserId =:userId

CommonDao.updateUserPassword = UPDATE tbl_users SET UserPassword =:newPassword WHERE UserId =:userId

CommonDao.getStatusList = SELECT CAST(StatusId AS CHAR(1)) AS value, StatusTitle AS text FROM tbl_systemstatus

CommonDao.isLoginIdAlreadyExists = SELECT COUNT(*) FROM tbl_users WHERE UserId =:loginValue

CommonDao.getUserList = SELECT A.UserId AS loginId, \
                      A.UserName AS txtUserName, \
                      A.UserCreatedDate AS createdDate, \
                      A.userStatus AS userStatus ,\
                      B.roleName \
                      FROM tbl_users A INNER JOIN tbl_roles B ON A.userRoleTypeId = B.roleId
CommonDao.getUserInfo = SELECT UserPassword FROM tbl_users WHERE UserId=:loginId

CommonDao.getGridListToField = SELECT UserId AS loginId, UserName AS txtUserName, \
                       UserMobileNo AS userMobileNo,userRoleTypeId AS roleTypeId, \
                       UserCreatedDate AS createdDate, userStatus AS userStatus FROM tbl_users WHERE UserId =:loginId

CommonDao.deleteUser = DELETE FROM tbl_users  WHERE UserId=:userId

CommonDao.getUserRoleList = SELECT roleId AS valueInteger,roleName AS text FROM tbl_roles

CommonDao.getScreenList = SELECT \
                      a.screenId AS screenId, \
                      a.screenName AS screenName, \
                      b.id AS id, \
                      b.isScreenAccessAllowed AS isScreenAccessAllowed, \
                      b.isEditAccessAllowed AS  isEditAccessAllowed, \
                      b.isDeleteAccessAllowed AS  isDeleteAccessAllowed, \
                      b.isSaveAccessAllowed AS  isSaveAccessAllowed \
                      FROM tbl_screen a INNER JOIN tbl_useraccesspermission b \
                      ON a.screenId = b.screenId WHERE b.roleId =:roleTypeId

CommonDao.getUnScreenList = SELECT a.screenId AS screenId, a.screenName AS screenName FROM tbl_screen a

CommonDao.isUserRoleAssigned = SELECT(EXISTS(SELECT * FROM tbl_useraccesspermission WHERE roleId=:roleTypeId))

CommonDao.login = SELECT \
                  UserId AS loginId, \
                  UserName AS txtUserName, \
                  UserMobileNo AS userMobileNo, \
                  UserPassword AS txtPassword, \
                  UserCreatedDate AS createdDate, \
                  UserUpdatedDate AS updatedDate, \
                  UserUpdatedBy AS updatedBy, \
                  userStatus AS userStatus, \
                  userRoleTypeId AS roleTypeId \
                  FROM tbl_users WHERE UserId =:username
