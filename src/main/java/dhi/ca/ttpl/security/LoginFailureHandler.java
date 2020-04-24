
package dhi.ca.ttpl.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by jigme.dorji on 23/04/2020.
 */
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    //region public method
    public LoginFailureHandler(String defaultFailureUrl) {
        this.setDefaultFailureUrl(defaultFailureUrl);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        super.onAuthenticationFailure(request, response, exception);

        if (exception instanceof BadCredentialsException) {

            String username = request.getParameter("username");
            String workStationIp = request.getRemoteAddr();

        }
    }
    //endregion
}
