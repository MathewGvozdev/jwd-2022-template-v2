package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.utility.CompareOption;

import java.util.List;

public interface ApplianceDAO {

    List<Appliance> find(Criteria criteria);
}
