/**
 * Created by jigme.dorji on 23/04/2020.
 */
package dhi.ca.ttpl.auth.controller;

import dhi.ca.ttpl.auth.dto.CreateUserDTO;
import dhi.ca.ttpl.helper.CurrentUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//@RequestMapping(value = "/")
@PreAuthorize("isAuthenticated()")
public class HomeController {
    /**
     * home controller
     *
     * @param request  request
     * @param response response
     *                 //     * @param authentication authentication
     * @return ModelAndView
     */
    @RequestMapping(value = {"/", "home"})
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        CreateUserDTO userLoginDTO = (CreateUserDTO) authentication.getPrincipal();

        CurrentUser currentUser = new CurrentUser();
        currentUser.setLoginId(userLoginDTO.getLoginId());
        currentUser.setCreatedDate(userLoginDTO.getCreatedDate());
        currentUser.setTxtUserName(userLoginDTO.getTxtUserName());
        currentUser.setUserStatus(userLoginDTO.getUserStatus());
        currentUser.setRoleTypeId(userLoginDTO.getRoleTypeId());

        request.getSession().setAttribute("currentUser", currentUser);
        String viewPasswordExpiredNotice = (String) request.getSession().getAttribute("viewPasswordExpiredNotice");

        if (viewPasswordExpiredNotice == null) {
            int remainingDays = 0;
            request.getSession().setAttribute("viewPasswordExpiredNotice", String.valueOf(remainingDays));

            if (remainingDays > 0) {
                modelAndView.addObject("passwordExpiredNotice", "After " + remainingDays + " days, you will have to " +
                        "change password.");
            }
        }
        modelAndView.setViewName("home");
        return modelAndView;
    }
}