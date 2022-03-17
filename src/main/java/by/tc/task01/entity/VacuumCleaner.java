package by.tc.task01.entity;

import by.tc.task01.entity.builder.VacuumCleanerBuilder;
import by.tc.task01.entity.criteria.SearchCriteria;

public class VacuumCleaner extends Appliance{

    private Integer powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private Integer motorSpeedRegulation;
    private Integer cleaningWidth;

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
    public String toString() {
        return this.getClass().getSimpleName() + ":\n" +
                String.format("%s = %d\n", SearchCriteria.VacuumCleaner.POWER_CONSUMPTION, powerConsumption) +
                String.format("%s = %s\n", SearchCriteria.VacuumCleaner.FILTER_TYPE, filterType) +
                String.format("%s = %s\n", SearchCriteria.VacuumCleaner.BAG_TYPE, bagType) +
                String.format("%s = %s\n", SearchCriteria.VacuumCleaner.WAND_TYPE, wandType) +
                String.format("%s = %d\n", SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION, motorSpeedRegulation) +
                String.format("%s = %d\n", SearchCriteria.VacuumCleaner.CLEANING_WIDTH, cleaningWidth);
    }

    public static class Builder implements VacuumCleanerBuilder {
        private final VacuumCleaner vacuumCleaner;

        public Builder(){
            vacuumCleaner = new VacuumCleaner();
        }

        @Override
        public Builder price(Double price){
            vacuumCleaner.setPrice(price);
            return this;
        }

        @Override
        public Builder powerConsumption(Integer powerConsumption){
            vacuumCleaner.powerConsumption = powerConsumption;
            return this;
        }

        @Override
        public Builder filterType(String filterType) {
            vacuumCleaner.filterType = filterType.toUpperCase();
            return this;
        }

        @Override
        public Builder bagType(String bagType) {
            vacuumCleaner.bagType = bagType.toUpperCase();
            return this;
        }

        @Override
        public Builder wandType(String wandType) {
            vacuumCleaner.wandType = wandType.toUpperCase();
            return this;
        }

        @Override
        public Builder motorSpeedRegulation(Integer motorSpeedRegulation) {
            vacuumCleaner.motorSpeedRegulation = motorSpeedRegulation;
            return this;
        }

        @Override
        public Builder cleaningWidth(Integer cleaningWidth) {
            vacuumCleaner.cleaningWidth = cleaningWidth;
            return this;
        }

        @Override
        public VacuumCleaner build() {
            return vacuumCleaner;
        }
    }
}
