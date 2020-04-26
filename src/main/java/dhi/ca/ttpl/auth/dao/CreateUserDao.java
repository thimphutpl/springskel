/**
 * Created by:jigme.dorji
 * Date: 22-Apr-2020
 */
package dhi.ca.ttpl.auth.dao;

import dhi.ca.ttpl.auth.dto.CreateUserDTO;
import dhi.ca.ttpl.auth.entity.CreateUser;
import dhi.ca.ttpl.helper.BaseDao;
import dhi.ca.ttpl.helper.DropdownDTO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Repository()
@SuppressWarnings({"unchecked", "rawtypes"})
public class CreateUserDao extends BaseDao {

    /**
     * to get Status List
     *
     * @return List<ContactCreationDTO>
     */
    @Transactional(readOnly = true)
    public List<DropdownDTO> getStatusList() {
        String sqlQuery = properties.getProperty("CommonDao.getStatusList");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    /**
     * To check if the login id value already exists or not
     *
     * @param loginValue loginValue
     * @return Boolean
     */
    @Transactional(readOnly = true)
    public Boolean isLoginIdAlreadyExists(String loginValue) {
        String sqlQuery = properties.getProperty("CommonDao.isLoginIdAlreadyExists");
        org.hibernate.Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("loginValue", loginValue);
        return (Boolean) hQuery.uniqueResult();

//        String query = "SELECT COUNT(*) FROM tbl_users WHERE UserId =:loginValue";
//        Session session = spmsSessionFactory.getCurrentSession();
//        return !session.createSQLQuery(query).setParameter("loginValue", loginValue).uniqueResult().equals(BigInteger
//                .ZERO);
    }

    /**
     * To get the list of existing users
     *
     * @return List<CreateUserDTO>
     */
    @Transactional(readOnly = true)
    public List<CreateUserDTO> getUserList() {
        String sqlQuery = properties.getProperty("CommonDao.getUserList");
        Query hQuery = hibernateQuery(sqlQuery, CreateUserDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    /**
     * to save the new users
     *
     * @param createUser createUser
     */
    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void saveUsers(CreateUser createUser) {
        em.persist(createUser);
    }

    /**
     * To get the user password
     *
     * @param loginId loginId
     * @return String
     */
    @Transactional(readOnly = true)
    public String getUserInfo(String loginId) {
        String sqlQuery = properties.getProperty("CommonDao.getUserInfo");
        org.hibernate.Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("loginId)", loginId);
        return (String) hQuery.uniqueResult();
    }

    /**
     * To update the user info
     *
     * @param createUser createUser
     */
    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void updateUserInfo(CreateUser createUser) {
        getReportingSession().saveOrUpdate(createUser);
    }

    /**
     * To get populate the grid value to fields
     *
     * @param loginId loginId
     * @return CreateUserDTO
     */
    @Transactional(readOnly = true)
    public CreateUserDTO getGridListToField(String loginId) {
        String query = properties.getProperty("CommonDao.getGridListToField");
        org.hibernate.Query hQuery = hibernateQuery(query, CreateUserDTO.class);
        hQuery.setParameter("loginId", loginId);
        return (CreateUserDTO) hQuery.uniqueResult();
    }

    @Transactional
    public void deleteUser(String userId) {
        String sqlQuery = properties.getProperty("CommonDao.deleteUser");
        org.hibernate.Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("userId",userId);
        hQuery.executeUpdate();
    }
    //endregion


}
