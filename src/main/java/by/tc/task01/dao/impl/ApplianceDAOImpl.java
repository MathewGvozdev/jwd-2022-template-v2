package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.builder.ApplianceBuilder;
import by.tc.task01.dao.parser.DBParser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.dao.builder.impl.Director;
import by.tc.task01.entity.criteria.Criteria;

import java.util.ArrayList;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO{

	private static final ApplianceDAOImpl INSTANCE = new ApplianceDAOImpl();

	private final Director director = Director.getInstance();
	private final DBParser dbParser = DBParser.getInstance();

	private ApplianceDAOImpl() {
	}

	@Override
	public List<Appliance> find(Criteria criteria) {
		List<Appliance> searchedAppliances = new ArrayList<>();
		List<Appliance> appliancesByGroup = findByGroupSearchName(criteria);
		for (Appliance appliance : appliancesByGroup) {
			if (criteria.isMatches(appliance)) {
				searchedAppliances.add(appliance);
			}
		}
		return searchedAppliances;
	}

	public List<Appliance> findByGroupSearchName(Criteria criteria) {
		List<Appliance> appliancesByGroup = new ArrayList<>();
		for (String applianceInfo : dbParser.getDatabaseLinesByGroup(criteria.getGroupSearchName())) {
			ApplianceBuilder applianceBuilder = director.defineBuilderFromDB(applianceInfo);
			appliancesByGroup.add(director.build(applianceBuilder));
		}
		return appliancesByGroup;
	}

	public static ApplianceDAOImpl getInstance() {
		return INSTANCE;
	}
}