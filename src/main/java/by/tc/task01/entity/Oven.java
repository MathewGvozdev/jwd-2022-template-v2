package by.tc.task01.entity;

import java.util.Objects;

public class Oven extends Appliance {

    private final Integer powerConsumption;
    private final Integer weight;
    private final Integer capacity;
    private final Integer depth;
    private final Double height;
    private final Double width;

    public Oven(Builder builder) {
        super(builder.price);
        powerConsumption = builder.powerConsumption;
        weight = builder.weight;
        capacity = builder.capacity;
        depth = builder.depth;
        height = builder.height;
        width = builder.width;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oven oven = (Oven) o;
        return Objects.equals(powerConsumption, oven.powerConsumption) &&
                Objects.equals(weight, oven.weight) &&
                Objects.equals(capacity, oven.capacity) &&
                Objects.equals(depth, oven.depth) &&
                Objects.equals(height, oven.height) &&
                Objects.equals(width, oven.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, weight, capacity, depth, height, width);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":\n" +
                String.format("POWER CONSUMPTION = %d\n", powerConsumption) +
                String.format("WEIGHT = %d\n", weight) +
                String.format("CAPACITY = %d\n", capacity) +
                String.format("DEPTH = %d\n", depth) +
                String.format("HEIGHT = %.1f\n", height) +
                String.format("WIDTH = %.1f\n", width) +
                String.format("PRICE = $%.2f\n", getPrice());
    }

    public static class Builder {

        private final Double price;
        private final Integer powerConsumption;
        private final Integer weight;
        private final Integer capacity;
        private final Integer depth;
        private final Double height;
        private final Double width;

        public Builder(Double price,
                       Integer powerConsumption,
                       Integer weight,
                       Integer capacity,
                       Integer depth,
                       Double height,
                       Double width) {
            this.price = price;
            this.powerConsumption = powerConsumption;
            this.weight = weight;
            this.capacity = capacity;
            this.depth = depth;
            this.height = height;
            this.width = width;
        }

        public Oven build() {
            return new Oven(this);
        }
    }
}
