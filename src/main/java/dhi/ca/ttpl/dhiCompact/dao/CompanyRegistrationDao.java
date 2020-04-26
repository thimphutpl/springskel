package dhi.ca.ttpl.dhiCompact.dao;

import dhi.ca.ttpl.dhiCompact.dto.CompanyRegistrationDTO;
import dhi.ca.ttpl.dhiCompact.entity.CompanyRegistration;
import dhi.ca.ttpl.helper.BaseDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nzepa on 4/20/2020.
 */
@Repository
public class CompanyRegistrationDao extends BaseDao {

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void saveCompanyRegistration(CompanyRegistration companyRegistration) {
        em.persist(companyRegistration);
    }

    @Transactional(readOnly = true)
    public List<CompanyRegistrationDTO> getList() {
        String sqlQuery = properties.getProperty("ChargeAllocationDao.getList");
        Query hQuery = hibernateQuery(sqlQuery, CompanyRegistrationDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }
}
