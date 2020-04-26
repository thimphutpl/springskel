
package dhi.ca.ttpl.auth.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
public class WebAccessDeniedHandler implements AccessDeniedHandler {
    //region private variable
    private String accessDeniedUrl;
    //endregion

    //region public method
    public void setAccessDeniedUrl(String accessDeniedUrl) {
        this.accessDeniedUrl = accessDeniedUrl;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws
            IOException, ServletException {
        String url = request.getServletPath();
        response.sendRedirect(accessDeniedUrl);
    }
    //endregion
}
