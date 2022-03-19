package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.exception.CriteriaValidationException;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.POWER_CONSUMPTION.toString(), 1000);

		appliances = service.find(criteriaOven);

		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), 45);
		criteriaOven.add(Oven.DEPTH.toString(), 60);

		appliances = service.find(criteriaOven);

		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "blue");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000);
		criteriaTabletPC.add(SearchCriteria.Appliance.PRICE.toString(), 100.50);

		appliances = service.find(criteriaTabletPC);// find(Object...obj)

		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

		Criteria criteriaLaptop = new Criteria(Laptop.class.getSimpleName());
		criteriaLaptop.add("OSA", "windows");

		try {
			appliances = service.find(criteriaLaptop);
			PrintApplianceInfo.print(appliances);
		} catch (CriteriaValidationException e) {
			System.out.println(e.getMessage());
		}
	}
}
