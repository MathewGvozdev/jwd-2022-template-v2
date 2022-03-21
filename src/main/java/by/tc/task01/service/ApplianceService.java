package by.tc.task01.service;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.utility.CompareOption;

import java.util.List;

public interface ApplianceService {

    List<Appliance> find(Criteria criteria);

    List<Appliance> find(Criteria criteria, CompareOption option);
}
