package dhi.ca.ttpl.dhiCompact.service;

import dhi.ca.ttpl.dhiCompact.dao.CompanyRegistrationDao;
import dhi.ca.ttpl.dhiCompact.dto.CompanyRegistrationDTO;
import dhi.ca.ttpl.dhiCompact.entity.CompanyRegistration;
import dhi.ca.ttpl.enumeration.SystemDataInt;
import dhi.ca.ttpl.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nzepa on 4/20/2020.
 */
@Service
public class CompanyRegistrationService {
    @Autowired
    CompanyRegistrationDao companyRegistrationDao;

    public ResponseMessage saveCompanyRegistration(CompanyRegistrationDTO companyRegistrationDTO) {
        ResponseMessage responseMessage = new ResponseMessage();
        CompanyRegistration companyRegistration = new CompanyRegistration();

        companyRegistration.setCompanyId(companyRegistrationDTO.getCompanyId());
        companyRegistration.setCompanyName(companyRegistrationDTO.getCompanyName());

        companyRegistrationDao.saveCompanyRegistration(companyRegistration);
        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        responseMessage.setText("Saved Successfully");
        return responseMessage;
    }

    public ResponseMessage getList() {
        ResponseMessage responseMessage = new ResponseMessage();
        List<CompanyRegistrationDTO> companyRegistrationDTOs = companyRegistrationDao.getList();
        if (companyRegistrationDTOs != null) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setDTO(companyRegistrationDTOs);
        }
        return responseMessage;
    }
}
