package dhi.ca.ttpl.auth.controller;

import dhi.ca.ttpl.auth.dto.UserAccessPermissionDTO;
import dhi.ca.ttpl.auth.dto.UserAccessPermissionListDTO;
import dhi.ca.ttpl.auth.service.UserAccessPermissionService;
import dhi.ca.ttpl.helper.CurrentUser;
import dhi.ca.ttpl.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping(value = "/userAccessPermission")
public class UserAccessPermissionController {

    @Autowired
    private UserAccessPermissionService userAccessPermissionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("userRoleList", userAccessPermissionService.getUserRoleList());
        return "auth/userAccessPermissionSetup";
    }

    @ResponseBody
    @RequestMapping(value = "/getScreenList", method = RequestMethod.GET)
    public List<UserAccessPermissionListDTO> getScreenList(Integer roleTypeId) {
        return userAccessPermissionService.getScreenList(roleTypeId);
    }


    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseMessage save(UserAccessPermissionDTO userAccessPermissionDTO, HttpServletRequest request) throws
            IOException {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        return userAccessPermissionService.save(userAccessPermissionDTO, currentUser);
    }

}
