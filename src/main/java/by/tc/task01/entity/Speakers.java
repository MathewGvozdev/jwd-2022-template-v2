package by.tc.task01.entity;

import by.tc.task01.entity.builder.SpeakersBuilder;
import by.tc.task01.entity.criteria.SearchCriteria;

public class Speakers extends Appliance{

    private Integer powerConsumption;
    private Integer numberOfSpeakers;
    private String frequencyRange;
    private Integer cordLength;

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public Integer getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public Integer getCordLength() {
        return cordLength;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":\n" +
                String.format("%s = %d\n", SearchCriteria.Speakers.POWER_CONSUMPTION, powerConsumption) +
                String.format("%s = %d\n", SearchCriteria.Speakers.NUMBER_OF_SPEAKERS, numberOfSpeakers) +
                String.format("%s = %s\n", SearchCriteria.Speakers.FREQUENCY_RANGE, frequencyRange) +
                String.format("%s = %d\n", SearchCriteria.Speakers.CORD_LENGTH, cordLength);
    }

    public static class Builder implements SpeakersBuilder {
        private final Speakers speakers;

        public Builder(){
            speakers = new Speakers();
        }

        @Override
        public Builder price(Double price){
            speakers.setPrice(price);
            return this;
        }

        @Override
        public Builder powerConsumption(Integer powerConsumption){
            speakers.powerConsumption = powerConsumption;
            return this;
        }

        @Override
        public Builder numberOfSpeakers(Integer numberOfSpeakers) {
            speakers.numberOfSpeakers = numberOfSpeakers;
            return this;
        }

        @Override
        public Builder frequencyRange(String frequencyRange) {
            speakers.frequencyRange = frequencyRange.toUpperCase();
            return this;
        }

        @Override
        public Builder cordLength(Integer cordLength) {
            speakers.cordLength = cordLength;
            return this;
        }

        @Override
        public Speakers build() {
            return speakers;
        }
    }
}
