package by.tc.task01.dao.builder;

import by.tc.task01.dao.parser.DBParser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

import static by.tc.task01.dao.parser.DBParser.*;

public class SpeakersBuilder implements ApplianceBuilder{

    private final String specificationFromDB;

    public SpeakersBuilder(String specificationFromDB) {
        this.specificationFromDB = specificationFromDB;
    }

    @Override
    public Appliance build() {
        Map<String, Object> specifications = DBParser.parseLineToSpecification(specificationFromDB);

        Double price = objToDouble(specifications, SearchCriteria.Appliance.PRICE.toString());
        Integer powerConsumption = objToInt(specifications, SearchCriteria.Speakers.POWER_CONSUMPTION.toString());
        Integer numberOfSpeakers = objToInt(specifications, SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString());
        String frequencyRange = objToString(specifications, SearchCriteria.Speakers.FREQUENCY_RANGE.toString());
        Integer cordLength = objToInt(specifications, SearchCriteria.Speakers.CORD_LENGTH.toString());

        return new Speakers.Builder(price, powerConsumption, frequencyRange)
                .numberOfSpeakers(numberOfSpeakers)
                .cordLength(cordLength)
                .build();
    }
}
