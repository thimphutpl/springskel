package dhi.ca.ttpl.dao.auth;
/**
 * Created by jigme.dorji on 23/04/2020.
 */
import dhi.ca.ttpl.dto.UserAccessPermissionListDTO;
import dhi.ca.ttpl.entity.UserAccessPermission;
import dhi.ca.ttpl.library.helper.DropdownDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by jigme.dorji Sawa on 22/04/2020.
 */
@Repository("userAccessPermissionDao")
public class UserAccessPermissionDao {

    @Autowired
    SessionFactory sessionFactory;


    @Transactional(readOnly = true)
    public List<DropdownDTO> getUserRoleList() {
        String query = "SELECT roleId AS valueInteger,roleName AS text FROM tbl_roles";
        Session session = sessionFactory.getCurrentSession();
        return session.createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(DropdownDTO.class)).list();
    }

    @Transactional(readOnly = true)
    public List<UserAccessPermissionListDTO> getScreenList(Integer roleTypeId) {
        String query = "SELECT \n" +
                "    a.screenId AS screenId,\n" +
                "    a.screenName AS screenName,\n" +
                "    b.id AS id,\n" +
                "    b.isScreenAccessAllowed AS isScreenAccessAllowed,\n" +
                "    b.isEditAccessAllowed AS  isEditAccessAllowed,\n" +
                "    b.isDeleteAccessAllowed AS  isDeleteAccessAllowed,\n" +
                "    b.isSaveAccessAllowed AS  isSaveAccessAllowed\n" +
                "FROM\n" +
                "    tbl_screen a\n" +
                "        INNER JOIN\n" +
                "    tbl_useraccesspermission b ON a.screenId = b.screenId WHERE b.roleId=:roleTypeId";
        Session session = sessionFactory.getCurrentSession();
        return session.createSQLQuery(query)
                .setParameter("roleTypeId", roleTypeId)
                .setResultTransformer(Transformers.aliasToBean(UserAccessPermissionListDTO.class)).list();
    }

    @Transactional(readOnly = true)
    public List<UserAccessPermissionListDTO> getUnScreenList() {
        String query = "SELECT \n" +
                "    a.screenId AS screenId,\n" +
                "    a.screenName AS screenName\n" +
                "FROM\n" +
                "    tbl_screen a";
        Session session = sessionFactory.getCurrentSession();
        return session.createSQLQuery(query)
                .setResultTransformer(Transformers.aliasToBean(UserAccessPermissionListDTO.class)).list();
    }


    @Transactional(readOnly = true)
    public Boolean isUserRoleAssigned(Integer roleTypeId) {
        String query = "SELECT(EXISTS(SELECT * FROM tbl_useraccesspermission WHERE roleId=:roleTypeId))";
        Session session = sessionFactory.getCurrentSession();
        return session.createSQLQuery(query)
                .setParameter("roleTypeId", roleTypeId)
                .uniqueResult().equals(BigInteger.ONE);
    }

    @Transactional
    public void update(UserAccessPermission userAccessPermission) {
        sessionFactory.getCurrentSession().update(userAccessPermission);

    }

    @Transactional
    public void save(UserAccessPermission userAccessPermission) {
        sessionFactory.getCurrentSession().save(userAccessPermission);
    }

}
