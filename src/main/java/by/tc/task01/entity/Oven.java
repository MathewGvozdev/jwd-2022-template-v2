package by.tc.task01.entity;

import by.tc.task01.entity.builder.OvenBuilder;
import by.tc.task01.entity.criteria.SearchCriteria;

public class Oven extends Appliance {

    private Integer powerConsumption;
    private Integer weight;
    private Integer capacity;
    private Integer depth;
    private Double height;
    private Double width;

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getDepth() {
        return depth;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":\n" +
                String.format("%s = %d\n", SearchCriteria.Oven.POWER_CONSUMPTION, powerConsumption) +
                String.format("%s = %d\n", SearchCriteria.Oven.WEIGHT, weight) +
                String.format("%s = %d\n", SearchCriteria.Oven.CAPACITY, capacity) +
                String.format("%s = %d\n", SearchCriteria.Oven.DEPTH, depth) +
                String.format("%s = %.1f\n", SearchCriteria.Oven.HEIGHT, height) +
                String.format("%s = %.1f\n", SearchCriteria.Oven.WIDTH, width);
    }

    public static class Builder implements OvenBuilder {
        private final Oven oven;

        public Builder(){
            oven = new Oven();
        }

        @Override
        public Builder price(Double price){
            oven.setPrice(price);
            return this;
        }

        @Override
        public Builder powerConsumption(Integer powerConsumption){
            oven.powerConsumption = powerConsumption;
            return this;
        }

        @Override
        public Builder weight(Integer weight) {
            oven.weight = weight;
            return this;
        }

        @Override
        public Builder capacity(Integer capacity) {
            oven.capacity = capacity;
            return this;
        }

        @Override
        public Builder depth(Integer depth) {
            oven.depth = depth;
            return this;
        }

        @Override
        public Builder height(Double height) {
            oven.height = height;
            return this;
        }

        @Override
        public Builder width(Double width) {
            oven.width = width;
            return this;
        }

        @Override
        public Oven build() {
            return oven;
        }
    }
}
