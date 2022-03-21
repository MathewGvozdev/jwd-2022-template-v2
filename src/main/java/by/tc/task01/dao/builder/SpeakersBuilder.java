package by.tc.task01.dao.builder;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.SearchCriteria;

public class SpeakersBuilder extends ApplianceBuilder {

    public SpeakersBuilder(String applianceInfoFromDB) {
        super(applianceInfoFromDB);
    }

    @Override
    public Appliance build() {
        Double price = getDoubleValueFromDB(SearchCriteria.Speakers.PRICE.toString());
        Integer powerConsumption = getIntValueFromDB(SearchCriteria.Speakers.POWER_CONSUMPTION.toString());
        Integer numberOfSpeakers = getIntValueFromDB(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString());
        String frequencyRange = getStringValueFromDB(SearchCriteria.Speakers.FREQUENCY_RANGE.toString());
        Integer cordLength = getIntValueFromDB(SearchCriteria.Speakers.CORD_LENGTH.toString());

        return new Speakers.Builder(price, powerConsumption, frequencyRange)
                .numberOfSpeakers(numberOfSpeakers)
                .cordLength(cordLength)
                .build();
    }
}
