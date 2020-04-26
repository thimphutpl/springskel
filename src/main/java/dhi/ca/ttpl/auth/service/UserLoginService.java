
package dhi.ca.ttpl.auth.service;

import dhi.ca.ttpl.auth.dao.UserLoginDao;
import dhi.ca.ttpl.auth.dto.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Service("userLoginService")
public class UserLoginService {
    //region private dao
    @Autowired
    UserLoginDao userLoginDao;
    //endregion

    //region public method

    /**
     * to get user information while logging in.
     *
     * @param username username
     * @return CreateUserDTO
     */
    public CreateUserDTO login(String username) {
        return userLoginDao.login(username);
    }

}
