
package dhi.ca.ttpl.dao.auth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by:jigme.dorji
 * Date: 22-Apr-2020
 */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class ChangePasswordDao {
    //region private sessionFactory
    @Autowired
    SessionFactory spmsSessionFactory;
    //endregion

    //region public method

    /**
     * to get the old credentials
     *
     * @param userId userId
     * @return String
     */
    @Transactional(readOnly = true)
    public String getOldCredentials(String userId) {
        String query = "SELECT UserPassword FROM tbl_users WHERE UserId =:userId";
        Session session = spmsSessionFactory.getCurrentSession();
        return session.createSQLQuery(query).setParameter("userId", userId).uniqueResult().toString();
    }

    /**
     * update system parameter table for application ID
     *
     * @param newPassword newPassword
     * @param userId      userId
     */
    @Transactional
    public void updateUserPassword(String newPassword, String userId) {
        Session session = spmsSessionFactory.getCurrentSession();
        session.createSQLQuery("UPDATE tbl_users SET UserPassword =:newPassword WHERE UserId =:userId")
                .setParameter("newPassword", newPassword)
                .setParameter("userId", userId)
                .executeUpdate();
    }
    //endregion
}
