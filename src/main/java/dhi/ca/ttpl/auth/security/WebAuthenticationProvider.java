
package dhi.ca.ttpl.auth.security;

import dhi.ca.ttpl.auth.dto.CreateUserDTO;
import dhi.ca.ttpl.auth.dto.UserAccessPermissionListDTO;
import dhi.ca.ttpl.auth.service.UserAccessPermissionService;
import dhi.ca.ttpl.auth.service.UserLoginService;
import dhi.ca.ttpl.enumeration.LoginErrorCode;
import dhi.ca.ttpl.enumeration.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
public class WebAuthenticationProvider implements AuthenticationProvider {
    //region private variable
    @Autowired
    private PasswordEncoder passwordEncoder;
    //endregion

    //region private service
    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private UserAccessPermissionService userAccessPermissionService;
    //endregion

    //region public method

    /**
     * It processes authentication information
     *
     * @param authentication authentication
     * @return Authentication
     * @throws org.springframework.security.core.AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;

        String username = String.valueOf(auth.getPrincipal());
        username = username.trim().toUpperCase();
        String password = String.valueOf(auth.getCredentials());

        CreateUserDTO userLogin = userLoginService.login(username);
        if (userLogin == null) {
            throw new UsernameNotFoundException(LoginErrorCode.FAILED.getCode());
        } else if (!userLogin.getUserStatus().equals('A')) {
            throw new LockedException(LoginErrorCode.LOCKED.getCode());
        } else if (passwordEncoder.matches(password, userLogin.getTxtPassword())) {
            Collection<GrantedAuthority> authorities = getAccessRight(userLogin);
            return new UsernamePasswordAuthenticationToken(userLogin, userLogin.getTxtPassword(), authorities);
        } else {
            throw new BadCredentialsException(LoginErrorCode.FAILED.getCode());
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UsernamePasswordAuthenticationToken.class);
    }

    /**
     * It supplies authorization information according to user group
     *
     * @return Set
     */
    private Collection<GrantedAuthority> getAccessRight(CreateUserDTO createUserDTO) {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        List<UserAccessPermissionListDTO> userAccessPermissionListDTOList = userAccessPermissionService
                .getUserAccessPermissionDetails(createUserDTO.getRoleTypeId());
        userAccessPermissionListDTOList.forEach(userAccessPermissionListDTO -> {
            Integer screenId = userAccessPermissionListDTO.getScreenId();
            //Screen permission
            if (userAccessPermissionListDTO.getIsScreenAccessAllowed()) {
                authorities.add(new SimpleGrantedAuthority(screenId + "-" + Permission.VIEW));
            }
            if (userAccessPermissionListDTO.getIsDeleteAccessAllowed()) {
                authorities.add(new SimpleGrantedAuthority(screenId + "-" + Permission.DELETE));
            }
            if (userAccessPermissionListDTO.getIsEditAccessAllowed()) {
                authorities.add(new SimpleGrantedAuthority(screenId + "-" + Permission.EDIT));
            }
            if (userAccessPermissionListDTO.getIsSaveAccessAllowed()) {
                authorities.add(new SimpleGrantedAuthority(userAccessPermissionListDTO.getScreenId() + "-" + Permission.ADD));
            }
        });
        return authorities;
    }
    //endregion
}
