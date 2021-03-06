
package dhi.ca.ttpl.auth.security;

import dhi.ca.ttpl.auth.dto.CreateUserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    //region public method
    public LogoutSuccessHandler(String defaultTargetUrl) {
        this.setDefaultTargetUrl(defaultTargetUrl);
    }


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        super.onLogoutSuccess(request, response, authentication);
        CreateUserDTO user = (CreateUserDTO) authentication.getPrincipal();

    }
    //endregion
}
