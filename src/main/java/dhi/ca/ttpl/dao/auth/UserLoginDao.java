package dhi.ca.ttpl.dao.auth;

import dhi.ca.ttpl.dto.CreateUserDTO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Repository("userLoginDao")
public class UserLoginDao {
    //region private sessionFactory
    @Autowired
    SessionFactory spmsSessionFactory;
    //endregion
    //region private variables
    private Query hQuery;
    //endregion

    //region public method

    /**
     * to get the user information while logging in.
     *
     * @param username username
     * @return List<CreateUsersDTO>
     */
    @Transactional(readOnly = true)
    public CreateUserDTO login(String username) {
        Session session = spmsSessionFactory.getCurrentSession();
        String query = "SELECT \n" +
                "UserId                   AS loginId,\n" +
                "UserName                 AS txtUserName,\n" +
                "UserMobileNo             AS userMobileNo,\n" +
                "UserPassword             AS txtPassword,\n" +
                "UserCreatedDate          AS createdDate,\n" +
                "UserUpdatedDate          AS updatedDate,\n" +
                "UserUpdatedBy            AS updatedBy,\n" +
                "userStatus               AS userStatus,\n" +
                "userRoleTypeId           AS roleTypeId \n" +
                "FROM tbl_users WHERE UserId=:username";
        hQuery = session.createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(CreateUserDTO.class))
                .setParameter("username", username);
        return (CreateUserDTO) (hQuery.list().isEmpty() ? null : hQuery.list().get(0));
    }

    //endregion
}
