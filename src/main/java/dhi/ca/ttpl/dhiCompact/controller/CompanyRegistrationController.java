package dhi.ca.ttpl.dhiCompact.controller;

import dhi.ca.ttpl.dhiCompact.dto.CompanyRegistrationDTO;
import dhi.ca.ttpl.dhiCompact.service.CompanyRegistrationService;
import dhi.ca.ttpl.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nzepa on 4/20/2020.
 */

@Controller
@RequestMapping("/companyRegistration")
public class CompanyRegistrationController {

    @Autowired
    private CompanyRegistrationService companyRegistrationService;

    ResponseMessage responseMessage;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index() {
        return "companyRegistration";
    }

    @ResponseBody
    @RequestMapping(value = "/saveCompanyRegistration", method = RequestMethod.POST)
    public ResponseMessage saveCompanyRegistration(CompanyRegistrationDTO companyRegistrationDTO) throws Exception {
        responseMessage = companyRegistrationService.saveCompanyRegistration(companyRegistrationDTO);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public ResponseMessage getList() throws Exception {
        responseMessage = companyRegistrationService.getList();
        return responseMessage;
    }
}
