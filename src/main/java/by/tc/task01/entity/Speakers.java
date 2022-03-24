package by.tc.task01.entity;

import java.util.Objects;

public class Speakers extends Appliance {

    private final Integer powerConsumption;
    private final Integer numberOfSpeakers;
    private final String frequencyRange;
    private final Integer cordLength;

    public Speakers(Builder builder) {
        super(builder.price);
        powerConsumption = builder.powerConsumption;
        numberOfSpeakers = builder.numberOfSpeakers;
        frequencyRange = builder.frequencyRange;
        cordLength = builder.cordLength;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speakers speakers = (Speakers) o;
        return Objects.equals(powerConsumption, speakers.powerConsumption) &&
                Objects.equals(numberOfSpeakers, speakers.numberOfSpeakers) &&
                Objects.equals(frequencyRange, speakers.frequencyRange) &&
                Objects.equals(cordLength, speakers.cordLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, numberOfSpeakers, frequencyRange, cordLength);
    }

    @Override
    public String toString() {
        return String.format("%s:\n%s = %d\n%s = %d\n%s = %s\n%s = %d\n%s = $%.2f\n",
                this.getClass().getSimpleName(),
                "POWER CONSUMPTION", powerConsumption,
                "NUMBER OF SPEAKERS", numberOfSpeakers,
                "FREQUENCY RANGE", frequencyRange,
                "CORD LENGTH", cordLength,
                "PRICE", getPrice());
    }

    public static class Builder {

        private final Double price;
        private final Integer powerConsumption;
        private Integer numberOfSpeakers = 2;
        private final String frequencyRange;
        private Integer cordLength = 1;

        public Builder(Double price,
                       Integer powerConsumption,
                       String frequencyRange) {
            this.price = price;
            this.powerConsumption = powerConsumption;
            this.frequencyRange = frequencyRange;
        }

        public Builder numberOfSpeakers(Integer numberOfSpeakers) {
            this.numberOfSpeakers = numberOfSpeakers;
            return this;
        }

        public Builder cordLength(Integer cordLength) {
            this.cordLength = cordLength;
            return this;
        }

        public Speakers build() {
            return new Speakers(this);
        }
    }
}
