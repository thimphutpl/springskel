package dhi.ca.ttpl.auth.dao;

import dhi.ca.ttpl.auth.dto.UserAccessPermissionListDTO;
import dhi.ca.ttpl.auth.entity.UserAccessPermission;
import dhi.ca.ttpl.helper.BaseDao;
import dhi.ca.ttpl.helper.DropdownDTO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jigme.dorji Sawa on 22/04/2020.
 */
@Repository()
public class UserAccessPermissionDao extends BaseDao {


    @Transactional(readOnly = true)
    public List<DropdownDTO> getUserRoleList() {
        String sqlQuery = properties.getProperty("CommonDao.getUserRoleList");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<UserAccessPermissionListDTO> getScreenList(Integer roleTypeId) {
        String sqlQuery = properties.getProperty("CommonDao.getScreenList");
        Query hQuery = hibernateQuery(sqlQuery, UserAccessPermissionListDTO.class);
        hQuery.setParameter("roleTypeId", roleTypeId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<UserAccessPermissionListDTO> getUnScreenList() {
        String sqlQuery = properties.getProperty("CommonDao.getUnScreenList");
        Query hQuery = hibernateQuery(sqlQuery, UserAccessPermissionListDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }


    @Transactional(readOnly = true)
    public Boolean isUserRoleAssigned(Integer roleTypeId) {
        String sqlQuery = properties.getProperty("CommonDao.isUserRoleAssigned");
        org.hibernate.Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("roleTypeId", roleTypeId);
        return (Boolean) hQuery.uniqueResult();

//        String query = "SELECT(EXISTS(SELECT * FROM tbl_useraccesspermission WHERE roleId=:roleTypeId))";
//        Session session = sessionFactory.getCurrentSession();
//        return session.createSQLQuery(query)
//                .setParameter("roleTypeId", roleTypeId)
//                .uniqueResult().equals(BigInteger.ONE);
    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void update(UserAccessPermission userAccessPermission) {
        getReportingSession().update(userAccessPermission);
    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void save(UserAccessPermission userAccessPermission) {
        em.persist(userAccessPermission);
    }

}
