package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.utility.CriteriaCounter;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.builder.Director;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO{

	private static final Path pathDB = Path.of("src","main","resources","appliances_db.txt");
	private final Director director = new Director();

	@Override
	public List<Appliance> find(Criteria criteria) {
		List<Appliance> searchedAppliances = new ArrayList<>();
		List<Appliance> appliancesByGroup = findByGroupSearchName(criteria);
		for (Appliance appliance : appliancesByGroup) {
			Appliance applianceByCriteria = findApplianceByCriteria(criteria, appliance);
			if (applianceByCriteria != null) {
				searchedAppliances.add(applianceByCriteria);
			}
		}
		return searchedAppliances;
	}

	public List<Appliance> findByGroupSearchName(Criteria criteria) {
		List<Appliance> appliances = new ArrayList<>();
		try (BufferedReader bufferedReader = Files.newBufferedReader(pathDB)) {
			while (bufferedReader.ready()) {
				String info = bufferedReader.readLine();
				if (info.startsWith(criteria.getGroupSearchName())) {
					appliances.add(director.buildAppliance(info));
				}
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
		return appliances;
	}

	private Appliance findApplianceByCriteria(Criteria criteria, Appliance appliance) {
		Appliance searchedAppliance = null;
		if (CriteriaCounter.countSearchedCriteria(criteria, appliance) == criteria.getCriteria().size()) {
			searchedAppliance = appliance;
		}
		return searchedAppliance;
	}

}