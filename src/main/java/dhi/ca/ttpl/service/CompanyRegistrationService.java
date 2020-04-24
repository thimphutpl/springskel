//package dhi.ca.ttpl.service;
//
//import dhi.ca.ttpl.dao.CompanyRegistrationDao;
//import dhi.ca.ttpl.dto.CompanyRegistrationDTO;
//import dhi.ca.ttpl.entity.CompanyRegistration;
//import dhi.ca.ttpl.enumeration.SystemDataInt;
//import dhi.ca.ttpl.library.helper.ResponseMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * Created by nzepa on 4/20/2020.
// */
//@Service("companyRegistrationService")
//public class CompanyRegistrationService {
//
//    @Autowired
//    CompanyRegistrationDao companyRegistrationDao;
//
//    public ResponseMessage saveCompanyRegistration(CompanyRegistrationDTO companyRegistrationDTO) {
//        ResponseMessage responseMessage = new ResponseMessage();
//        CompanyRegistration companyRegistration = new CompanyRegistration();
//
//        companyRegistration.setCompanyId(companyRegistrationDTO.getCompanyId());
//        companyRegistration.setCompanyName(companyRegistrationDTO.getCompanyName());
//
//        companyRegistrationDao.saveCompanyRegistration(companyRegistration);
//        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
//        responseMessage.setText("Saved Successfully");
//        return responseMessage;
//    }
//
//    public ResponseMessage getList() {
//        ResponseMessage responseMessage = new ResponseMessage();
//        List<CompanyRegistrationDTO> companyRegistrationDTOs = companyRegistrationDao.getList();
//        if (companyRegistrationDTOs != null) {
//            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
//            responseMessage.setDTO(companyRegistrationDTOs);
//        }
//        return responseMessage;
//    }
//}
