package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.CriteriaValidationException;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.impl.validation.CriteriaValidator;
import by.tc.task01.service.impl.validation.ValidationResult;
import by.tc.task01.utility.CompareOption;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {

    private final CriteriaValidator criteriaValidator = CriteriaValidator.getInstance();

    @Override
    public List<Appliance> find(Criteria criteria) {
        ValidationResult validationResult = criteriaValidator.isValid(criteria);
        if (!validationResult.isValid()) {
            throw new CriteriaValidationException(validationResult.getErrors());
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        List<Appliance> appliances = applianceDAO.find(criteria);

        return appliances;
    }

    @Override
    public List<Appliance> find(Criteria criteria, CompareOption option) {
        ValidationResult validationResult = criteriaValidator.isValid(criteria);
        if (!validationResult.isValid()) {
            throw new CriteriaValidationException(validationResult.getErrors());
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        List<Appliance> appliances = applianceDAO.find(criteria, option);

        return appliances;
    }

}
