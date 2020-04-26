package dhi.ca.ttpl.auth.controller;

import dhi.ca.ttpl.auth.dto.ChangePasswordDTO;
import dhi.ca.ttpl.auth.service.ChangePasswordService;
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

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping(value = "/changePassword")
public class ChangePasswordController {

    @Autowired
    private ChangePasswordService changePasswordService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request) {
        CurrentUser currentUser = (CurrentUser) request.getSession()
                .getAttribute("currentUser");
        model.addAttribute("userId", currentUser.getLoginId());
        return "auth/changePassword";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseMessage save(ChangePasswordDTO changePasswordDTO) throws
            Exception {
        return changePasswordService.save(changePasswordDTO);
    }
}
