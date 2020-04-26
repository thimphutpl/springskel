package dhi.ca.ttpl.auth.dao;

import dhi.ca.ttpl.auth.dto.CreateUserDTO;
import dhi.ca.ttpl.helper.BaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Repository()
public class UserLoginDao extends BaseDao {

    /**
     * to get the user information while logging in.
     *
     * @param username --- username
     * @return -- CreateUserDTO
     */
    @Transactional(readOnly = true)
    public CreateUserDTO login(String username) {
        String query = properties.getProperty("CommonDao.login");
        org.hibernate.Query hQuery = hibernateQuery(query, CreateUserDTO.class);
        hQuery.setParameter("username", username);
        return (CreateUserDTO) hQuery.uniqueResult();
    }

    //endregion
}
