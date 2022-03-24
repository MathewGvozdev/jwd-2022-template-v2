package by.tc.task01.entity;

import java.util.Objects;

public class Refrigerator extends Appliance {

    private final Integer powerConsumption;
    private final Integer weight;
    private final Integer freezerCapacity;
    private final Double overallCapacity;
    private final Integer height;
    private final Integer width;

    public Refrigerator(Builder builder) {
        super(builder.price);
        powerConsumption = builder.powerConsumption;
        weight = builder.weight;
        freezerCapacity = builder.freezerCapacity;
        overallCapacity = builder.overallCapacity;
        height = builder.height;
        width = builder.width;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refrigerator that = (Refrigerator) o;
        return Objects.equals(powerConsumption, that.powerConsumption) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(freezerCapacity, that.freezerCapacity) &&
                Objects.equals(overallCapacity, that.overallCapacity) &&
                Objects.equals(height, that.height) &&
                Objects.equals(width, that.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
    }

    @Override
    public String toString() {
        return String.format("%s:\n%s = %d\n%s = %d\n%s = %d\n%s = %.1f\n%s = %d\n%s = %d\n%s = $%.2f\n",
                this.getClass().getSimpleName(),
                "POWER CONSUMPTION", powerConsumption,
                "WEIGHT", weight,
                "FREEZER CAPACITY", freezerCapacity,
                "OVERALL CAPACITY", overallCapacity,
                "HEIGHT", height,
                "WIDTH", width,
                "PRICE", getPrice());
    }

    public static class Builder {

        private final Double price;
        private final Integer powerConsumption;
        private final Integer weight;
        private final Integer freezerCapacity;
        private final Double overallCapacity;
        private final Integer height;
        private final Integer width;

        public Builder(Double price,
                       Integer powerConsumption,
                       Integer weight,
                       Integer freezerCapacity,
                       Double overallCapacity,
                       Integer height,
                       Integer width) {
            this.price = price;
            this.powerConsumption = powerConsumption;
            this.weight = weight;
            this.freezerCapacity = freezerCapacity;
            this.overallCapacity = overallCapacity;
            this.height = height;
            this.width = width;
        }

        public Refrigerator build() {
            return new Refrigerator(this);
        }
    }
}
