package by.tc.task01.entity;

import by.tc.task01.entity.builder.RefrigeratorBuilder;
import by.tc.task01.entity.criteria.SearchCriteria;

public class Refrigerator extends Appliance{

    private Integer powerConsumption;
    private Integer weight;
    private Integer freezerCapacity;
    private Double overallCapacity;
    private Integer height;
    private Integer width;

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getFreezerCapacity() {
        return freezerCapacity;
    }

    public Double getOverallCapacity() {
        return overallCapacity;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":\n" +
                String.format("%s = %d\n", SearchCriteria.Refrigerator.POWER_CONSUMPTION, powerConsumption) +
                String.format("%s = %d\n", SearchCriteria.Refrigerator.WEIGHT, weight) +
                String.format("%s = %d\n", SearchCriteria.Refrigerator.FREEZER_CAPACITY, freezerCapacity) +
                String.format("%s = %.1f\n", SearchCriteria.Refrigerator.OVERALL_CAPACITY, overallCapacity) +
                String.format("%s = %d\n", SearchCriteria.Refrigerator.HEIGHT, height) +
                String.format("%s = %d\n", SearchCriteria.Refrigerator.WIDTH, width);
    }

    public static class Builder implements RefrigeratorBuilder {
        private final Refrigerator refrigerator;

        public Builder(){
            refrigerator = new Refrigerator();
        }

        @Override
        public Builder price(Double price){
            refrigerator.setPrice(price);
            return this;
        }

        @Override
        public Builder powerConsumption(Integer powerConsumption){
            refrigerator.powerConsumption = powerConsumption;
            return this;
        }

        @Override
        public Builder weight(Integer weight) {
            refrigerator.weight = weight;
            return this;
        }

        @Override
        public Builder freezerCapacity(Integer freezerCapacity) {
            refrigerator.freezerCapacity = freezerCapacity;
            return this;
        }

        @Override
        public Builder overallCapacity(Double overallCapacity) {
            refrigerator.overallCapacity = overallCapacity;
            return this;
        }

        @Override
        public Builder height(Integer height) {
            refrigerator.height = height;
            return this;
        }

        @Override
        public Builder width(Integer width) {
            refrigerator.width = width;
            return this;
        }

        @Override
        public Refrigerator build() {
            return refrigerator;
        }
    }
}
