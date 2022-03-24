package by.tc.task01.entity;

import java.util.Objects;

public class VacuumCleaner extends Appliance {

    private final Integer powerConsumption;
    private final String filterType;
    private final String bagType;
    private final String wandType;
    private final Integer motorSpeedRegulation;
    private final Integer cleaningWidth;

    public VacuumCleaner(Builder builder) {
        super(builder.price);
        powerConsumption = builder.powerConsumption;
        filterType = builder.filterType;
        bagType = builder.bagType;
        wandType = builder.wandType;
        motorSpeedRegulation = builder.motorSpeedRegulation;
        cleaningWidth = builder.cleaningWidth;
    }

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public Integer getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public Integer getCleaningWidth() {
        return cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return Objects.equals(powerConsumption, that.powerConsumption) &&
                Objects.equals(filterType, that.filterType) &&
                Objects.equals(bagType, that.bagType) &&
                Objects.equals(wandType, that.wandType) &&
                Objects.equals(motorSpeedRegulation, that.motorSpeedRegulation) &&
                Objects.equals(cleaningWidth, that.cleaningWidth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth);
    }

    @Override
    public String toString() {
        return String.format("%s:\n%s = %d\n%s = %s\n%s = %s\n%s = %s\n%s = %d\n%s = %d\n%s = $%.2f\n",
                this.getClass().getSimpleName(),
                "POWER CONSUMPTION", powerConsumption,
                "FILTER TYPE", filterType.toUpperCase(),
                "BAG TYPE", bagType.toUpperCase(),
                "WAND TYPE", wandType.toUpperCase(),
                "MOTOR SPEED REGULATION", motorSpeedRegulation,
                "CLEANING WIDTH", cleaningWidth,
                "PRICE", getPrice());
    }

    public static class Builder {

        private final Double price;
        private final Integer powerConsumption;
        private final String filterType;
        private String bagType = "X4Y";
        private String wandType = "all-in-one";
        private final Integer motorSpeedRegulation;
        private final Integer cleaningWidth;

        public Builder(Double price,
                       Integer powerConsumption,
                       String filterType,
                       Integer motorSpeedRegulation,
                       Integer cleaningWidth) {
            this.price = price;
            this.powerConsumption = powerConsumption;
            this.filterType = filterType;
            this.motorSpeedRegulation = motorSpeedRegulation;
            this.cleaningWidth = cleaningWidth;
        }

        public Builder bagType(String bagType) {
            this.bagType = bagType;
            return this;
        }

        public Builder wandType(String wandType) {
            this.wandType = wandType;
            return this;
        }

        public VacuumCleaner build() {
            return new VacuumCleaner(this);
        }
    }
}
